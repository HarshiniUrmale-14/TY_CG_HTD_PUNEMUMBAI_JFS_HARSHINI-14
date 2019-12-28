package com.capgemini.hotelmanagement.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ResponseBean {

	private int statusCode;
	private String message;
	private String description;
	private HotelInfoBean hotelInfoBean;
	private List<HotelInfoBean> hotelList;
	private BookingInfoBean bookingInfoBean;
	private List<BookingInfoBean> bookingList;
	private UserBean userBean;
	private List<UserBean> userList;
	private RoomInfoBean roomInfoBean;
	private List<RoomInfoBean> roomList;
	private double bill;
	private int hotelId;
	private String employeeType;
	private EmployeeInfoBean employeeInfoBean;
	private List<EmployeeInfoBean> employeeList;

	public double getBill() {
		return bill;
	}

	public void setBill(double bill) {
		this.bill = bill;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public List<UserBean> getUserList() {
		return userList;
	}

	public void setUserList(List<UserBean> userList) {
		this.userList = userList;
	}

	public void setBookingList(List<BookingInfoBean> bookingList) {
		this.bookingList = bookingList;
	}

	private String userType;

	// Getters and Setters
	public int getStatusCode() {
		return statusCode;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public HotelInfoBean getHotelInfoBean() {
		return hotelInfoBean;
	}

	public void setHotelInfoBean(HotelInfoBean hotelInfoBean) {
		this.hotelInfoBean = hotelInfoBean;
	}

	public List<HotelInfoBean> getHotelList() {
		return hotelList;
	}

	public void setHotelList(List<HotelInfoBean> hotelList) {
		this.hotelList = hotelList;
	}

	public BookingInfoBean getBookingInfoBean() {
		return bookingInfoBean;
	}

	public void setBookingInfoBean(BookingInfoBean bookingInfoBean) {
		this.bookingInfoBean = bookingInfoBean;
	}

	public List<BookingInfoBean> getBookingList() {
		return bookingList;
	}

	public void setBoookingList(List<BookingInfoBean> bookingList) {
		this.bookingList = bookingList;
	}

	public RoomInfoBean getRoomInfoBean() {
		return roomInfoBean;
	}

	public void setRoomInfoBean(RoomInfoBean roomInfoBean) {
		this.roomInfoBean = roomInfoBean;
	}

	public List<RoomInfoBean> getRoomList() {
		return roomList;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	public EmployeeInfoBean getEmployeeInfoBean() {
		return employeeInfoBean;
	}

	public void setEmployeeInfoBean(EmployeeInfoBean employeeInfoBean) {
		this.employeeInfoBean = employeeInfoBean;
	}

	public List<EmployeeInfoBean> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<EmployeeInfoBean> employeeList) {
		this.employeeList = employeeList;
	}

	public void setRoomList(List<RoomInfoBean> roomList) {
		this.roomList = roomList;
	}

}
