package com.starxfighter.dojooverflow.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.starxfighter.dojooverflow.models.Answer;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {

	List<Answer> findAll();

	List<Answer> findAllByQuestion_id(Long id);
	
}
