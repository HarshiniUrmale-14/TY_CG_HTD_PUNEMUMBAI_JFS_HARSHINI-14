package com.capgemini.hotelmanagement.service;

import java.util.List;

import com.capgemini.hotelmanagement.beans.BookingInfoBean;
import com.capgemini.hotelmanagement.beans.RoomInfoBean;
import com.capgemini.hotelmanagement.beans.UserBean;

public interface ManagementService {
	public UserBean addAdmin(UserBean bean);

	public List<UserBean> viewCustomerDetails();

	public List<BookingInfoBean> viewBillDetails();
}
