package com.fapethedev.ogine.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.spec.SecretKeySpec;

public class SecurityVault 
{
	public static String CIPHER_KEY = "stryg%%££¤¤$$key";
	public static String SECRET_KEY="";
	private static SecretKeySpec secretKey;
	private static byte[] keyBytes;
	
	public static void setKey(String inputKey)
    {
        try
        {
        	keyBytes = inputKey.getBytes("UTF-8");
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            keyBytes = sha.digest(keyBytes);
            keyBytes = Arrays.copyOf(keyBytes, 16);
            secretKey =  new SecretKeySpec(keyBytes, "AES");
        
        }
        catch (NoSuchAlgorithmException | UnsupportedEncodingException e)
        {
        	System.err.println(e.getMessage());
        }
    }
	
	public static SecretKeySpec getKey(String mykey)
	{
		setKey(mykey);
		return secretKey;
	}
}
