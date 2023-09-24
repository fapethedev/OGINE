package com.fapethedev.ogine.utilities;

import lombok.AllArgsConstructor;

/**
 * @author FATIGBA Abiola Pierre-Edy
 */
@AllArgsConstructor
public class PicResizerException extends Exception 
{

	public PicResizerException(String message) 
	{
		super(message);
	}

	public PicResizerException(Throwable cause) 
	{
		super(cause);
	}

	public PicResizerException(String message, Throwable cause) 
	{
		super(message, cause);
	}
}
