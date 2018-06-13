package com.starxfighter.lookify.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.starxfighter.lookify.model.Music;

@Repository
public interface LookifyRepository extends CrudRepository<Music, Long>{
	
	List<Music> findAll();
	List<Music> findByArtistContaining(String search);
	List<Music> findAllByOrderByRatingDesc();
	
}
