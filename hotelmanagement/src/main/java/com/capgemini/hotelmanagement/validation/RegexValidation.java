package com.capgemini.hotelmanagement.validation;

public interface RegexValidation {

	public boolean idValidation(String userId);

	public boolean roomIdValidation(String roomId);

	public boolean nameValidation(String name);

	public boolean emailValidation(String email);

	public boolean passValidation(String password);

	public boolean mobileValidation(String mobile);

	public boolean adharValidation(String adharNo);
	
	public boolean hotelNameValidation(String name);

}
