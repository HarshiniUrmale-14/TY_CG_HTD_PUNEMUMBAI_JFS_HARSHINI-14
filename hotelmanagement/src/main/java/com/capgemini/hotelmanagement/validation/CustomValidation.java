package com.capgemini.hotelmanagement.validation;

public interface CustomValidation {
	public boolean customEmailValidation(String email);
	public boolean customLocationValidation(String location);
	public boolean customRoomIdValidation(int roomId);
	public boolean customEmployeeEmailValidation(String email);
	public boolean customAdharValidation(String adharNo);
	public boolean customUserIdValidation(int userId);

}
