package com.capgemini.hotelmanagement.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.hotelmanagement.beans.ResponseBean;
import com.capgemini.hotelmanagement.exception.HotelCustomException;

@RestControllerAdvice
public class AdviceController {
	
	@ExceptionHandler(HotelCustomException.class)
	public ResponseBean userErrorHandler(HotelCustomException hotel) {
		ResponseBean response = new ResponseBean();

		response.setStatusCode(444);
		response.setMessage("Failure");
		response.setDescription(hotel.getMessage());
		return response;
	}

}
