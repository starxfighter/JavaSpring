package com.starxfighter.dojooverflow.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.starxfighter.dojooverflow.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {

	List<Tag> findAll();

	Tag findBySubject(String tag);
	 
}
