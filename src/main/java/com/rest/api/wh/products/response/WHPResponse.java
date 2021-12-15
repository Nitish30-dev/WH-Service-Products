package com.rest.api.wh.products.response;

import org.springframework.http.ResponseEntity;

public class WHPResponse {

	private int port;
	private String appName;
	private ResponseEntity<?> responseBody;
	private int statusCode;

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public ResponseEntity<?> getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(ResponseEntity<?> responseBody) {
		this.responseBody = responseBody;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public WHPResponse(int port, String appName, ResponseEntity<?> responseBody, int statusCode) {
		super();
		this.port = port;
		this.appName = appName;
		this.responseBody = responseBody;
		this.statusCode = statusCode;
	}

	public WHPResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
}
