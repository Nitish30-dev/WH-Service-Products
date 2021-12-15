package com.rest.api.wh.products.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rest.api.wh.products.entity.WHProducts;
import com.rest.api.wh.products.exception.ResourceNotFoundException;
import com.rest.api.wh.products.repository.WHPRepository;

@Service
public class WHPServiceImpl implements WHPService {

	private static final Logger logger = LoggerFactory.getLogger(WHPServiceImpl.class);

	@Autowired
	private WHPRepository repo;

	@Override
	public ResponseEntity<?> createProduct(WHProducts product) {
		logger.info("into create product service");
		logger.info("saving product " + product);
		return ResponseEntity.status(HttpStatus.OK).body(repo.save(product));
	}

	@Override
	public ResponseEntity<?> createProducts(List<WHProducts> products) {
		logger.info("into create products service");
		logger.info("saving products" + products);
		return ResponseEntity.status(HttpStatus.OK).body(repo.saveAll(products));
	}

	@Override
	public ResponseEntity<?> getAllProducts() {
		logger.info("into getting all products");
		List<WHProducts> listOfProducts = repo.findAll();
		if (listOfProducts != null && listOfProducts.size() > 0) {
			logger.info("getting all products " + listOfProducts);
			return ResponseEntity.status(HttpStatus.OK).body(listOfProducts);
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT)
				.body(new ResourceNotFoundException("No resource found in db"));
	}

	@Override
	public ResponseEntity<?> getProduct(int id) {
		logger.info("into getting a product service");
		Optional<WHProducts> prodOpt = Optional.ofNullable(repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("no resource found with given id: " + id)));
		WHProducts product = prodOpt.get();
		if (product != null) {
			logger.info("getting product with given id: " + id + " " + product);
			return ResponseEntity.status(HttpStatus.OK).body(product);
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Product is null");
	}

	/*
	 * @Override public ResponseEntity<?> getProductByWPId(long wPId) {
	 * logger.info("into getting a product with its warehouse product id: " + wPId);
	 * WHProducts product = repo.findByWPId(wPId); if (product != null) {
	 * logger.info("Product with given warehouse product id: " + wPId + " is: " +
	 * product); return ResponseEntity.status(HttpStatus.OK).body(product); } return
	 * ResponseEntity.status(HttpStatus.NO_CONTENT) .body(new
	 * ResourceNotFoundException("No product found with given warehouse product id: "
	 * + wPId)); }
	 */

	@Override
	public ResponseEntity<?> upteProduct(int id,WHProducts product) {
		logger.info("into updating a product service");
		Optional<WHProducts> prodOpt=Optional.ofNullable(repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("no resource found.")));
		WHProducts prod=prodOpt.get();
		if(prod!=null) {
			prod.setId(product.getId()!=0 ? product.getId() : prod.getId());
			prod.setwPId(product.getwPId()!=0 ? product.getwPId() : prod.getwPId());
			prod.setwPName(product.getwPName()!=null ? product.getwPName() : prod.getwPName());
			prod.setwPPrice(product.getwPPrice()!=0 ? product.getwPPrice() : prod.getwPPrice());
			prod.setwPDoE(product.getwPDoE()!=null ? product.getwPDoE() : prod.getwPDoE());
			repo.save(prod);
			logger.info("product with id: "+id+" is "+prod);
			return ResponseEntity.status(HttpStatus.OK).body(prod);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No resource found with given id "+id);
	}

	@Override
	public ResponseEntity<?> deleteProduct(int id) {
		logger.info("into deleting a product service");
		Optional<WHProducts> prodOpt=Optional.ofNullable(repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("no resource found.")));
		WHProducts prod=prodOpt.get();
		repo.delete(prod);
		logger.info("product deleted with id: "+id);
		return ResponseEntity.status(HttpStatus.OK).body("product with given id "+id+" is deleted.");
	}

}
