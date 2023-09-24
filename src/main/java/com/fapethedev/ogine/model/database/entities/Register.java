package com.fapethedev.ogine.model.database.entities;

/**
 * @author FATIGBA Abiola Pierre-Edy
 */
public record Register(String matricule, int year, int studentId, int institutId, int levelId, int specialityId)
{
	@Override
	public String toString()
	{
		return matricule;
	}
	
}