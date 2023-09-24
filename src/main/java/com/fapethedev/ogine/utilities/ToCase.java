package com.fapethedev.ogine.utilities;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
public class ToCase
{
	/**
	 * <p>
	 * 	Formating a string to the model of the first character will be change to upper case
	 *  and each subsequence first letter after a blanc space will be change to upper case to
	 * <p>
	 * @param str the string to format
	 * @return {@code}A new String on the model format
	 */
	public static String nameToFormat (String str)
	{	
	    String[] regex = str.strip().split("\\s");
	    StringBuilder upperCase = new StringBuilder();
	    
	    for (String sequence : regex)
	    {
	    	upperCase.append(Character.toUpperCase(sequence.charAt(0)))
	    	.append(sequence.substring(1))
	    	.append(" ");
	    }
	    
	    return upperCase.toString().strip();
	}
	
	public static String firstToUpperCase(String sequence)
	{
		var temp = sequence.strip()
				.replaceFirst(sequence.substring(0, 1), sequence.substring(0, 1)
				.toUpperCase())
				.strip();
		
		return temp;
	}
	
	public static String toUpperCase(String sequence)
	{
		var temp = sequence.toUpperCase().strip();
		
		return temp;
	}
}
