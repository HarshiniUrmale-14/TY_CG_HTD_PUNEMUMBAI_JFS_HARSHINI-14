package com.capgemini.hotelmanagement.exception;

@SuppressWarnings("serial")
public class HotelCustomException extends RuntimeException {
	String message;

	public HotelCustomException(String message) {
		super(message);
	}
}
