package com.capgemini.hotelmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.hotelmanagement.beans.BookingInfoBean;
import com.capgemini.hotelmanagement.beans.ResponseBean;
import com.capgemini.hotelmanagement.beans.UserBean;
import com.capgemini.hotelmanagement.exception.HotelCustomException;
import com.capgemini.hotelmanagement.service.CustomValidationService;
import com.capgemini.hotelmanagement.service.ManagementService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ManagementController {


	public static final String SUCCESS="Success";
	public static final String FAILURE="Failure";
	
	@Autowired(required = true)
	private ManagementService managementService;

	@Autowired
	private CustomValidationService customValidationService;

	@PostMapping("/addAdmin")
	public ResponseBean addadmin(@RequestBody UserBean userBean) {
		userBean.setUserType("admin");
		ResponseBean response = new ResponseBean();
		UserBean user = managementService.addAdmin(userBean);
		if (user != null) {
			response.setStatusCode(222);
			response.setMessage(SUCCESS);
			response.setDescription("Registered successfully...");
		} else {
			throw new HotelCustomException("Fail to register");
		} 
		return response;
	}

	@GetMapping("/getCustomerDetails")
	public ResponseBean getCustomerDetails() {
		ResponseBean response = new ResponseBean();
		List<UserBean> customerList = managementService.viewCustomerDetails();
		if (customerList != null) {
			response.setStatusCode(222);
			response.setMessage(SUCCESS);
			response.setDescription("Customer details found...");
			response.setUserList(customerList);
		} else {
			throw new HotelCustomException("Unable to found the details of customer!!!");
		}

		return response;
	}

	@GetMapping("/getBillDetails")
	public ResponseBean getBillDetails() {
		ResponseBean response = new ResponseBean();
		List<BookingInfoBean> billList = managementService.viewBillDetails();
		if (billList != null) {
			response.setStatusCode(222);
			response.setMessage(SUCCESS);
			response.setDescription("Bill details found...");
			response.setBookingList(billList);
		} else {
			throw new HotelCustomException("Unable to found the bill details!!!");
		}

		return response;
	}

}
