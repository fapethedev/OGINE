package com.fapethedev.ogine.model.database.exception;

/**
 * @author FATIGBA Abiola Pierre-Edy
 */
public class DBConnectionException extends RuntimeException 
{
	public DBConnectionException(String message) 
	{
		super(message);
	}

	public DBConnectionException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
