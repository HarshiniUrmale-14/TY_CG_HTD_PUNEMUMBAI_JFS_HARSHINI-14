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
import com.capgemini.hotelmanagement.beans.RoomInfoBean;
import com.capgemini.hotelmanagement.beans.UserBean;
import com.capgemini.hotelmanagement.exception.HotelCustomException;
import com.capgemini.hotelmanagement.utility.PasswordEncryptor;

@Repository
public class UserDaoImpl implements UserDao {
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	EntityManager entityManager = null;
	EntityTransaction transaction = null;

	@Override
	public UserBean register(UserBean userBean) {
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		UserBean user = new UserBean();
		try {
			transaction.begin();
			entityManager.persist(userBean);
			transaction.commit();
			entityManager.close();
			return user;
		} catch (Exception e) {
			throw new HotelCustomException("Some thing went wrong ...user connot be register!!!");
		}
	}

	@Override
	public UserBean login(String email, String password) {
		entityManager = entityManagerFactory.createEntityManager();
		UserBean user = null;
		UserBean user1 = null;

		String jpql = "from UserBean where email=:email";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("email", email);
		user1 = (UserBean) query.getSingleResult();
		String encryptedPassword = user1.getPassword();
		if (PasswordEncryptor.checkPassword(password, encryptedPassword)) {
			try {
				user = (UserBean) query.getSingleResult();
			} catch (Exception e) {
				throw new HotelCustomException("Something went wrong ...user cannot be login!!!");
			}
		}
		entityManager.close();
		return user;
	}

	@Override
	public EmployeeInfoBean loginAsEmployee(String email, String password) {
		entityManager = entityManagerFactory.createEntityManager();
		EmployeeInfoBean employee = null;
		EmployeeInfoBean employee1 = null;

		String jpql = "from EmployeeInfoBean where email=:email";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("email", email);
		employee1 = (EmployeeInfoBean) query.getSingleResult();
		String encryptedPassword = employee1.getPassword();
		if (PasswordEncryptor.checkPassword(password, encryptedPassword)) {
			try {
				employee = (EmployeeInfoBean) query.getSingleResult();
			} catch (Exception e) {
				throw new HotelCustomException("Something went wrong ...user cannot be login!!!");
			}
		}
		entityManager.close();
		return employee;
	}

	@Override
	public boolean bookingRoom(BookingInfoBean bookingInfoBean, int userId) {

		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		boolean isBooked = false;
		String jpql = "from UserBean where userId=:userId";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("userId", userId);
		try {
			UserBean userBean = (UserBean) query.getSingleResult();
			String userName = userBean.getUserName();
			BookingInfoBean bookingInfoBean1 = new BookingInfoBean();
			bookingInfoBean1.setUserId(userId);
			bookingInfoBean1.setUserName(userName);
			bookingInfoBean1.setHotelName(bookingInfoBean.getHotelName());
			bookingInfoBean1.setHotelId(bookingInfoBean.getHotelId());
			int roomId = bookingInfoBean.getRoomId();
			bookingInfoBean1.setRoomId(roomId);

			String jpqlNew = "from RoomInfoBean where roomId=:roomId";
			Query queryNew = entityManager.createQuery(jpqlNew);
			queryNew.setParameter("roomId", roomId);
			RoomInfoBean roomInfoBean = (RoomInfoBean) queryNew.getSingleResult();
			double roomRent = roomInfoBean.getRoomRent();
			bookingInfoBean1.setAmount(bookingInfoBean.getAmount());
			bookingInfoBean1.setModeOfPayment("NONE");
			bookingInfoBean1.setPaymentStatus("NOT PAID");
			Date startDate = bookingInfoBean.getCheckinDate();
			Date endDate = bookingInfoBean.getCheckoutDate();
			long calculatedDays = getdays(startDate, endDate);
			bookingInfoBean1.setCheckinDate(startDate);
			bookingInfoBean1.setCheckoutDate(endDate);
			bookingInfoBean1.setDays(calculatedDays);
			double amount = roomRent * calculatedDays;
			bookingInfoBean1.setAmount(amount);

			transaction.begin();
			entityManager.persist(bookingInfoBean1);
			transaction.commit();
			isBooked = true;
		} catch (Exception e) {
			throw new HotelCustomException("Some thing went wrong ...Room cannot be book!!!");
		}

		entityManager.close();
		return isBooked;
	}

