package com.fapethedev.ogine.model.database.manager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fapethedev.ogine.model.database.entities.SchoolStudent;
import com.fapethedev.ogine.view.component.label.Message;
import com.fapethedev.ogine.model.database.exception.SchoolStudentManagerException;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
public class SchoolStudentManager 
{
	private static volatile SchoolStudentManager singleton;
	private final Connection connection;
	
	private SchoolStudentManager()
	{
		connection = DBConnectionManager.getSingleton().getConnection();
	}
	
	public synchronized static SchoolStudentManager getSingleton()
	{
		if(singleton == null)
		{
			synchronized(SchoolStudentManager.class)
			{
				if(singleton == null)
				{
					singleton = new SchoolStudentManager();
				}
			}
		}
		return singleton;
	}
	
	public ArrayList<SchoolStudent> getSchoolStudent() throws SchoolStudentManagerException
	{
		ArrayList<SchoolStudent> schoolStudentList = new ArrayList<>();
			
		try
		{
			var selectQuery = "SELECT R.years, R.matricule, S.profile_picture, S.last_name, S.first_name,"
					+ " S.sex, I.institut_name, L.level_name, P.speciality_name FROM"
					+ " active_registers R JOIN active_students S JOIN instituts I JOIN levels L"
					+ " JOIN specialities P WHERE R.student_id = S.id AND R.institut_id = I.id"
					+ " AND R.level_id = L.id AND R.speciality_id = P.id";
			var statement = connection.prepareStatement(selectQuery);
			
			try (var rs = statement.executeQuery()) 
			{
				while(rs.next())
				{
					int outputYear = rs.getInt("R.years");
					String outputMatricule = rs.getString("R.matricule");
					String outputLastname = rs.getString("S.last_name");
					String outputFirstname = rs.getString("S.first_name");
					String outputSex = rs.getString("S.sex");
					String outputInstitut =	rs.getString("I.institut_name");
					String outputLevel = rs.getString("L.level_name");
					String outputSpeciality = rs.getString("P.speciality_name");
					String outputProfile = rs.getString("S.profile_picture");
					
					schoolStudentList.add(new SchoolStudent(outputYear, outputMatricule, outputLastname, outputFirstname,
							outputSex, outputInstitut, outputLevel, outputSpeciality, outputProfile));
				}
				rs.close();
			}
			
			statement.closeOnCompletion();
			
			return schoolStudentList;
		}
		catch(SQLException sqle)
		{
			throw new SchoolStudentManagerException(sqle);
		}
	}
	
	public ArrayList<SchoolStudent> searchSchoolStudent(String searchableValue) throws SchoolStudentManagerException
	{
		ArrayList<SchoolStudent> schoolStudentList = new ArrayList<>();
			
		try
		{
			var selectQuery = "SELECT R.years, R.matricule, S.profile_picture, S.last_name, S.first_name,"
					+ " S.sex, I.institut_name, L.level_name, P.speciality_name FROM"
					+ " active_registers R JOIN active_students S JOIN instituts I JOIN levels L"
					+ " JOIN specialities P WHERE R.student_id = S.id AND R.institut_id = I.id"
					+ " AND R.level_id = L.id AND R.speciality_id = P.id AND S.last_name LIKE ?";
			var statement = connection.prepareStatement(selectQuery);
			statement.setString(1, "%" + searchableValue + "%");
			
			try (var rs = statement.executeQuery()) 
			{
				while(rs.next())
				{
					int outputYear = rs.getInt("R.years");
					String outputMatricule = rs.getString("R.matricule");
					String outputLastname = rs.getString("S.last_name");
					String outputFirstname = rs.getString("S.first_name");
					String outputSex = rs.getString("S.sex");
					String outputInstitut =	rs.getString("I.institut_name");
					String outputLevel = rs.getString("L.level_name");
					String outputSpeciality = rs.getString("P.speciality_name");
					String outputProfile = rs.getString("S.profile_picture");
					
					schoolStudentList.add(new SchoolStudent(outputYear, outputMatricule, outputLastname, outputFirstname,
							outputSex, outputInstitut, outputLevel, outputSpeciality, outputProfile));
				}
				rs.close();
			}
			
			statement.closeOnCompletion();
			
			
			return schoolStudentList;
		}
		catch(SQLException sqle)
		{
			throw new SchoolStudentManagerException(sqle);
		}
	}
	
