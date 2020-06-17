package com.codeinitializr.repositories;

import java.util.List;

import com.codeinitializr.models.TransArticle;
import com.codeinitializr.models.TransTopics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * TransArticleRepository
 */
@Repository
public interface TransArticleRepository extends JpaRepository<TransArticle, Long>{

	List<TransArticle> findByTransTopicAndVisibleToInAndIsActiveOrderByDisplayOrderAsc(TransTopics transTopic,
			String[] visibleToList, boolean b);

	TransArticle findBySlugAndVisibleToIn(String topicSlug, String[] visibleToList);

}