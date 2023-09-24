package com.fapethedev.ogine.model.database.exception;

/**
 * @author FATIGBA Abiola Pierre-Edy
 */
public class SchoolRegisterException extends Exception 
{
	public SchoolRegisterException(String message) 
	{
		super(message);
	}

	public SchoolRegisterException(Throwable cause) 
	{
		super(cause);
	}

	public SchoolRegisterException(String message, Throwable cause) 
	{
		super(message, cause);
	}
}
