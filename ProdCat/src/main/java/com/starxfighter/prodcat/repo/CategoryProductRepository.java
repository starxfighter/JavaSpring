package com.starxfighter.prodcat.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.starxfighter.prodcat.models.CategoryProduct;

@Repository
public interface CategoryProductRepository extends CrudRepository<CategoryProduct, Long> {
	
	List<CategoryProduct> findAll();

	List<CategoryProduct> findAllByProduct_id(Long id);
	List<CategoryProduct> findAllByCategory_id(Long id);

	List<CategoryProduct> findAllByProduct_IdNot(Long id);
	
}
