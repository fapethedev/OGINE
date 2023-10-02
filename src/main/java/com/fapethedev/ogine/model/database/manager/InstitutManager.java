package com.fapethedev.ogine.model.database.manager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fapethedev.ogine.model.database.exception.InstitutManagerException;
import com.fapethedev.ogine.view.component.label.Message;
import com.fapethedev.ogine.model.database.entities.Institut;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
public class InstitutManager
{
	private static volatile InstitutManager singleton;
	private final Connection connection;
	
	private InstitutManager() 
	{
		connection = DBConnectionManager.getSingleton().getConnection();
	}
	
	public static synchronized InstitutManager getSingleton()
	{
		if(singleton == null)
		{
			synchronized(UserManager.class)
			{
				if(singleton == null)
				{
					singleton = new InstitutManager();
				}
			}; 
		}
		return singleton;
	}
	
	public ArrayList<Institut> getAllInstituts() throws InstitutManagerException
	{
		ArrayList<Institut> institutFromDB = new ArrayList<>();
		
		try
		{
			var statement = connection.prepareStatement("SELECT DISTINCT institut_name FROM instituts");
			ResultSet rs = statement.executeQuery();
			
			while(rs.next())
			{
				String outputInstitut = rs.getString("institut_name");			
				institutFromDB.add(new Institut(outputInstitut));
			}
			
			rs.close();
			statement.closeOnCompletion();
			
			return institutFromDB;
		}
		catch(SQLException sqle)
		{
			throw new InstitutManagerException(sqle);
		}	
	}
	
	public int getId(Institut inputInstitut) throws InstitutManagerException
    {
        try
        {
        	var name = inputInstitut.institutName();
        	var selectQuery = "SELECT DISTINCT id FROM instituts WHERE institut_name=?";
        	var statement = connection.prepareStatement(selectQuery);
        	statement.setString(1, name);
        	var rs = statement.executeQuery();
		
        	if(rs.next())
        	{
                int id = rs.getInt("id");
        		rs.close();
        		statement.closeOnCompletion();
			
        		return id;
        	}
        	throw new InstitutManagerException(Message.FAILED_SELECT_MSG);
        }
        catch(SQLException sqle)
        {
        	throw new InstitutManagerException(sqle);
        }
    }
}
