package com.abc.xyz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.abc.xyz.entity.ImageProduct;

@Repository
public interface ImageProductRepository extends JpaRepository<ImageProduct, Integer>{
	@Modifying
	@Transactional
	@Query("delete from ImageProduct b where b.product_id=:product_id")
	int deleteImageProduct(@Param("product_id") int product_id);
}
