package com.fapethedev.ogine.model.properties;

import java.io.IOException;
import java.util.Properties;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
public class PropertiesManager 
{
	private static PropertiesManager singleton;
	
	private PropertiesManager()
	{
		
	}
	
	public static synchronized PropertiesManager getManager()
	{
		if(singleton == null)
		{
			synchronized (PropertiesManager.class) 
			{
				if(singleton == null)
				{
					singleton = new PropertiesManager();
				}
			};
		}

		return singleton;
	}
	
	public Properties getLoginProperties()
	{
		Properties loginProperties = new Properties();
		try
		{
			loginProperties.load(this.getClass().getResourceAsStream(null));
		}
		catch (IOException e) 
		{
			System.out.println(e.getMessage());
		}
		return loginProperties;
	}
	
	public Properties getDatabaseProperties()
	{
		Properties databaseProperties = new Properties();
		try
		{
			databaseProperties.load(this.getClass().getResourceAsStream("/properties/dbconf.properties"));
		}
		catch (IOException e) 
		{
			System.out.println(e.getMessage());
		}
		return databaseProperties;
	}
}
