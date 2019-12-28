package com.capgemini.hotelmanagement.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hotelmanagement.beans.BookingInfoBean;
import com.capgemini.hotelmanagement.beans.EmployeeInfoBean;
import com.capgemini.hotelmanagement.beans.HotelInfoBean;
import com.capgemini.hotelmanagement.beans.RoomInfoBean;
import com.capgemini.hotelmanagement.dao.AdminDao;
import com.capgemini.hotelmanagement.exception.HotelCustomException;
import com.capgemini.hotelmanagement.utility.PasswordEncryptor;
import com.capgemini.hotelmanagement.validation.RegexValidation;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao dao;

	@Autowired
	private RegexValidation validation;

	@Autowired
	private CustomValidationService customValidationService;

	@Override
	public boolean addHotel(HotelInfoBean hotelInfoBean) {
		String location = hotelInfoBean.getLocation();
		boolean isValid = customValidationService.customLocationValidation(location);
		if (!isValid) {
			return dao.addHotel(hotelInfoBean);
		} else {
			throw new HotelCustomException("Hotel location already exist");
		}

	}

	@Override
	public boolean updateHotelDetails(HotelInfoBean hotelInfoBaan) {
		return dao.updateHotelDetails(hotelInfoBaan);
	}

	@Override
	public boolean deleteHotel(int hotelId) {
		return dao.deleteHotel(hotelId);
	}

	@Override
	public List<HotelInfoBean> seeHotelDetails() {
		return dao.seeHotelDetails();
	}

	@Override
	public boolean addRoom(RoomInfoBean roomInfoBean) {
		return dao.addRoom(roomInfoBean);
	}

	@Override
	public boolean updateRoomDetails(RoomInfoBean roomInfoBean) {
		return dao.updateRoomDetails(roomInfoBean);
	}

	@Override
	public boolean deleteRoom(int roomId) {
		return dao.deleteRoom(roomId);
	}

	@Override
	public List<BookingInfoBean> bookingListOfSpecificHotel(int hotelId) {
		return dao.bookingListOfSpecificHotel(hotelId);
	}

	@Override
	public List<BookingInfoBean> guestListOfSpecificHotel(int hotelId) {
		return dao.guestListOfSpecificHotel(hotelId);
	}

	@Override
	public List<BookingInfoBean> bookingListOfSpecificDate(Date date) {
		return dao.bookingListOfSpecificDate(date);
	}

	@Override
	public List<RoomInfoBean> seeRoomDetails() {
		return dao.seeRoomDetails();
	}

	@Override
	public EmployeeInfoBean addEmployee(EmployeeInfoBean employeeBean) {
		String employeeName = employeeBean.getEmployeeName();
		String phoneNo = employeeBean.getPhoneNo();
		String email = employeeBean.getEmail();
		String hotelName = employeeBean.getHotelName();
		if (validation.nameValidation(employeeName)) {
			if (validation.emailValidation(email)) {
				boolean isValid = customValidationService.customEmployeeEmailValidation(email);
				if (!isValid) {
					if (validation.mobileValidation(phoneNo)) {
						if(validation.hotelNameValidation(hotelName)) {
							employeeBean.setPassword(PasswordEncryptor.encryptPassword(employeeBean.getPassword()));
							return dao.addEmployee(employeeBean);
						} else {
							throw new HotelCustomException("Please fill all the fields");
						}
						
					} else {
						throw new HotelCustomException("Please fill all the fields");
					}
				} else {
					throw new HotelCustomException("Entered email id already exist!!!");
				}
			} else {
				throw new HotelCustomException("Please fill all the fields");
			}
		} else {
			throw new HotelCustomException("Please fill all the fields");
		}
	}

}
