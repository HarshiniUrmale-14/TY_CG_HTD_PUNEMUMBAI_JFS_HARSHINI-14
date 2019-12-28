package com.capgemini.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hotelmanagement.beans.BookingInfoBean;
import com.capgemini.hotelmanagement.beans.RoomInfoBean;
import com.capgemini.hotelmanagement.beans.UserBean;
import com.capgemini.hotelmanagement.dao.ManagementDao;
import com.capgemini.hotelmanagement.exception.HotelCustomException;
import com.capgemini.hotelmanagement.utility.PasswordEncryptor;
import com.capgemini.hotelmanagement.validation.RegexValidation;

@Service
public class ManagementServiceImpl implements ManagementService {
	@Autowired
	private ManagementDao dao;
	
	@Autowired
	private RegexValidation validation;
	
	@Autowired
	private CustomValidationService customValidationService;

	@Override
	public UserBean addAdmin(UserBean bean) {
		
		String userName = bean.getUserName();
		String email = bean.getEmail();
		String phoneNo = bean.getPhoneNo();
		String adharNo = bean.getAdharNo();
		if (validation.nameValidation(userName)) {
			if (validation.emailValidation(email)) {
				if (!customValidationService.customEmailValidation(email)) {
					if (validation.mobileValidation(phoneNo)) {
						if (validation.adharValidation(adharNo)) {
							if(!customValidationService.customAdharValidation(adharNo)) {
								bean.setPassword(PasswordEncryptor.encryptPassword(bean.getPassword()));
								return dao.addAdmin(bean);
							} else {
								throw new HotelCustomException("Entered adhar number is already exist");
							}
						} else {
							throw new HotelCustomException("Please fill all the fields");
						}
					} else {
						throw new HotelCustomException("Please fill all the fields");
					}
				} else {
					throw new HotelCustomException("Enter email id already exist , Please fill all the details");
				}

			} else {
				throw new HotelCustomException("Please fill all the fields");
			}
		} else {
			throw new HotelCustomException("Please fill all the fields");
		}
	}

	@Override
	public List<UserBean> viewCustomerDetails() {
		return dao.viewCustomerDetails();
	}

	@Override
	public List<BookingInfoBean> viewBillDetails() {
		return dao.viewBillDetails();
	}
}
