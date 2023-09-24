package com.fapethedev.ogine.model.database.manager;

import com.fapethedev.ogine.model.database.exception.DBConnectionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author FATIGBA Abiola Pierre-Edy
 */
public final class DBConnectionManager 
{
	private Connection connection;
	
	private static DBConnectionManager singleton;
	
	private DBConnectionManager()
	{
		
	}
	
	public synchronized static DBConnectionManager getSingleton()
	{
		if(singleton == null)
		{
			singleton = new DBConnectionManager();
		}
		
		return singleton;		
	}
	
	public synchronized static DBConnectionManager getSingleton(String hostname, int port, String database, String username, String password)
	{
		if(singleton == null)
		{
			singleton = new DBConnectionManager(hostname, port, database, username, password);
		}
		
		return singleton;
	}
	
	public synchronized static DBConnectionManager getSingleton(Properties properties)
	{
		if(singleton == null)
		{
			var hostname = properties.getProperty("database.config.hostname");
			int port = Integer.parseInt(properties.getProperty("database.config.port"));
			var database = properties.getProperty("database.config.scheme");
			var username = properties.getProperty("database.config.username");
			var password = properties.getProperty("database.config.passwrd");
			
			singleton = new DBConnectionManager( hostname, port, database, username, password);
		}
		
		return singleton;
	}
	
	private DBConnectionManager(String hostname, int port, String database, String username, String password) 
	{
		String connectionURL = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";
		
		try 
		{
			connection = DriverManager.getConnection(connectionURL, username, password);
		}
		catch (SQLException e) 
		{
			throw new DBConnectionException("Echec de la connection", e);
		}
	}
	
	public Connection getConnection()
	{
		return connection;
	}
	
	public void closeConnection()
	{
		try 
		{
			connection.close();
		} 
		catch (SQLException e) 
		{
			throw new DBConnectionException("Erreur lors de la fermeture de la connexion", e);
		}
	}
}
