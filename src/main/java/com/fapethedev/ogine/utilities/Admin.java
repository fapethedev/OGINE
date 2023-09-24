package com.fapethedev.ogine.utilities;

import com.fapethedev.ogine.model.database.entities.User;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
public class Admin 
{
	private static String name;
	private static String role;
	
	public static void using(User current)
	{
		name = current.username();
		role = current.role().getName();
	}
	
	public static String getName()
	{
		return name;
	}
	
	public static String getRole()
	{
		return role;
	}
}
