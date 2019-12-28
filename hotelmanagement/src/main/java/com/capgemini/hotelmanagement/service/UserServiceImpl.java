package com.capgemini.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hotelmanagement.beans.BookingInfoBean;
import com.capgemini.hotelmanagement.beans.EmployeeInfoBean;
import com.capgemini.hotelmanagement.beans.RoomInfoBean;
import com.capgemini.hotelmanagement.beans.UserBean;
import com.capgemini.hotelmanagement.dao.UserDao;
import com.capgemini.hotelmanagement.exception.HotelCustomException;
import com.capgemini.hotelmanagement.utility.PasswordEncryptor;
import com.capgemini.hotelmanagement.validation.RegexValidation;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao dao;

	@Autowired
	private RegexValidation validation;

	@Autowired
	private CustomValidationService customValidationService;

	@Override
	public UserBean register(UserBean userBean) {
		String userName = userBean.getUserName();
		String email = userBean.getEmail();
		String phoneNo = userBean.getPhoneNo();
		String adharNo = userBean.getAdharNo();
		if (validation.nameValidation(userName)) {
			if (validation.emailValidation(email)) {
				if (!customValidationService.customEmailValidation(email)) {
					if (validation.mobileValidation(phoneNo)) {
						if (validation.adharValidation(adharNo)) {
							if(!customValidationService.customAdharValidation(adharNo)) {
								userBean.setPassword(PasswordEncryptor.encryptPassword(userBean.getPassword()));
								return dao.register(userBean);
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
	public UserBean login(String email, String password) {
		if (validation.emailValidation(email)) {
			return dao.login(email, password);
		} else {
			throw new HotelCustomException("Please Fill all the fields");
		}
	}

	@Override
	public boolean bookingRoom(BookingInfoBean bookingInfoBean, int userId) {
		return dao.bookingRoom(bookingInfoBean, userId);
	}

	@Override
	public List<RoomInfoBean> seeRoomDetails(int hotelId) {
		return dao.seeRoomDetails(hotelId);
	}

	@Override
	public boolean updateProfile(int userId, UserBean userBean) {
		return dao.updateProfile(userId, userBean);
	}

	@Override
	public UserBean getUserProfile(int userId) {
		return dao.getUserProfile(userId);
	}

	@Override
	public double getBill(int userId) {
		return dao.getBill(userId);
	}

	@Override
	public EmployeeInfoBean loginAsEmployee(String email, String password) {
		if (validation.emailValidation(email)) {
			if (validation.passValidation(password)) {
				return dao.loginAsEmployee(email, password);
			} else {
				throw new HotelCustomException("Please enter atleast one Capital letter and one digit");
			}
		} else {
			throw new HotelCustomException("Enter valid email id as abcd@gmail.com");
		}
	}

	@Override
	public List<RoomInfoBean> seeRoomDetailsForEmployee(int hotelId) {
		return dao.seeRoomDetails(hotelId);
	}

	@Override
	public boolean bookingRoomByEmployee(BookingInfoBean bookingInfoBean) {
		return dao.bookingRoomByEmployee(bookingInfoBean);
	}

	@Override
	public boolean updateBookingInfoBean(BookingInfoBean bookingInfoBean, int userId) {
		return dao.updateBookingInfoBean(bookingInfoBean, userId);
	}

	@Override
	public List<BookingInfoBean> userBookingList(int userId) {
		return dao.userBookingList(userId);
	}

}
