package com.capgemini.hotelmanagement.utility;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class PasswordEncryptor {

	private PasswordEncryptor() {

	}

	public static String encryptPassword(String plainTextPassword) {
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}

	public static boolean checkPassword(String plainTextPassword, String encryptedPassword) {
		if (BCrypt.checkpw(plainTextPassword, encryptedPassword)) {
			return true;
		} else {
			return false;
		}
	}

}
