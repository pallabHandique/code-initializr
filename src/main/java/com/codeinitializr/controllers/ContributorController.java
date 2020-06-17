package com.codeinitializr.controllers;

import java.util.Objects;
import java.util.Optional;

import javax.validation.Valid;

import com.codeinitializr.exception.BadRequestException;
import com.codeinitializr.models.TransArticle;
import com.codeinitializr.payloads.JsonResponse;
import com.codeinitializr.payloads.PageableObjectPayload;
import com.codeinitializr.services.ContributorService;

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
 * ContributorController
 */
@RestController
@RequestMapping("/contributor")
public class ContributorController {

    @Autowired
    ContributorService contributorService;

    // ========================================================================
    // # PAGE CONTRIBUTOR HOME
    // ========================================================================
    @GetMapping("")
    public ModelAndView pageContributorHome(ModelAndView mv) {
        mv = new ModelAndView("contributor/home");
        return mv;
    }

    // ========================================================================
    // # PAGE TOPICS
    // ========================================================================
    @GetMapping(value = { "/topic", "/topic/{slug}" })
    public ModelAndView pageContributorTopic(ModelAndView mv, @PathVariable Optional<String> slug) {
        mv = new ModelAndView("contributor/topics");

        PageableObjectPayload subTopicData = contributorService.getAllActiveSubTopicBySlugForContributor(slug);
        mv.addObject("subTopicData", subTopicData);

        PageableObjectPayload allActiveTopicList = contributorService.getAllActiveTopicList();
        mv.addObject("allActiveTopicList", allActiveTopicList);

        return mv;
    }

    // ========================================================================
    // # PAGE CREATE ARTICLE
    // ========================================================================
    @GetMapping(value = { "/topic/{topicSlug}/create-article" })
    public ModelAndView createArticle(ModelAndView mv, @PathVariable("topicSlug") String topicSlug) {
        mv = new ModelAndView("contributor/create_update_article");

        PageableObjectPayload topicData = contributorService.getAllObjectsForCreatingArticle(topicSlug);
        mv.addObject("topicData", topicData);

        mv.addObject("page_purpose", "CREATE ARTICLE");
        return mv;
    }

    // ========================================================================
    // # METHOD TO CREATE/UPDATE NEW ARTICLE
    // ========================================================================
    @PostMapping(value = { "/create-article" })
    public ResponseEntity<JsonResponse> createArticle(@Valid @ModelAttribute TransArticle transArticle) {
        Long articleId = transArticle.getArticleId();

        JsonResponse res = contributorService.createArticle(transArticle);

        if (Objects.equals(res.getResult(), true)) {
            if (Objects.equals(articleId, null)) {
                res.setMessage("Article Created Successfully.");
            } else {
                res.setMessage("Article Updated Successfully.");
            }
            return ResponseEntity.ok().body(res);
        } else {
            throw new BadRequestException("Operation Failed");
        }
    }

    // ========================================================================
    // # PAGE UPDATE ARTICLE
    // ========================================================================
    @GetMapping(value = { "/topic/{topicSlug}/update-article/{articleSlug}" })
    public ModelAndView updateArticle(ModelAndView mv, @PathVariable("topicSlug") String topicSlug, @PathVariable("articleSlug") String articleSlug) {
        mv = new ModelAndView("contributor/create_update_article");

        PageableObjectPayload topicData = contributorService.getAllObjectsForUpdatingArticle(articleSlug,topicSlug);
        mv.addObject("topicData", topicData);

        mv.addObject("page_purpose", "UPDATE ARTICLE");
        return mv;
    }

    // ========================================================================
    // # DELETE ARTICLE
    // ========================================================================
    @PutMapping(value = { "/delete-article" })
    public ResponseEntity<JsonResponse> deleteArticle(@RequestParam("articleId") Long articleId) {

        JsonResponse res = contributorService.deleteArticle(articleId);

        if (Objects.equals(res.getResult(), true)) {
            res.setMessage("Article Deleted Successfully.");
            return ResponseEntity.ok().body(res);
        } else {
            throw new BadRequestException("Operation Failed");
        }
    }
}