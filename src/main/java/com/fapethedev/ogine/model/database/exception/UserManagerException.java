package com.fapethedev.ogine.model.database.exception;

/**
 * @author FATIGBA Abiola Pierre-Edy
 */
public class UserManagerException extends Exception
{
	public UserManagerException(String message) 
	{
		super(message);
	}

	public UserManagerException(Throwable cause) 
	{
		super(cause);
	}

	public UserManagerException(String message, Throwable cause) 
	{
		super(message, cause);	
	}
}
