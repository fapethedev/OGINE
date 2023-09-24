package com.fapethedev.ogine.model.database.exception;

/**
 * @author FATIGBA Abiola Pierre-Edy
 */
public class StudentManagerException extends Exception 
{
	public StudentManagerException(String message) 
	{
		super(message);
	}

	public StudentManagerException(Throwable cause) 
	{
		super(cause);
	}

	public StudentManagerException(String message, Throwable cause) 
	{
		super(message, cause);
	}
}
