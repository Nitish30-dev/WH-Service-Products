package com.rest.api.wh.products.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.wh.products.entity.WHProducts;
import com.rest.api.wh.products.response.WHPResponse;
import com.rest.api.wh.products.service.WHPServiceImpl;

@RestController
@RequestMapping("/products")
public class WHPController {

	private static final Logger logger = LoggerFactory.getLogger(WHPController.class);

	@Value("${server.port}")
	private int port;

	@Value("${spring.application.name}")
	private String appName;

	@Autowired
	private WHPServiceImpl service;

	WHPResponse response = null;

	@PostMapping("/addProduct")
	public WHPResponse addProduct(@Valid @RequestBody WHProducts product) {
		logger.info("into adding a product api");
		response = new WHPResponse();
		try {
			response.setPort(port);
			response.setAppName(appName);
			response.setResponseBody(service.createProduct(product));
			response.setStatusCode(200);
			logger.debug("addedproduct-> " + response);
			return response;
		} catch (Exception e) {
			response.setPort(port);
			response.setAppName(appName);
			response.setResponseBody(ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad request"));
			response.setStatusCode(400);
			return response;

		}
	}

	@PostMapping("/addProducts")
	public WHPResponse addProducts(@Valid @RequestBody List<WHProducts> products) {
		logger.info("into adding products api");
		response = new WHPResponse();
		response.setPort(port);
		response.setAppName(appName);
		response.setResponseBody(service.createProducts(products));
		response.setStatusCode(200);
		logger.debug("addedproducts-> " + response);
		return response;
	}

	@GetMapping("/getAllProducts")
	public WHPResponse getAllProducts() {
		logger.info("into getting all the products api");
		response = new WHPResponse();
		try {
			response.setPort(port);
			response.setAppName(appName);
			response.setResponseBody(service.getAllProducts());
			response.setStatusCode(200);
			logger.debug("all the products-> " + response);
			return response;
		} catch (Exception e) {
			response.setPort(port);
			response.setAppName(appName);
			response.setResponseBody(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Products not found"));
			response.setStatusCode(404);
			return response;
		}
	}

	@GetMapping("/getProduct/{id}")
	public WHPResponse getProduct(@PathVariable("id") int id) {
		logger.info("into getting a product api ");
		response = new WHPResponse();
		response.setPort(id);
		response.setAppName(appName);
		response.setResponseBody(service.getProduct(id));
		response.setStatusCode(200);
		logger.debug("product with id: " + id + " " + response);
		return response;
	}

	@PutMapping("updateProduct/{id}")
	public WHPResponse updateProduct(@PathVariable("id") int id, @Valid @RequestBody WHProducts product) {
		logger.info("into updating a product api");
		response= new WHPResponse();
		response.setPort(id);
		response.setAppName(appName);
		response.setResponseBody(service.updateProduct(id, product));
		response.setStatusCode(200);
		logger.debug("product updated with id: "+id+" "+response);
		return response;
	}
	
	@DeleteMapping("deleteProduct/{id}")
	public WHPResponse deleteProduct(@PathVariable("id") int id) {
		logger.info("into deleting a product api");
		response= new WHPResponse();
		response.setPort(id);
		response.setAppName(appName);
		response.setResponseBody(service.deleteProduct(id));
		response.setStatusCode(200);
		logger.debug("product updated with id: "+id+" "+response);
		return response;
	}
	
	@GetMapping("/getProductByWPId/{wPId}")
	public WHPResponse getProductByWPId(@PathVariable("wPId") long wPId) {
		logger.info("into getting a product with warehouse product id api");
		response= new WHPResponse();
		response.setPort(port);
		response.setAppName(appName);
		response.setResponseBody(service.getProductByWPId(wPId));
		response.setStatusCode(200);
		logger.debug("product with its warehouse product id-> "+wPId+" "+response);
		return response;
	}
}
