package com.inexture.util;

import java.security.SecureRandom;
import java.util.stream.Collectors;

public class GeneratePassword {
	private SecureRandom random;
	
	public GeneratePassword() {
		random = new SecureRandom();
	}
	
	// Method to generate a random alphanumeric password of a specific length
    public String generateRandomPassword(int len, int randNumOrigin, int randNumBound)
    {
        return random.ints(len, randNumOrigin, randNumBound + 1)
                    .mapToObj(i -> String.valueOf((char)i))
                    .collect(Collectors.joining());
    }
}
