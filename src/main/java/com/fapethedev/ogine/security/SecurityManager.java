package com.fapethedev.ogine.security;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class SecurityManager 
{
    //encryption
    public static String encrypt (String strToEnc)
    {
        try
        {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, SecurityVault.getKey(SecurityVault.CIPHER_KEY));
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEnc.getBytes("UTF-8")));
            
        }
        catch(UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e)
        {
            return null;
        }
        
    }
    
    //decryption
    public static String decrypt(String strToDec)
    {
        try
        {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, SecurityVault.getKey(SecurityVault.CIPHER_KEY));
            return new String (cipher.doFinal(Base64.getDecoder().decode(strToDec)));
            
        }
        catch(InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e)
        {
            return null; 
        }
    }
    
    //Hashing
    public static String toHash(String strToHash)
    {
    	MessageDigest digest = null;
    	StringBuilder builder = new StringBuilder();
		try 
		{
			digest = MessageDigest.getInstance("SHA-256");
		} 
		catch (NoSuchAlgorithmException e) 
		{
			System.err.println(e.getMessage());
			return null;
		}
		
    	byte[] hash = digest.digest(strToHash.getBytes(StandardCharsets.UTF_8));
    	for(int i =0; i < hash.length; i++)
    	{
    		String str = Integer.toHexString(0xff & hash[i]);
    		if (str.length() == 1) 
    		{
    			builder.append('0');
			}
    		builder.append(str);
    	}
    	
    	return builder.toString();
    }
    
}
