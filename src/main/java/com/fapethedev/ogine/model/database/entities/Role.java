package com.fapethedev.ogine.model.database.entities;

/**
 * @author FATIGBA Abiola Pierre-Edy
 */
public enum Role 
{
	 
	ADMINISTRATOR("administrator"),
	PROFESSOR("professor"),
	GUEST("guest"); 
	
	private final String rolename;
	
	Role(String rolename)
	{
		this.rolename = rolename;
	}
	
	public static Role fromName(String rolename)
	{
		return switch(rolename)
				{
					case "administrator" -> ADMINISTRATOR;
					case "professor" -> PROFESSOR;
					case "guest" -> GUEST;
					default -> throw new IllegalArgumentException("Les seuls valeurs permises pour rolename sont : administrator, professor et guest");
				};
	}
	
	public String getName()
	{
		return rolename;
	}
}
