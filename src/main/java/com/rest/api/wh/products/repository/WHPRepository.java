package com.rest.api.wh.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.api.wh.products.entity.WHProducts;

public interface WHPRepository extends JpaRepository<WHProducts, Integer>{

	//public WHProducts findByWPId(long wPId);
}
