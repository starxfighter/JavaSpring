package com.starxfighter.authentication.repos;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.starxfighter.authentication.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByEmail(String email);

}
