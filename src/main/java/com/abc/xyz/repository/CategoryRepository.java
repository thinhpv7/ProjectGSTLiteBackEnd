package com.abc.xyz.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.abc.xyz.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
//	@Query(value = "select cn from category cn where cn.id=:id")
//    Page<Category> findMajor(@Param("id") int id, Pageable pageable);
}
