package com.rest.api.wh.products.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rest.api.wh.products.entity.WHProducts;

@Service
public interface WHPService {

	public ResponseEntity<?> createProduct(WHProducts product);
	public ResponseEntity<?> createProducts(List<WHProducts> products);
	public ResponseEntity<?> getAllProducts();
	public ResponseEntity<?> getProduct(int id);
	//public ResponseEntity<?> getProductByWPId(long wPId);
	public ResponseEntity<?> upteProduct(int id, WHProducts product);
	public ResponseEntity<?> deleteProduct(int id);
}
