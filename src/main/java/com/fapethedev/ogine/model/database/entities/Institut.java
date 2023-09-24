package com.fapethedev.ogine.model.database.entities;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
public record Institut(String institutName)
{

	@Override
	public String toString()
	{
		return institutName;
	}
	
}
