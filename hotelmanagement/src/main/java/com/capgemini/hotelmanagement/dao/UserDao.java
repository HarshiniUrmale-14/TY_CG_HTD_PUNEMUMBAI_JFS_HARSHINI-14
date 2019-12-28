package com.capgemini.hotelmanagement.dao;

import java.util.Date;
import java.util.List;

import com.capgemini.hotelmanagement.beans.BookingInfoBean;
import com.capgemini.hotelmanagement.beans.EmployeeInfoBean;
import com.capgemini.hotelmanagement.beans.RoomInfoBean;
import com.capgemini.hotelmanagement.beans.UserBean;

public interface UserDao {
	public UserBean register(UserBean userBean);

	public UserBean login(String email, String password);

	public boolean bookingRoom(BookingInfoBean bookingInfoBean, int userId);

	public List<RoomInfoBean> seeRoomDetails(int hotelId);

	public boolean updateProfile(int userId, UserBean userBean);

	public UserBean getUserProfile(int userId);

	public long getdays(Date startDate, Date endDate);

	public double getBill(int userId);

	public EmployeeInfoBean loginAsEmployee(String email, String password);

	public List<RoomInfoBean> seeRoomDetailsForEmployee(int hotelId);

	public boolean bookingRoomByEmployee(BookingInfoBean bookingInfoBean);

	public boolean updateBookingInfoBean(BookingInfoBean bookingInfoBean, int userId);

	public List<BookingInfoBean> userBookingList(int userId);

}
