package com.capgemini.hotelmanagement.service;

import java.util.Date;
import java.util.List;

import com.capgemini.hotelmanagement.beans.BookingInfoBean;
import com.capgemini.hotelmanagement.beans.EmployeeInfoBean;
import com.capgemini.hotelmanagement.beans.HotelInfoBean;
import com.capgemini.hotelmanagement.beans.RoomInfoBean;
import com.capgemini.hotelmanagement.beans.UserBean;


public interface AdminService {
	public boolean addHotel(HotelInfoBean hotelInfoBean);
	public boolean updateHotelDetails(HotelInfoBean hotelInfoBaan);
	public boolean deleteHotel(int hotelId);
	public List<HotelInfoBean> seeHotelDetails();
	public boolean addRoom(RoomInfoBean roomInfoBean);
	public boolean updateRoomDetails(RoomInfoBean roomInfoBean);
	public boolean deleteRoom(int roomId);
	public List<BookingInfoBean> bookingListOfSpecificHotel(int hotelId);
	public List<BookingInfoBean> guestListOfSpecificHotel(int hotelId);
	public List<BookingInfoBean> bookingListOfSpecificDate(Date date);
	public List<RoomInfoBean> seeRoomDetails();
	public EmployeeInfoBean addEmployee(EmployeeInfoBean employeeBean);

}
