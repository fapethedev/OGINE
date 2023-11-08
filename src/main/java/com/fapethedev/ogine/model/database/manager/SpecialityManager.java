package com.fapethedev.ogine.model.database.manager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fapethedev.ogine.model.database.entities.Speciality;
import com.fapethedev.ogine.view.component.label.Message;
import com.fapethedev.ogine.model.database.entities.Institut;
import com.fapethedev.ogine.model.database.entities.Level;
import com.fapethedev.ogine.model.database.exception.InstitutManagerException;
import com.fapethedev.ogine.model.database.exception.SpecialityManagerException;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
public class SpecialityManager
{
	private static volatile SpecialityManager singleton;
	private final Connection connection;
	
	private SpecialityManager() 
	{
		connection = DBConnectionManager.getSingleton().getConnection();
	}
	
	public static synchronized SpecialityManager getSingleton()
	{
		if(singleton == null)
		{
			synchronized(SpecialityManager.class)
			{
				if(singleton == null)
				{
					singleton = new SpecialityManager();
				}
			}; 
		}
		return singleton;
	}
	
	public ArrayList<Speciality> getSpecialtyList() throws SpecialityManagerException
	{
		ArrayList<Speciality> specialityFromDB = new ArrayList<>();
		
		try
		{
			var selectQuery = "SELECT * FROM specialities";
			var statement = connection.prepareStatement(selectQuery);
			var rs = statement.executeQuery();
			
			while(rs.next())
			{
				String outputInstitut = rs.getString("speciality_name");			
				specialityFromDB.add(new Speciality(outputInstitut));
			}
			
			rs.close();
			statement.closeOnCompletion();
			return specialityFromDB;
		}
		catch(SQLException sqle)
		{
			throw new SpecialityManagerException(sqle);
		}
	}

	
	public ArrayList<Speciality> getSpecialtyList(Institut institut, Level inputLevel) throws SpecialityManagerException
	{
		ArrayList<Speciality> specialityFromDB = new ArrayList<>();
		
		try
		{
    		int id = InstitutManager.getSingleton().getId(institut);
			String levelName = inputLevel.levelName();
			//String query = "(SELECT id FROM level WHERE level_name=? AND institut_id =?)";
	        String mainSelectQuery = "SELECT speciality_name FROM specialities WHERE level_id = "
	                + "(SELECT id FROM levels WHERE level_name=? AND institut_id =?)";
			try(var statement = connection.prepareStatement(mainSelectQuery))
			{
				statement.setString(1, levelName);
	            statement.setInt(2, id);
				try(ResultSet rs = statement.executeQuery())
				{
					while(rs.next())
					{
						String outputInstitut = rs.getString("speciality_name");			
						specialityFromDB.add(new Speciality(outputInstitut));
					}
					
					return specialityFromDB;
				}
			}
		}
		catch(SQLException | InstitutManagerException sqle)
		{
			throw new SpecialityManagerException(sqle);
		}
	}
        
    public int getId(Speciality speciality) throws SpecialityManagerException
    {
        try
        {
        	var name = speciality.specialityName();
        	var selectQuery = "SELECT DISTINCT id FROM specialities WHERE speciality_name=?";
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
            	
            	throw new SpecialityManagerException(Message.FAILED_SELECT_MSG);
        	}
        }
        catch(SQLException sqle)
        {
        	throw new SpecialityManagerException(sqle);
        }
    }
}
