package com.capgemini.hotelmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.hotelmanagement.beans.BookingInfoBean;
import com.capgemini.hotelmanagement.beans.EmployeeInfoBean;
import com.capgemini.hotelmanagement.beans.ResponseBean;
import com.capgemini.hotelmanagement.beans.RoomInfoBean;
import com.capgemini.hotelmanagement.beans.UserBean;
import com.capgemini.hotelmanagement.exception.HotelCustomException;
import com.capgemini.hotelmanagement.service.CustomValidationService;
import com.capgemini.hotelmanagement.service.UserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

	int userId = 0;
	int employeeId=0;
	int hotelId = 0;
	public static final String SUCCESS = "Success";
	public static final String FAILURE = "Failure";

	@Autowired(required = true)
	private UserService userService;

	@Autowired
	private CustomValidationService customValidationService;

	@PostMapping("/registerAsUser")
	public ResponseBean register(@RequestBody UserBean userBean) {
		userBean.setUserType("user");
			ResponseBean response = new ResponseBean();
			UserBean user = userService.register(userBean);
			if (user != null) {
				response.setStatusCode(222);
				response.setMessage(SUCCESS);
				response.setDescription("Registered successfully...");
			} else {
				throw new HotelCustomException("Fail to register");
			} 
			return response;
	}

	@PostMapping("/login")
	public ResponseBean login(@RequestBody UserBean userBean) {
		String email = userBean.getEmail();
		String password = userBean.getPassword();
		ResponseBean response = new ResponseBean();

		boolean isValid = customValidationService.customEmailValidation(email);
		if (isValid) {
			UserBean user = userService.login(email, password);
			if (user != null) {
				String userType = user.getUserType();
				userId = user.getUserId();
				response.setStatusCode(222);
				response.setMessage(SUCCESS);
				response.setDescription("Login successfully...");
				response.setUserType(userType);
			} else {
				throw new HotelCustomException("Entered password is wrong");
			}
			return response;
		} else if (customValidationService.customEmployeeEmailValidation(email)) {
			EmployeeInfoBean employeeInfoBean = userService.loginAsEmployee(email, password);
			if (employeeInfoBean != null) {
				String employeeType = employeeInfoBean.getEmployeeType();
				employeeId = employeeInfoBean.getEmployeeId();
				hotelId = employeeInfoBean.getHotelId();
				response.setStatusCode(222);
				response.setMessage(SUCCESS);
				response.setDescription("Login successfully...");
				response.setEmployeeType(employeeType);
			} else {
				throw new HotelCustomException("Entered password is wrong");
			}
			return response;
		} else {
			throw new HotelCustomException("Enter email id does not exist, Please register first");
		}
	}

	@PostMapping("/booking")
	public ResponseBean booking(@RequestBody BookingInfoBean bookingInfoBean) {
		ResponseBean response = new ResponseBean();
		boolean isBooked = userService.bookingRoom(bookingInfoBean, userId);
		if (isBooked) {
			response.setStatusCode(222);
			response.setMessage(SUCCESS);
			response.setDescription("Room booked successfully...");
		} else {
			throw new HotelCustomException("Unable to book room...");
		}
		return response;
	}

	@GetMapping("/getRoomDetails/{hotelId}")
	public ResponseBean getRoomDetails(@PathVariable int hotelId) {
		ResponseBean response = new ResponseBean();
		List<RoomInfoBean> roomList = userService.seeRoomDetails(hotelId);
		if (roomList != null) {
			response.setStatusCode(222);
			response.setMessage(SUCCESS);
			response.setDescription("Room details found successfully...");
			response.setRoomList(roomList);
		} else {
			throw new HotelCustomException("Unable to found the details of room !!!");
		}
		return response;
	}

	@GetMapping("/getUserProfile")
	public ResponseBean getUserProfile() {

		UserBean userBean = userService.getUserProfile(userId);
		ResponseBean response = new ResponseBean();

		if (userBean != null) {
			response.setStatusCode(222);
			response.setMessage(SUCCESS);
			response.setDescription("USER FOUND");
			response.setUserBean(userBean);

		} else {
			throw new HotelCustomException("Unable to fetch data !!!");
		}
		return response;
	}

	@PutMapping("/updateProfile")
	public ResponseBean updateRoomlDetails(@RequestBody UserBean userBean) {
		ResponseBean response = new ResponseBean();
		boolean isUpdated = userService.updateProfile(userId, userBean);
		if (isUpdated) {
			response.setStatusCode(222);
			response.setMessage(SUCCESS);
			response.setDescription("user details updated successfully...");
		} else {
			throw new HotelCustomException("Unable to update room details!!!");
		}
		return response;
	}

	@GetMapping("/getBill")
	public ResponseBean getBill() {

		double bill = userService.getBill(userId);
		ResponseBean response = new ResponseBean();

		if (bill >0) {
			response.setStatusCode(222);
			response.setMessage(SUCCESS);
			response.setDescription("Bill is successfully found....");
			response.setBill(bill);

		} else {
			throw new HotelCustomException("Unable to fetch the bill");
		}
		return response;
	}

	@GetMapping("/getRoomDetailsForEmployee")
	public ResponseBean getRoomDetailsForEmployee() {
		ResponseBean response = new ResponseBean();
		List<RoomInfoBean> roomList = userService.seeRoomDetailsForEmployee(hotelId);
		if (roomList != null) {
			response.setStatusCode(222);
			response.setMessage(SUCCESS);
			response.setDescription("Room details found...");
			response.setRoomList(roomList);
		} else {
			throw new HotelCustomException("Unable to found the details of room!!!");
		}

		return response;
	}

	@PostMapping("/bookingByEmployee")
	public ResponseBean bookingByEmployee(@RequestBody BookingInfoBean bookingInfoBean) {
		ResponseBean response = new ResponseBean();
		int id = bookingInfoBean.getUserId();
		if(!customValidationService.customUserIdValidation(id)) {
			boolean isBooked = userService.bookingRoomByEmployee(bookingInfoBean);
			userId = bookingInfoBean.getUserId();
			if (isBooked) {
				response.setStatusCode(222);
				response.setMessage(SUCCESS);
				response.setDescription("Room booked successfully...");
			} else {
				throw new HotelCustomException("Unable to book the room!!!");
			}
		} else {
			throw new HotelCustomException("Entered userId is already exist!!!");
		}
		return response;
	}

	@PutMapping("/updateBookingStatus")
	public ResponseBean updateBookingStatus(@RequestBody BookingInfoBean bookingInfoBean) {
		ResponseBean response = new ResponseBean();
		boolean isUpdated = userService.updateBookingInfoBean(bookingInfoBean, userId);
		if (isUpdated) {
			response.setStatusCode(222);
			response.setMessage(SUCCESS);
			response.setDescription("payment done successfully...");
		} else {
			throw new HotelCustomException("Unable to generate the bill details!!!");
		}

		return response;
	}

	@GetMapping("/getUserBookingList")
	public ResponseBean getUserBookingList() {
		ResponseBean response = new ResponseBean();
		List<BookingInfoBean> bookingList = userService.userBookingList(userId);
		if (bookingList != null) {
			response.setStatusCode(222);
			response.setMessage(SUCCESS);
			response.setDescription("Room details found...");
			response.setBookingList(bookingList);
		} else {
			throw new HotelCustomException("Unable to found the details of room!!!");
		}

		return response;
	}

}
