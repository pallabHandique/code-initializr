package com.codeinitializr.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.validation.Valid;

import com.codeinitializr.models.TransTopics;
import com.codeinitializr.payloads.BreadCrumbPayload;
import com.codeinitializr.payloads.JsonResponse;
import com.codeinitializr.payloads.PageableObjectPayload;
import com.codeinitializr.repositories.TransTopicRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AdminService
 */
@Service
public class AdminService {

    @Autowired
    TransTopicRepository transTopicRepository;

    // ========================================================================
    // # METHOD TO CREATE/UPDATE NEW TOPIC
    // ========================================================================
    public JsonResponse createTopic(@Valid TransTopics transTopic) {
        JsonResponse res = new JsonResponse();
        transTopicRepository.save(transTopic);
        String slug = transTopic.getName().trim().toLowerCase().replace(" ", "-") + "-"
                + String.valueOf(transTopic.getTopicId());
        transTopic.setSlug(slug);
        transTopicRepository.save(transTopic);
        res.setResult(true);
        return res;
    }

    // ========================================================================
    // # METHOD TO GET ALL ACTIVE CHILD TOPICS BY SLUG
    // ========================================================================
    public PageableObjectPayload getAllActiveSubTopicBySlug(Optional<String> slug) {
        PageableObjectPayload topicData = new PageableObjectPayload();
        List<TransTopics> topicList = new ArrayList<>();
        List<BreadCrumbPayload> breadcrumbList = new ArrayList<>();
        BreadCrumbPayload breadCrumb = null;
        TransTopics transTopic = null;

        String[] visibleToList = { "Admin", "Contributor", "Public" };

        if (slug.isPresent()) {
            String slugString = slug.get();
            transTopic = transTopicRepository.findBySlugAndVisibleToIn(slugString, visibleToList);
            if (!Objects.equals(transTopic, null)) {
                topicList = transTopicRepository.findByParentTopicAndVisibleToInAndIsActiveOrderByDisplayOrderAsc(
                        transTopic, visibleToList, true);

                // SET PARENT BREADCRUMPS
                TransTopics parentTopic = transTopic.getParentTopic();
                while (!Objects.equals(parentTopic, null)) {
                    breadCrumb = new BreadCrumbPayload();
                    breadCrumb.setId(parentTopic.getTopicId());
                    breadCrumb.setTitle(parentTopic.getName().toLowerCase());
                    breadCrumb.setSlug(parentTopic.getSlug());

                    breadcrumbList.add(breadCrumb);

                    parentTopic = parentTopic.getParentTopic();
                }
                Collections.reverse(breadcrumbList);
            }
        } 
        else {
            topicList = transTopicRepository
                    .findByParentTopicIsNullAndVisibleToInAndIsActiveOrderByDisplayOrderAsc(visibleToList, true);
        }

        topicData.setObjectList(topicList);
        topicData.setBreadcrumbList(breadcrumbList);
        topicData.setCurrentObject(transTopic);
        return topicData;
    }

    public PageableObjectPayload getAllActiveTopicList() {
        PageableObjectPayload topicData = new PageableObjectPayload();

        List<TransTopics> topicList = transTopicRepository.findByIsActiveOrderByNameAsc(true);

        topicData.setObjectList(topicList);
        return topicData;
    }

    public JsonResponse deleteTopic(Long topicId) {
        JsonResponse res = new JsonResponse();
        TransTopics topic = transTopicRepository.getOne(topicId);
        topic.setIsActive(false);
        transTopicRepository.save(topic);
        res.setResult(true);
        return res;
    }
}