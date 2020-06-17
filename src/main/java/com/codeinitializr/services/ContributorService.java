package com.codeinitializr.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.validation.Valid;

import com.codeinitializr.models.TransArticle;
import com.codeinitializr.models.TransTopics;
import com.codeinitializr.payloads.BreadCrumbPayload;
import com.codeinitializr.payloads.JsonResponse;
import com.codeinitializr.payloads.PageableObjectPayload;
import com.codeinitializr.repositories.TransArticleRepository;
import com.codeinitializr.repositories.TransTopicRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ContributorService
 */
@Service
public class ContributorService {

    @Autowired
    TransTopicRepository transTopicRepository;

    @Autowired
    TransArticleRepository transArticleRepository;

    // ========================================================================
    // # METHOD TO GET ALL ACTIVE CHILD TOPICS BY SLUG
    // ========================================================================
    public PageableObjectPayload getAllActiveSubTopicBySlugForContributor(Optional<String> slug) {
        PageableObjectPayload topicData = new PageableObjectPayload();
        List<TransTopics> topicList = new ArrayList<>();
        List<TransArticle> articleList = new ArrayList<>();
        List<BreadCrumbPayload> breadcrumbList = new ArrayList<>();
        BreadCrumbPayload breadCrumb = null;
        TransTopics transTopic = null;

        String[] visibleToList = { "Contributor", "Public" };

        if (slug.isPresent()) {
            String slugString = slug.get();
            transTopic = transTopicRepository.findBySlugAndVisibleToIn(slugString, visibleToList);
            if (!Objects.equals(transTopic, null)) {
                topicList = transTopicRepository.findByParentTopicAndVisibleToInAndIsActiveOrderByDisplayOrderAsc(
                        transTopic, visibleToList, true);

                articleList = transArticleRepository.findByTransTopicAndVisibleToInAndIsActiveOrderByDisplayOrderAsc(
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
        } else {
            topicList = transTopicRepository
                    .findByParentTopicIsNullAndVisibleToInAndIsActiveOrderByDisplayOrderAsc(visibleToList, true);
        }

        topicData.setObjectList(topicList);
        topicData.setObjectList2(articleList);
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

	public PageableObjectPayload getAllObjectsForCreatingArticle(String topicSlug) {
        PageableObjectPayload topicData = new PageableObjectPayload();
        
        String[] visibleToList = { "Contributor", "Public" };

        List<TransTopics> topicList = transTopicRepository.findByIsActiveOrderByNameAsc(true);

        TransTopics transTopic = transTopicRepository.findBySlugAndVisibleToIn(topicSlug, visibleToList);

        List<BreadCrumbPayload> breadcrumbList = new ArrayList<>();
        BreadCrumbPayload breadCrumb = null;

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

        topicData.setCurrentObject(transTopic);
        topicData.setObjectList(topicList);
        topicData.setBreadcrumbList(breadcrumbList);
        return topicData;
    }
    
    public PageableObjectPayload getAllObjectsForUpdatingArticle(String articleSlug, String topicSlug) {
        PageableObjectPayload topicData = new PageableObjectPayload();
        
        String[] visibleToList = { "Contributor", "Public" };

        List<TransTopics> topicList = transTopicRepository.findByIsActiveOrderByNameAsc(true);

        TransTopics transTopic = transTopicRepository.findBySlugAndVisibleToIn(topicSlug, visibleToList);

        TransArticle transArticle = transArticleRepository.findBySlugAndVisibleToIn(articleSlug, visibleToList);

        List<BreadCrumbPayload> breadcrumbList = new ArrayList<>();
        BreadCrumbPayload breadCrumb = null;

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

        topicData.setCurrentObject(transTopic);
        topicData.setCurrentObject2(transArticle);
        topicData.setObjectList(topicList);
        topicData.setBreadcrumbList(breadcrumbList);
        return topicData;
	}

	
    // ========================================================================
    // # METHOD TO CREATE/UPDATE NEW TOPIC
    // ========================================================================
    public JsonResponse createArticle(@Valid TransArticle transArticle) {
        JsonResponse res = new JsonResponse();
        transArticleRepository.save(transArticle);
        String slug = transArticle.getTitle().trim().toLowerCase().replace(" ", "-") + "-"
                + String.valueOf(transArticle.getArticleId());
                transArticle.setSlug(slug);
                transArticleRepository.save(transArticle);
        res.setResult(true);
        return res;
    }

	public JsonResponse deleteArticle(Long articleId) {
        JsonResponse res = new JsonResponse();
        TransArticle transArticle = transArticleRepository.getOne(articleId);
        transArticle.setIsActive(false);
        transArticleRepository.save(transArticle);
        res.setResult(true);
        return res;
    }
}