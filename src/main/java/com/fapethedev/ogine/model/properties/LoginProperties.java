package com.fapethedev.ogine.model.properties;

import java.util.Properties;

import lombok.Getter;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
@Getter
public class LoginProperties 
{
	private static LoginProperties singleton;
	private Properties logProp;
	
	private LoginProperties()
	{
		logProp = PropertiesManager.getManager().getLoginProperties();
	}
	
	public static synchronized LoginProperties getManager()
	{
		if(singleton == null)
		{
			synchronized (LoginProperties.class) 
			{
				if(singleton == null)
				{

					singleton = new LoginProperties();
				}
			};
		}

		return singleton;
	}
	
	public String getPropertiesValue(String logPropKey)
	{
		return logProp.getProperty(logPropKey);
	}
	
	public void setPropertiesValue(String logPropKey, String logPropValue)
	{
		logProp.setProperty(logPropKey, logPropValue);
	}
}
