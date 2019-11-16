package com.commerce.microservice.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class producintrouvalException extends RuntimeException {


	public producintrouvalException(String string) {
		// TODO Auto-generated constructor stub
		super(string);
	}

}