	@Override
	public List<RoomInfoBean> seeRoomDetails(int hotelId) {
		entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from RoomInfoBean where hotelId=:hotelId";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("hotelId", hotelId);
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
	public UserBean getUserProfile(int userId) {
		entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from UserBean where userId=:userId";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("userId", userId);
		UserBean userBean = (UserBean) query.getSingleResult();
		return userBean;
	}

	@Override
	public boolean updateProfile(int userId, UserBean userBean) {
		boolean isUpdated = false;
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		if (userBean != null) {
			UserBean userBean1 = entityManager.find(UserBean.class, userId);
			if (userBean1 != null) {
				if (userBean.getUserName() != null) {
					userBean1.setUserName(userBean.getUserName());
				}
				if (userBean.getEmail() != null) {
					userBean1.setEmail(userBean.getEmail());
				}
				if (userBean.getPassword() != null) {
					userBean1.setPassword(PasswordEncryptor.encryptPassword(userBean.getPassword()));
				}
				if (userBean.getUserType() != null) {
					userBean1.setUserType(userBean.getUserType());
				}
				if (userBean.getNationality() != null) {
					userBean1.setNationality(userBean.getNationality());
				}
				if (userBean.getAdharNo() != null) {
					userBean1.setAdharNo(userBean.getAdharNo());
				}
				if (userBean.getPhoneNo() != null) {
					userBean1.setPhoneNo(userBean.getPhoneNo());
				}

			}
			try {
				transaction.begin();
				entityManager.persist(userBean1);
				transaction.commit();
				isUpdated = true;

			} catch (Exception e) {
				throw new HotelCustomException("Some thing went wrong ...User Profile cannot be update!!!");
			}
		}

		entityManager.close();
		return isUpdated;
	}

	@Override
	public long getdays(Date startDate, Date endDate) {
		long calculatedDays = 0;
		try {
			long difference = endDate.getTime() - startDate.getTime();
			calculatedDays = difference / (24 * 60 * 60 * 1000);
		} catch (Exception e) {
			throw new HotelCustomException("Some thing went wrong!!!");
		}
		if (calculatedDays == 0) {
			return 1;
		} else {
			return calculatedDays;
		}
	}

	@Override
	public double getBill(int userId) {
		double bill = 0;
		entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from BookingInfoBean where userId=:userId";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("userId", userId);
		try {
			List<BookingInfoBean> list = query.getResultList();
			for (BookingInfoBean bean : list) {
				bill = bean.getAmount();
			}
		} catch (Exception e) {
			throw new HotelCustomException("Some thing went wrong ...Room Details cannot be found!!!");
		}
		entityManager.close();
		return bill;
	}

	@Override
	public List<RoomInfoBean> seeRoomDetailsForEmployee(int hotelId) {
		entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from RoomInfoBean where hotelId=:hotelId";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("hotelId", hotelId);
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
	public boolean bookingRoomByEmployee(BookingInfoBean bookingInfoBean) {
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		boolean isBooked = false;
		BookingInfoBean newBookingInfoBean = new BookingInfoBean();
		try {
			newBookingInfoBean.setUserId(bookingInfoBean.getUserId());
			newBookingInfoBean.setUserName(bookingInfoBean.getUserName());
			newBookingInfoBean.setHotelName(bookingInfoBean.getHotelName());
			newBookingInfoBean.setHotelId(bookingInfoBean.getHotelId());
			int roomId = bookingInfoBean.getRoomId();
			newBookingInfoBean.setRoomId(roomId);
			newBookingInfoBean.setModeOfPayment("NONE");
			newBookingInfoBean.setPaymentStatus("NOT PAID");
			String jpqlNew = "from RoomInfoBean where roomId=:roomId";
			Query queryNew = entityManager.createQuery(jpqlNew);
			queryNew.setParameter("roomId", roomId);
			RoomInfoBean roomInfoBean = (RoomInfoBean) queryNew.getSingleResult();
			double roomRent = roomInfoBean.getRoomRent();
			newBookingInfoBean.setAmount(bookingInfoBean.getAmount());

			Date startDate = bookingInfoBean.getCheckinDate();
			Date endDate = bookingInfoBean.getCheckoutDate();
			long calculatedDays = getdays(startDate, endDate);
			newBookingInfoBean.setCheckinDate(startDate);
			newBookingInfoBean.setCheckoutDate(endDate);
			newBookingInfoBean.setDays(calculatedDays);
			double amount = roomRent * calculatedDays;
			newBookingInfoBean.setAmount(amount);
			transaction.begin();
			entityManager.persist(newBookingInfoBean);
			transaction.commit();
			isBooked = true;
		} catch (Exception e) {
			throw new HotelCustomException("Some thing went wrong ...room cannot be book!!!");
		}
		entityManager.close();
		return isBooked;
	}

	@Override
	public boolean updateBookingInfoBean(BookingInfoBean bookingInfoBean, int userId) {
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		boolean isUpdated = false;

		String modeOfPayment = bookingInfoBean.getModeOfPayment();
		try {
			String jpql = "from BookingInfoBean where userId=:userId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("userId", userId);
			BookingInfoBean newBookingInfoBean = (BookingInfoBean) query.getSingleResult();
			newBookingInfoBean.setModeOfPayment(modeOfPayment);
			newBookingInfoBean.setPaymentStatus("PAID");
			transaction.begin();
			entityManager.persist(newBookingInfoBean);
			transaction.commit();
			isUpdated = true;
		} catch (Exception e) {
			throw new HotelCustomException("Something went wrong...booking info cannot found!!!");
		}

		return isUpdated;
	}

	@Override
	public List<BookingInfoBean> userBookingList(int userId) {
		entityManager = entityManagerFactory.createEntityManager();
		List<BookingInfoBean> bookingList = null;
		String jpql = "from BookingInfoBean where userId=:userId";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("userId", userId);
		try {
			bookingList = query.getResultList();
		} catch (Exception e) {
			throw new HotelCustomException(
					"Some thing went wrong ...Booking list of specific hotel cannot be found!!!");
		}
		entityManager.close();
		return bookingList;
	}

}
