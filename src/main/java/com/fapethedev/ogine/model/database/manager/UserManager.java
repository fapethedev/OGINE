package com.fapethedev.ogine.model.database.manager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fapethedev.ogine.model.database.entities.Role;
import com.fapethedev.ogine.model.database.entities.User;
import com.fapethedev.ogine.model.database.exception.UserManagerException;
import com.fapethedev.ogine.view.component.label.Message;
import com.fapethedev.ogine.model.database.util.SQuery;

/**
 * @author FATIGBA Abiola Pierre-Edy
 */
public class UserManager 
{
	private static volatile UserManager singleton;
	private final Connection connection;
	
	private UserManager() 
	{
		connection = DBConnectionManager.getSingleton().getConnection();
	}
	
	/**
	 * 
	 * 
	 * @return singleton of UserLogin type 
	 * which will call the login method
	 */
	public static UserManager getSingleton()
	{
		if(singleton == null)
		{
			synchronized(UserManager.class)
			{
				if(singleton == null)
				{
					singleton = new UserManager();
				}
			}; 
		}
		return singleton;
	}
	
	/**
	 * This method will get and return an unique user from database
	 * 
	 * @param username is considere like the text which is set by the application's user
	 * like his username when he tries to connect to the application
	 * @param password is consider like the text which is set by the application's user
	 * like his password when he tries to connect to the application
	 * @return new User which is database entities for data treatment
	 * @throws UserLoginException 
	 */
	public User login(User inputUser) throws UserManagerException
	{
		try
		{
			String username = inputUser.username();
			String password = inputUser.password();
			var statement = connection.prepareStatement(SQuery.LOGIN_USER);
			statement.setString(1, username);
			try (ResultSet rs = statement.executeQuery()) 
			{
				if(rs.next())
				{
					var dbPassword = rs.getString(SQuery.PASSWORD);
					if(dbPassword.compareTo(password) == 0)
					{
						String outputUsername = rs.getString(SQuery.USERNAME);
						String outputPassword = dbPassword;
						String outputRole = rs.getString("role");
						rs.close();
						statement.closeOnCompletion();
						return new User(
								outputUsername,
								outputPassword,
								Role.fromName(outputRole));
					}
					throw new UserManagerException(Message.PASSWORD_ERROR_MSG);
				}
			}
			
			throw new UserManagerException(Message.USERNAME_ERROR_MSG);
		}
		catch(SQLException sqle)
		{
			throw new UserManagerException(sqle);
		}
	}
}
