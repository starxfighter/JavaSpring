package com.starxfighter.dojooverflow.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.starxfighter.dojooverflow.models.TagQuestion;

@Repository
public interface TagQuestionRepository extends CrudRepository<TagQuestion,Long> {

	List<TagQuestion> findAll();
	
	List<TagQuestion> findAllByQuestion_id(Long id);
	List<TagQuestion> findAllByTag_id(Long id);
	
}
