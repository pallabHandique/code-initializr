package com.codeinitializr.repositories;

import java.util.List;

import com.codeinitializr.models.TransTopics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * TransTopicRepository
 */
@Repository
public interface TransTopicRepository extends JpaRepository<TransTopics, Long>{
	

	List<TransTopics> findByIsActiveOrderByNameAsc(boolean b);

	// List<TransTopics> findByParentTopic_slugAndVisibleToInAndIsActiveOrderByDisplayOrderAsc(String slugString,
	// 		String[] visibleToList, boolean b);

	List<TransTopics> findByParentTopicIsNullAndVisibleToInAndIsActiveOrderByDisplayOrderAsc(String[] visibleToList,
			boolean b);

	TransTopics findBySlugAndVisibleToIn(String slugString, String[] visibleToList);

	List<TransTopics> findByParentTopicAndVisibleToInAndIsActiveOrderByDisplayOrderAsc(TransTopics transTopic,
			String[] visibleToList, boolean b);

    
}