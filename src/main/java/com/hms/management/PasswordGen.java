package com.hms.management;

import java.security.SecureRandom;

public class PasswordGen{
	 private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
     private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
     private static SecureRandom random = new SecureRandom();
     
     public static String generateRandomPassword(int length) {
         if (length < 1) throw new IllegalArgumentException();

         StringBuilder sb = new StringBuilder(length);
         for (int i = 0; i < length; i++) {
            int rndCharAt = random.nextInt(CHAR_LOWER.length());
             char rndChar = CHAR_UPPER.charAt(rndCharAt);
             sb.append(rndChar);
             }
        return sb.toString();
     }
}