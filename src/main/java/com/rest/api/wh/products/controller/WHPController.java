package com.rest.api.wh.products.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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

	@PostMapping("/addProduct")
	public WHPResponse addProduct(@Valid @RequestBody WHProducts product) {
		logger.info("into adding a product api");
		WHPResponse response = new WHPResponse();
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
}
