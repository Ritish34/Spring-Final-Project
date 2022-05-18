package com.inexture.util;

import org.mindrot.jbcrypt.BCrypt;

public class Encryption {
	
	public String encrypt(String pass) {
		String hash = BCrypt.hashpw(pass, BCrypt.gensalt());
		return hash;
	}
	public boolean decrypt(String pass,String hashedPassword) {
		boolean result = BCrypt.checkpw(pass, hashedPassword);
		return result;
	}
}
