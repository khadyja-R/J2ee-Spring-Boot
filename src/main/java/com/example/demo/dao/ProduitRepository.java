package com.example.demo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Product;

@Repository

public interface ProduitRepository extends JpaRepository<Product,Long> {
   @Query("select p from Product p where p.designation like:x")
	public Page<Product> chercher(@Param("x")String mc , Pageable pageable);
}
