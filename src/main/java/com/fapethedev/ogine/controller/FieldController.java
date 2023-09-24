package com.fapethedev.ogine.controller;

import java.util.regex.Pattern;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
public class FieldController
{
	public static Pattern motif = null; 
	
	public static boolean isLetter(String str)
	{
		String regex = "\\D";
		motif = Pattern.compile(regex);
		var matcher = motif.matcher(str);
		
		return matcher.matches();
	}
	
	/**
	 * Check if the phone number is correct 
	 * @param str the string representation of phone number
	 * @return {@code true}
	 */
	public static boolean isPhoneNumber(String str)
	{
		String regex = "^\\+228\\d{8}$";
		motif = Pattern.compile(regex);
		var matcher = motif.matcher(str);
		
		return matcher.matches();
	}
	
	public static boolean isNumeric(int num)
	{
		int length = Integer.valueOf(num).toString().length();
		String regex = ".\\d{" + length + "}";
		motif = Pattern.compile(regex);
		var str = num + " ";
		var matcher = motif.matcher(str); 
		
		return matcher.matches();
	}
	
	public static boolean isDate(java.util.Date date)
	{
		return true;
	}
	
	public static boolean isDate(java.sql.Date date)
	{
		return true;
	}
	
	public static boolean containSQL(String str)
	{
		return true;
	}
}
