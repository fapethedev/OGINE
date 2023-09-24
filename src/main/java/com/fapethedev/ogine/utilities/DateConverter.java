package com.fapethedev.ogine.utilities;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * @author FATIGBA Abiola Pierre-Edy
 */
public class DateConverter 
{
	/**
	 * <p>
	 * This is very help full function that will convert an java.util.Date object
	 * into a java.sql.Date object <p>
	 * @param lDate the date from java.util package that will be converted
	 * @return a Date object's from java.sql package
	 */
	public static java.sql.Date toSQLDate(java.util.Date lDate)
	{
		return new java.sql.Date(lDate.getTime());
	}

}
