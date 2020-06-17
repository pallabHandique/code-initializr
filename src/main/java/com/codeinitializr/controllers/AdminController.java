package com.codeinitializr.controllers;

import java.util.Objects;
import java.util.Optional;

import javax.validation.Valid;

import com.codeinitializr.exception.BadRequestException;
import com.codeinitializr.models.TransTopics;
import com.codeinitializr.payloads.JsonResponse;
import com.codeinitializr.payloads.PageableObjectPayload;
import com.codeinitializr.services.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * AdminController
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    // ========================================================================
    // # PAGE ADMIN HOME
    // ========================================================================
    @GetMapping("")
    public ModelAndView pageAdminHome(ModelAndView mv) {
        mv = new ModelAndView("admin/home");
        return mv;
    }

    // ========================================================================
    // # PAGE TOPICS
    // ========================================================================
    @GetMapping(value = { "/topic", "/topic/{slug}" })
    public ModelAndView pageTopicView(ModelAndView mv, @PathVariable Optional<String> slug) {
        mv = new ModelAndView("admin/topics");

        PageableObjectPayload subTopicData = adminService.getAllActiveSubTopicBySlug(slug);
        mv.addObject("subTopicData", subTopicData);

        PageableObjectPayload allActiveTopicList = adminService.getAllActiveTopicList();
        mv.addObject("allActiveTopicList", allActiveTopicList);

        return mv;
    }

    // ========================================================================
    // # METHOD TO CREATE/UPDATE NEW TOPIC
    // ========================================================================
    @PostMapping(value = { "/create-topic" })
    public ResponseEntity<JsonResponse> createTopic(@Valid @ModelAttribute TransTopics transTopic) {
        Long topicId = transTopic.getTopicId();

        JsonResponse res = adminService.createTopic(transTopic);

        if (Objects.equals(res.getResult(), true)) {
            if (Objects.equals(topicId, null)) {
                res.setMessage("Topic Created Successfully.");
            } else {
                res.setMessage("Topic Updated Successfully.");
            }
            return ResponseEntity.ok().body(res);
        } else {
            throw new BadRequestException("Operation Failed");
        }
    }

    // ========================================================================
    // # DELETE TOPIC
    // ========================================================================
    @PutMapping(value = { "/delete-topic" })
    public ResponseEntity<JsonResponse> deleteTopic(@RequestParam("topicId") Long topicId) {

        JsonResponse res = adminService.deleteTopic(topicId);

        if (Objects.equals(res.getResult(), true)) {
            res.setMessage("Topic Deleted Successfully.");
            return ResponseEntity.ok().body(res);
        } else {
            throw new BadRequestException("Operation Failed");
        }
    }
}