package com.capgemini.hotelmanagement.dao;

import java.util.List;

import com.capgemini.hotelmanagement.beans.BookingInfoBean;
import com.capgemini.hotelmanagement.beans.RoomInfoBean;
import com.capgemini.hotelmanagement.beans.UserBean;

public interface ManagementDao {
	public UserBean addAdmin(UserBean bean);

	public List<UserBean> viewCustomerDetails();

	public List<BookingInfoBean> viewBillDetails();

}
