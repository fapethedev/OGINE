package com.fapethedev.ogine.model.database.entities;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
public record Speciality(String specialityName) 
{
	@Override
	public String toString()
	{
		return specialityName;
		
	}
}
