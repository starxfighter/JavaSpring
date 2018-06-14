package com.starxfighter.license.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.starxfighter.license.models.License;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long>{

	List<License> findAll();
	License findLicenseByPerson_id(Long id);
	License findFirst1ByOrderByNumberDesc();
	
}
