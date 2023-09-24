package com.fapethedev.ogine.model.database.manager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fapethedev.ogine.model.database.entities.Institut;
import com.fapethedev.ogine.model.database.exception.LevelManagerException;
import com.fapethedev.ogine.model.database.util.SQuery;
import com.fapethedev.ogine.view.component.label.Message;
import com.fapethedev.ogine.model.database.entities.Level;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
public class LevelManager
{
	private static volatile LevelManager singleton;
	private final Connection connection;
	
	private LevelManager() 
	{
		connection = DBConnectionManager.getSingleton().getConnection();
	}
	
	/**
	 * 
	 * 
	 * @return singleton of LevelCombo type 
	 * which will call the levelCombo method
	 */
	public static LevelManager getSingleton()
	{
		if(singleton == null)
		{
			synchronized(LevelManager.class)
			{
				if(singleton == null)
				{
					singleton = new LevelManager();
				}
			}; 
		}
		return singleton;
	}
	
	public ArrayList<Level> getAllLevels() throws LevelManagerException
	{
		ArrayList<Level> levels = new ArrayList<>();

		try(var statement = connection.prepareStatement(SQuery.GET_ALL_LEVELS))
		{
			try(var rs = statement.executeQuery())
			{
				while(rs.next())
				{
					int id = rs.getInt(1);
					String name = rs.getString(2);
					levels.add(new Level(id, name));
				}
			}
		}
		catch(SQLException sqle)
		{
			throw new LevelManagerException(sqle);
		}

		return levels;
	}
	
	public ArrayList<Level> getLevelList(Institut inputInstitut) throws LevelManagerException
	{
		ArrayList<Level> levelFromDB = new ArrayList<>();
		
		try
		{
			String institutName = inputInstitut.institutName();
			String query = new String("SELECT level_name FROM levels WHERE institut_id = (SELECT id FROM institut_view WHERE institut_name=?)");
			
			try(var statement = connection.prepareStatement(query))
			{
				statement.setString(1, institutName);
				try(ResultSet rs = statement.executeQuery())
				{
					while(rs.next())
					{
						String outputLevel = rs.getString("level_name");
						levelFromDB.add(new Level(rs.getInt(1), outputLevel));
					}
					
					return levelFromDB;
				}
			}
		}
		catch(SQLException sqle)
		{
			throw new LevelManagerException(sqle);
		}	
	}
	
	public int getId(Level inputLevel) throws LevelManagerException
    {
        try
        {
        	var name = inputLevel.levelName();
        	var selectQuery = "SELECT DISTINCT id FROM levels WHERE level_name=?";
        	try(var statement = connection.prepareStatement(selectQuery))
        	{
        		statement.setString(1, name);
            	try(var rs = statement.executeQuery())
            	{
    	        	if(rs.next())
    	        	{
    	        		int id = rs.getInt("id");
    	                rs.close();
    	        		statement.closeOnCompletion();
    				
    	        		return id; 
    	        	}
            	}
        	}
        	throw new LevelManagerException(Message.FAILED_SELECT_MSG);
        }
        catch(SQLException sqle)
        {
        	throw new LevelManagerException(sqle);
        }
    }
}
