package com.capgemini.hotelmanagement.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.hotelmanagement.beans.BookingInfoBean;
import com.capgemini.hotelmanagement.beans.EmployeeInfoBean;
import com.capgemini.hotelmanagement.beans.HotelInfoBean;
import com.capgemini.hotelmanagement.beans.RoomInfoBean;
import com.capgemini.hotelmanagement.beans.UserBean;
import com.capgemini.hotelmanagement.exception.HotelCustomException;

@Repository
public class AdminDaoImpl implements AdminDao {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	EntityManager entityManager = null;
	EntityTransaction transaction = null;

	@Override
	public boolean addHotel(HotelInfoBean hotelInfoBean) {
		boolean isAdded = false;
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			entityManager.persist(hotelInfoBean);
			transaction.commit();
			isAdded = true;
		} catch (Exception e) {
			throw new HotelCustomException("Some thing went wrong ...Hotel cannot be add!!!");
		}

		entityManager.close();
		return isAdded;
	}

	@Override
	public boolean updateHotelDetails(HotelInfoBean hotelInfoBean) {
		boolean isUpdated = false;
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();

		if (hotelInfoBean != null) {

			HotelInfoBean hotelInfoBeanNew = entityManager.find(HotelInfoBean.class, hotelInfoBean.getHotelId());
			if (hotelInfoBeanNew != null) {
				if (hotelInfoBean.getHotelName() != null) {
					hotelInfoBeanNew.setHotelName(hotelInfoBean.getHotelName());
				}
				if (hotelInfoBean.getLocation() != null) {
					hotelInfoBeanNew.setLocation(hotelInfoBean.getLocation());
				}
			}
			try {
				transaction.begin();
				entityManager.persist(hotelInfoBeanNew);
				isUpdated = true;
				transaction.commit();

			} catch (Exception e) {
				throw new HotelCustomException("Some thing went wrong ...Hotel cannot be update!!!");
			}
		}

		entityManager.close();
		return isUpdated;
	}

	@Override
	public boolean deleteHotel(int hotelId) {
		boolean isDeleted = false;
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();

		try {
			HotelInfoBean hotelInfoBean = entityManager.find(HotelInfoBean.class, hotelId);
			transaction.begin();
			entityManager.remove(hotelInfoBean);
			transaction.commit();
			isDeleted = true;
		} catch (Exception e) {
			throw new HotelCustomException("Some thing went wrong ...Hotel cannot be delete!!!");
		}

		entityManager.close();
		return isDeleted;
	}

	@Override
	public List<HotelInfoBean> seeHotelDetails() {
		entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from HotelInfoBean";
		Query query = entityManager.createQuery(jpql);
		List<HotelInfoBean> hotelList = null;
		try {
			hotelList = query.getResultList();
		} catch (Exception e) {
			throw new HotelCustomException("Some thing went wrong ...Hotel Details cannot be found!!!");
		}

		entityManager.close();
		return hotelList;
	}

	@Override
	public boolean addRoom(RoomInfoBean roomInfoBean) {
		boolean isAdded = false;
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			entityManager.persist(roomInfoBean);
			transaction.commit();
			isAdded = true;
		} catch (Exception e) {
			throw new HotelCustomException("Some thing went wrong ...Room  cannot be add!!!");
		}

		entityManager.close();
		return isAdded;
	}

	@Override
	public boolean updateRoomDetails(RoomInfoBean roomInfoBean) {
		boolean isUpdated = false;
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		if (roomInfoBean != null) {
			RoomInfoBean roomInfoBeanNew = entityManager.find(RoomInfoBean.class, roomInfoBean.getRoomId());
			if (roomInfoBeanNew != null) {
				if (roomInfoBean.getHotelId() != 0) {
					roomInfoBeanNew.setHotelId(roomInfoBean.getHotelId());
				}
				if (roomInfoBean.getRoomType() != null) {
					roomInfoBeanNew.setRoomType(roomInfoBean.getRoomType());
				}
				if (roomInfoBean.getRoomCapacity() != 0) {
					roomInfoBeanNew.setRoomCapacity(roomInfoBean.getRoomCapacity());
				}
				if (roomInfoBean.getRoomRent() != 0) {
					roomInfoBeanNew.setRoomRent(roomInfoBean.getRoomRent());
				}
				if (roomInfoBean.getRoomStatus() != null) {
					roomInfoBeanNew.setRoomStatus(roomInfoBean.getRoomStatus());
				}
				if (roomInfoBean.getHotelName() != null) {
					roomInfoBeanNew.setHotelName(roomInfoBean.getHotelName());
				}
				if (roomInfoBean.getImageUrl() != null) {
					roomInfoBeanNew.setImageUrl(roomInfoBean.getImageUrl());
				}
			}
			try {
				transaction.begin();
				entityManager.persist(roomInfoBeanNew);
				transaction.commit();
				isUpdated = true;

			} catch (Exception e) {
				throw new HotelCustomException("Some thing went wrong ...Room Details cannot be update!!!");
			}
		}
		entityManager.close();
		return isUpdated;
	}

	@Override
	public boolean deleteRoom(int roomId) {
		boolean isDeleted = false;
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();

		try {
			RoomInfoBean roomInfoBean = entityManager.find(RoomInfoBean.class, roomId);
			transaction.begin();
			entityManager.remove(roomInfoBean);
			transaction.commit();
			isDeleted = true;
		} catch (Exception e) {
			throw new HotelCustomException("Some thing went wrong ...Room  cannot be delete!!!");
		}

		entityManager.close();
		return isDeleted;
	}

	@Override
	public List<RoomInfoBean> seeRoomDetails() {
		entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from RoomInfoBean";
		Query query = entityManager.createQuery(jpql);
		List<RoomInfoBean> roomList = null;
		try {
			roomList = query.getResultList();
		} catch (Exception e) {
			throw new HotelCustomException("Some thing went wrong ...Room Details cannot be found!!!");
		}

		entityManager.close();
		return roomList;
	}

	@Override
	public List<BookingInfoBean> bookingListOfSpecificHotel(int hotelId) {
		entityManager = entityManagerFactory.createEntityManager();
		List<BookingInfoBean> bookingList = null;
		String jpql = "from BookingInfoBean where hotelId=:hotelId";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("hotelId", hotelId);
		try {
			bookingList = query.getResultList();
		} catch (Exception e) {
			throw new HotelCustomException(
					"Some thing went wrong ...Booking List of specific hotel  cannot be found!!!");
		}

		entityManager.close();
		return bookingList;
	}

	@Override
	public List<BookingInfoBean> guestListOfSpecificHotel(int hotelId) {
		entityManager = entityManagerFactory.createEntityManager();
		List<BookingInfoBean> guestList = null;
		String jpql = "from BookingInfoBean where hotelId=:hotelId";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("hotelId", hotelId);
		try {
			guestList = query.getResultList();
		} catch (Exception e) {
			throw new HotelCustomException("Some thing went wrong ...Guest List of specific hotel  cannot be found!!!");
		}

		entityManager.close();
		return guestList;
	}

	@Override
	public List<BookingInfoBean> bookingListOfSpecificDate(Date date) {
		entityManager = entityManagerFactory.createEntityManager();
		List<BookingInfoBean> bookingList = null;
		String jpql = "from BookingInfoBean where checkinDate=:date";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("date", date);
		try {
			bookingList = query.getResultList();
		} catch (Exception e) {
			throw new HotelCustomException(
					"Some thing went wrong ...Booking List of specific date  cannot be found!!!");
		}

		entityManager.close();
		return bookingList;
	}

	@Override
	public EmployeeInfoBean addEmployee(EmployeeInfoBean employeeBean) {
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		EmployeeInfoBean employee = new EmployeeInfoBean();
		try {
			transaction.begin();
			entityManager.persist(employeeBean);
			transaction.commit();
			entityManager.close();
			return employee;
		} catch (Exception e) {
			throw new HotelCustomException("Some thing went wrong ...user connot be register!!!");
		}
	}
}
