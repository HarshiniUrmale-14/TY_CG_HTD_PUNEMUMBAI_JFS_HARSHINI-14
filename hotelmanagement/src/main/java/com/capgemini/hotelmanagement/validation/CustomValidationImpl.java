package com.capgemini.hotelmanagement.validation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.hotelmanagement.beans.EmployeeInfoBean;
import com.capgemini.hotelmanagement.beans.HotelInfoBean;
import com.capgemini.hotelmanagement.beans.RoomInfoBean;
import com.capgemini.hotelmanagement.beans.UserBean;
import com.capgemini.hotelmanagement.exception.HotelCustomException;

@Repository
public class CustomValidationImpl implements CustomValidation {

@PersistenceUnit
private EntityManagerFactory entityManagerFactory;
EntityManager entityManager = null;
EntityTransaction transaction = null;

@Override
public boolean customEmailValidation(String email) {
	entityManager = entityManagerFactory.createEntityManager();
	transaction = entityManager.getTransaction();
	boolean isValid = false;

	String jpql = " from UserBean";
	transaction.begin();
	Query query = entityManager.createQuery(jpql);
	List<UserBean> list = null;
	try {
		list = query.getResultList();
		for (UserBean user : list) {
			if (email.equals(user.getEmail())) {
				isValid = true;
				return isValid;
			}
		}

	} catch (Exception e) {
		throw new HotelCustomException("Some thing went wrong ...Email id not found!!!");
	}

	return isValid;
}


@Override
public boolean customLocationValidation(String location) {
	entityManager = entityManagerFactory.createEntityManager();
	transaction = entityManager.getTransaction();
	boolean isValid = false;

	String jpql = " from HotelInfoBean";
	transaction.begin();
	Query query = entityManager.createQuery(jpql);
	List<HotelInfoBean> list = null;
	try {
		list = query.getResultList();
		for (HotelInfoBean hotelInfo : list) {
			if (location.equals(hotelInfo.getLocation())) {
				isValid = true;
				return isValid;
			}
		}
	} catch (Exception e) {
		throw new HotelCustomException("Some thing went wrong ...Location not found!!!");
	}
	return isValid;
}

@Override
public boolean customRoomIdValidation(int roomId) {
	entityManager = entityManagerFactory.createEntityManager();
	transaction = entityManager.getTransaction();
	boolean isValid = false;

	String jpql = " from RoomInfoBean";
	transaction.begin();
	Query query = entityManager.createQuery(jpql);
	List<RoomInfoBean> list = null;
	try {
		list = query.getResultList();
		for (RoomInfoBean roomInfoBean : list) {
			if (roomId == roomInfoBean.getRoomId()) {
				isValid = true;
				return isValid;
			}
		}
	} catch (Exception e) {
		throw new HotelCustomException("Some thing went wrong ...Room Id not found!!!");
	}
	return isValid;
}


@Override
public boolean customEmployeeEmailValidation(String email) {
	entityManager = entityManagerFactory.createEntityManager();
	transaction = entityManager.getTransaction();
	boolean isValid = false;

	String jpql = " from EmployeeInfoBean";
	transaction.begin();
	Query query = entityManager.createQuery(jpql);
	try {
		List<EmployeeInfoBean> list = null;
		list = query.getResultList();
		for (EmployeeInfoBean user : list) {
			if (email.equals(user.getEmail())) {
				isValid = true;
				return isValid;
			}
		}
	} catch (Exception e) {
		throw new HotelCustomException("Some thing went wrong ...Email id not found!!!");
	}
		
	return isValid;
}


@Override
public boolean customAdharValidation(String adharNo) {
	entityManager = entityManagerFactory.createEntityManager();
	transaction = entityManager.getTransaction();
	boolean isValid = false;

	String jpql = " from UserBean";
	transaction.begin();
	Query query = entityManager.createQuery(jpql);
	List<UserBean> list = null;
	try {
		list = query.getResultList();
		for (UserBean user : list) {
			if (adharNo.equals(user.getAdharNo())) {
				isValid = true;
				return isValid;
			}
		}

	} catch (Exception e) {
		throw new HotelCustomException("Some thing went wrong ...Email id not found!!!");
	}

	return isValid;
}




@Override
public boolean customUserIdValidation(int userId) {
	entityManager = entityManagerFactory.createEntityManager();
	transaction = entityManager.getTransaction();
	boolean isValid = false;

	String jpql = " from UserBean";
	transaction.begin();
	Query query = entityManager.createQuery(jpql);
	List<UserBean> list = null;
	try {
		list = query.getResultList();
		for (UserBean userBean : list) {
			if (userId == userBean.getUserId()) {
				isValid = true;
				return isValid;
			}
		}
	} catch (Exception e) {
		throw new HotelCustomException("Some thing went wrong ...Room Id not found!!!");
	}
	return isValid;
}
}