	public ArrayList<SchoolStudent> searchSchoolStudent(String searchableValue, String searchableClause) throws SchoolStudentManagerException
	{
		ArrayList<SchoolStudent> schoolStudentList = new ArrayList<>();
			
		try
		{
			var selectQuery = "SELECT R.years, R.matricule, S.profile_picture, S.last_name, S.first_name,"
					+ " S.sex, I.institut_name, L.level_name, P.speciality_name FROM"
					+ " active_registers R JOIN active_students S JOIN instituts I JOIN levels L"
					+ " JOIN specialities P WHERE R.student_id = S.id AND R.institut_id = I.id"
					+ " AND R.level_id = L.id AND R.speciality_id = P.id AND " + searchableClause + "LIKE ?";
			var statement = connection.prepareStatement(selectQuery);
			statement.setString(1, "%" + searchableValue + "%");
			try (var rs = statement.executeQuery()) 
			{
				while(rs.next())
				{
					int outputYear = rs.getInt("R.years");
					String outputMatricule = rs.getString("R.matricule");
					String outputLastname = rs.getString("S.last_name");
					String outputFirstname = rs.getString("S.first_name");
					String outputSex = rs.getString("S.sex");
					String outputInstitut =	rs.getString("I.institut_name");
					String outputLevel = rs.getString("L.level_name");
					String outputSpeciality = rs.getString("P.speciality_name");
					String outputProfile = rs.getString("S.profile_picture");
					
					schoolStudentList.add(new SchoolStudent(outputYear, outputMatricule, outputLastname, outputFirstname,
							outputSex, outputInstitut, outputLevel, outputSpeciality, outputProfile));
				}
				rs.close();
			}
			
			statement.closeOnCompletion();
			
			return schoolStudentList;
		}
		catch(SQLException sqle)
		{
			throw new SchoolStudentManagerException(sqle);
		}
	}
	
	public int getMax() throws SchoolStudentManagerException
	{
		try
		{
			var countQuery = "SELECT COUNT(*) AS max FROM"
					+ " active_registers R JOIN active_students S JOIN instituts I JOIN levels L"
					+ " JOIN specialities P WHERE R.student_id = S.id AND R.institut_id = I.id"
					+ " AND R.level_id = L.id AND R.speciality_id = P.id";
			var statement = connection.prepareStatement(countQuery);
			
			try (var rs = statement.executeQuery()) 
			{
				if(rs.next())
				{
					int max = rs.getInt("max");
					
					rs.close();
					statement.closeOnCompletion();
					
					return max;
				}
			}
			
			throw new SchoolStudentManagerException(Message.FAILED_SELECT_MSG);
		}
		catch(SQLException sqle)
		{
			throw new SchoolStudentManagerException(sqle);
		}
	}
	
	public int getMaxMale() throws SchoolStudentManagerException
	{
		try
		{
			var countQuery = "SELECT COUNT(*) AS max FROM"
					+ " active_registers R JOIN active_students S JOIN instituts I JOIN levels L"
					+ " JOIN specialities P WHERE R.student_id = S.id AND R.institut_id = I.id"
					+ " AND R.level_id = L.id AND R.speciality_id = P.id AND S.sex = 'Masculin' ";
			var statement = connection.prepareStatement(countQuery);
			
			try (var rs = statement.executeQuery()) 
			{
				if(rs.next())
				{
					int max = rs.getInt("max");
					
					rs.close();
					statement.closeOnCompletion();
					
					return max;
				}
			}
			
			throw new SchoolStudentManagerException(Message.FAILED_SELECT_MSG);
		}
		catch(SQLException sqle)
		{
			throw new SchoolStudentManagerException(sqle);
		}
	}
	
	public int getMaxFemale() throws SchoolStudentManagerException
	{
		try
		{
			var countQuery = "SELECT COUNT(*) AS max FROM"
					+ " active_registers R JOIN active_students S JOIN instituts I JOIN levels L"
					+ " JOIN specialities P WHERE R.student_id = S.id AND R.institut_id = I.id"
					+ " AND R.level_id = L.id AND R.speciality_id = P.id AND S.sex = 'Feminin' ";
			var statement = connection.prepareStatement(countQuery);
			
			try (var rs = statement.executeQuery()) 
			{
				if(rs.next())
				{
					int max = rs.getInt("max");
					
					rs.close();
					statement.closeOnCompletion();
					
					return max;
				}
			}
			
			throw new SchoolStudentManagerException(Message.FAILED_SELECT_MSG);
		}
		catch(SQLException sqle)
		{
			throw new SchoolStudentManagerException(sqle);
		}
	}
}
