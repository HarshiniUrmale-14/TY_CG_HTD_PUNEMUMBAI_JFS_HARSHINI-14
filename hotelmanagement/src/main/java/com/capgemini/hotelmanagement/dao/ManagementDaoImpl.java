package com.capgemini.hotelmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.hotelmanagement.beans.BookingInfoBean;
import com.capgemini.hotelmanagement.beans.UserBean;
import com.capgemini.hotelmanagement.exception.HotelCustomException;
import com.capgemini.hotelmanagement.utility.PasswordEncryptor;

@Repository
public class ManagementDaoImpl implements ManagementDao {
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	EntityManager entityManager = null;
	EntityTransaction transaction = null;

	@Override
	public UserBean addAdmin(UserBean userBean) {

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
	public List<UserBean> viewCustomerDetails() {

		entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from UserBean where userType=:type";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("type", "user");
		List<UserBean> userDetails = null;
		try {
			userDetails = query.getResultList();
		} catch (Exception e) {
			throw new HotelCustomException("Some thing went wrong ...Customer details cannot be found!!!");
		}

		entityManager.close();
		return userDetails;
	}

	@Override
	public List<BookingInfoBean> viewBillDetails() {

		entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from BookingInfoBean";
		Query query = entityManager.createQuery(jpql);
		List<BookingInfoBean> billDetails = null;
		billDetails = query.getResultList();
		entityManager.close();
		return billDetails;
	}
}
