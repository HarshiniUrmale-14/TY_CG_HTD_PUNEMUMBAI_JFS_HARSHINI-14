package com.capgemini.hotelmanagement.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Repository;

@Repository
public class RegexValidationImpl implements RegexValidation {
	Pattern pattern = null;
	Matcher matcher = null;

	@Override
	public boolean idValidation(String userid) {

		pattern = Pattern.compile("\\d{4}");
		matcher = pattern.matcher(userid);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean mobileValidation(String mobile) {

		pattern = Pattern.compile("\\d{10}");
		matcher = pattern.matcher(mobile);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean adharValidation(String adharNo) {

		pattern = Pattern.compile("\\d{12}");
		matcher = pattern.matcher(adharNo);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean nameValidation(String name) {

		pattern = Pattern.compile("\\D+");
		matcher = pattern.matcher(name);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean hotelNameValidation(String name) {

		pattern = Pattern.compile("\\w+");
		matcher = pattern.matcher(name);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean emailValidation(String email) {

		pattern = Pattern.compile("\\w+\\@\\w+\\.\\w+");
		matcher = pattern.matcher(email);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean passValidation(String password) {

		pattern = Pattern.compile("\\w+");
		matcher = pattern.matcher(password);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean roomIdValidation(String roomId) {

		pattern = Pattern.compile("\\d{4}");
		matcher = pattern.matcher(roomId);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	

}
