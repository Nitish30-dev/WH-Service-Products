package com.rest.api.wh.products.exception;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class ErrorDTO {

	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy")
	private Date timestamp;
	private String details;
	private String message;

	public ErrorDTO(Date timestamp, String details, String message) {
		super();
		this.timestamp = timestamp;
		this.details = details;
		this.message = message;
	}

	public ErrorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ErrorDTO [timestamp=" + timestamp + ", details=" + details + ", message=" + message + "]";
	}

}
