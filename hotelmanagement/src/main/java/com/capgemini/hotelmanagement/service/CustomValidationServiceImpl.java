package com.capgemini.hotelmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hotelmanagement.validation.CustomValidation;

@Service	
public class CustomValidationServiceImpl implements CustomValidationService{
	@Autowired
	private CustomValidation dao;
	
	@Override
	public boolean customEmailValidation(String email) {
		return dao.customEmailValidation(email); 
	}

	@Override
	public boolean customLocationValidation(String location) {
		return dao.customLocationValidation(location);
	}

	@Override
	public boolean customRoomIdValidation(int roomId) {
		return dao.customRoomIdValidation(roomId);
	} 

	@Override
	public boolean customEmployeeEmailValidation(String email) {
		return dao.customEmployeeEmailValidation(email);
	}

	@Override
	public boolean customAdharValidation(String adharNo) {
		return dao.customAdharValidation(adharNo);
	}

	@Override
	public boolean customUserIdValidation(int userId) {
		return dao.customUserIdValidation(userId); 
	}
}
