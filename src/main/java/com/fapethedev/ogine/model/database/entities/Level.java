package com.fapethedev.ogine.model.database.entities;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
public record Level(int id, String levelName)
{

	@Override
	public String toString()
	{
		return levelName;
	}
}
