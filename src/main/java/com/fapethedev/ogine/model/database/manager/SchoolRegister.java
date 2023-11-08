package com.fapethedev.ogine.model.database.manager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fapethedev.ogine.model.database.entities.Register;
import com.fapethedev.ogine.model.database.exception.SchoolRegisterException;
import com.fapethedev.ogine.view.component.label.Message;

/**
 * @author FATIGBA Abiola Pierre-Edy
 */
public class SchoolRegister
{
	private static volatile SchoolRegister singleton;
	private final Connection connection;
	
	private SchoolRegister()
	{
		connection = DBConnectionManager.getSingleton().getConnection();
	}
	
	public synchronized static SchoolRegister getSingleton()
	{
		if(singleton == null)
		{
			synchronized(SchoolRegister.class)
			{
				if(singleton == null)
				{
					singleton = new SchoolRegister();
				}
			}
		}
		return singleton;
	}
	
	public void register(Register inputRegister) throws SchoolRegisterException
	{
		try
		{
			var matricule = inputRegister.matricule();
			var year = inputRegister.year();
			var studentId = inputRegister.studentId();
			var institutId = inputRegister.institutId(); 
			var levelId = inputRegister.levelId();
			var specialityId = inputRegister.specialityId();
			
			var insertQuery = "INSERT INTO active_registers(matricule, years, student_id, institut_id, level_id, speciality_id) VALUES(?,?,?,?,?,?)";
			var statement = connection.prepareStatement(insertQuery);
			statement.setString(1, matricule);
			statement.setInt(2, year);
			statement.setInt(3, studentId);
			statement.setInt(4, institutId);
			statement.setInt(5, levelId);
			statement.setInt(6, specialityId);
			
			if(statement.executeUpdate() < 0)
			{
				throw new SchoolRegisterException(Message.FAILED_UPDATE_MSG);
			}
			statement.close();
		}
		catch (SQLException sqle)
		{
			throw new SchoolRegisterException(sqle);
		}
	}
	
	public void updateRegistredStudent(Register oldRegister, Register newRegister) throws SchoolRegisterException
	{
		try
		{
			var oldMatricule = oldRegister.matricule();
			var oldStudentId = oldRegister.studentId();
			var newMatricule = newRegister.matricule();
			var newYear = newRegister.year();
			var newStudentId = newRegister.studentId();
			var newInstitutId = newRegister.institutId(); 
			var newLevelId = newRegister.levelId();
			var newSpecialityId = newRegister.specialityId();
			
			var selectQuery = "SELECT id FROM active_registers WHERE matricule=? AND student_id=?";
			var updateQuery = "UPDATE active_registers SET matricule=?, years=?, student_id=?, institut_id=?, level_id=?, speciality_id=? WHERE id=?";
			
			var statement = connection.prepareStatement(selectQuery);
			statement.setString(1, oldMatricule);
			statement.setInt(2, oldStudentId);
			var rs = statement.executeQuery();
			
			if(rs.next())
			{
				var id = rs.getInt("id");
				statement = connection.prepareStatement(updateQuery);
				statement.setString(1, newMatricule);
				statement.setInt(2, newYear);
				statement.setInt(3, newStudentId);
				statement.setInt(4, newInstitutId);
				statement.setInt(5, newLevelId);
				statement.setInt(6, newSpecialityId);
				statement.setInt(7, id);
				
				if(statement.executeUpdate() < 0)
				{
					throw new SchoolRegisterException(Message.FAILED_UPDATE_MSG);
				}
				rs.close();
				statement.closeOnCompletion();
			}
			else
			{
				throw new SchoolRegisterException(Message.FAILED_SELECT_MSG);
			}
		}
		catch(SQLException sqle)
		{
			throw new SchoolRegisterException(sqle);
		}
	}
	
	public void deleteRegistredStudent(Register inputRegister) throws SchoolRegisterException
	{
		try
		{
			var matricule = inputRegister.matricule();
			var studentId = inputRegister.studentId();
			var selectQuery = "SELECT id FROM active_registers WHERE matricule=? AND student_id=?";
			var deleteQuery = "UPDATE active_registers SET register_state = FALSE WHERE id=?";
			var statement = connection.prepareStatement(selectQuery);
			statement.setString(1, matricule);
			statement.setInt(2, studentId);
			var rs = statement.executeQuery();
			
			if(rs.next())
			{
				var id = rs.getInt("id");
				statement = connection.prepareStatement(deleteQuery);
				statement.setInt(1, id);
				
				if(statement.executeUpdate() < 0)
				{
					throw new SchoolRegisterException(Message.FAILED_DELETE_MSG);
				}
				
				rs.close();
				statement.closeOnCompletion();
			}
			else
			{
				throw new SchoolRegisterException(Message.FAILED_SELECT_MSG);
			}
		}
		catch (SQLException sqle)
		{
			throw new SchoolRegisterException(sqle);
		}
	}
	
	public boolean verifRegistredStudent(Register inputRegister) throws SchoolRegisterException
	{
		try
		{
			var studentId = inputRegister.studentId();
			var selectQuery = "SELECT id FROM active_registers WHERE student_id=?";
			var statement = connection.prepareStatement(selectQuery);
			statement.setInt(1, studentId);
			var rs = statement.executeQuery();
			
			if(rs.next())
			{
				rs.close();
				statement.closeOnCompletion();
				
				return true;
			}
			
			rs.close();
			statement.closeOnCompletion();
			
			return false;
		}
		catch (SQLException sqle)
		{
			throw new SchoolRegisterException(sqle);
		}
	}
	
	public ArrayList<Register> getRegistred() throws SchoolRegisterException
	{
		ArrayList<Register> registerList = new ArrayList<>();
		
		try
		{
			var selectQuery = "SELECT * FROM active_registers";
			var statement = connection.prepareStatement(selectQuery);
			var rs = statement.executeQuery();
			
			while(rs.next())
			{
				 var matricule = rs.getString("matricule");
				 var year = rs.getInt("years");
                 var studentId = rs.getInt("student_id");
				 var institutId = rs.getInt("institut_id");
				 var levelId = rs.getInt("level_id");
				 var specialityId = rs.getInt("speciality_id");
                                 
                 registerList.add(new Register(matricule, year, studentId, institutId, levelId, specialityId));
			}
		}
		catch (SQLException sqle)
		{
			throw new SchoolRegisterException(sqle);
		}
                
		return registerList;
	}
        
        public Register getRegistred(Register inputRegister) throws SchoolRegisterException
	{
		try
		{
            var matricule = inputRegister.matricule();
            var studentId = inputRegister.studentId();
			var selectQuery = "SELECT * FROM active_registers WHERE matricule=? AND student_id=?";
			var statement = connection.prepareStatement(selectQuery);
            statement.setString(1, matricule);
            statement.setInt(2, studentId);
			var rs = statement.executeQuery();
			
			if(rs.next())
			{
				 var outputMatricule = rs.getString("matricule");
				 var outputYear = rs.getInt("years");
                 var outputStudentId = rs.getInt("student_id");
				 var outputInstitutId = rs.getInt("institut_id");
				 var outputLevelId = rs.getInt("level_id");
				 var outputSpecialityId = rs.getInt("speciality_id");
                 return new Register(outputMatricule, outputYear, outputStudentId, outputInstitutId, outputLevelId, outputSpecialityId);
			}
                throw new SchoolRegisterException(Message.FAILED_SELECT_MSG);
		}
		catch (SQLException sqle)
		{
			throw new SchoolRegisterException(sqle);
		}
	}
        
	public int getId(Register inputRegister) throws SchoolRegisterException
	{
		try
		{
			var matricule = inputRegister.matricule();
                        var studentId = inputRegister.studentId();
			var selectQuery = "SELECT * FROM active_registers WHERE matricule=? AND student_id=?";
			var statement = connection.prepareStatement(selectQuery);
            statement.setString(1, matricule);
            statement.setInt(2, studentId);
			var rs = statement.executeQuery();
			
			if(rs.next())
			{
				rs.close();
				statement.closeOnCompletion();
				
				return rs.getInt("id");
			}
			throw new SchoolRegisterException(Message.FAILED_SELECT_MSG);
		}
		catch(SQLException sqle)
		{
			throw new SchoolRegisterException(sqle);
		}
	}
	
	public int getMax() throws SchoolRegisterException
	{
		try
		{
			var countQuerry = "SELECT COUNT(id) AS max FROM active_registers";
			var statement = connection.prepareStatement(countQuerry);
			var rs = statement.executeQuery();
			if(rs.next())
			{
				int max = rs.getInt("max");
				rs.close();
				statement.closeOnCompletion();
				return max;
			}
			
			throw new SchoolRegisterException(Message.FAILED_SELECT_MSG);
		}
		catch(SQLException sqle)
		{
			throw new SchoolRegisterException(sqle);
		}
	}
	
	public int getMaxMale() throws SchoolRegisterException
	{
		try
		{
			var countQuerry = "SELECT COUNT(active_registers.id) AS max FROM active_registers JOIN active_students ON active_registers.student_id = active_students.id WHERE active_students.sex = 'Masculin' ";
			var statement = connection.prepareStatement(countQuerry);
			var rs = statement.executeQuery();
			if(rs.next())
			{
				int max = rs.getInt("max");
				rs.close();
				statement.closeOnCompletion();
				return max;
			}
			
			throw new SchoolRegisterException(Message.FAILED_SELECT_MSG);
		}
		catch(SQLException sqle)
		{
			throw new SchoolRegisterException(sqle);
		}
	}
	
	public int getMaxFemale() throws SchoolRegisterException
	{
		try
		{
			var countQuerry = "SELECT COUNT(active_registers.id) AS max FROM active_registers "
					+ "JOIN active_students ON active_registers.student_id = active_students.id "
					+ "WHERE active_students.sex = 'Feminin' ";
			var statement = connection.prepareStatement(countQuerry);
			var rs = statement.executeQuery();
			if(rs.next())
			{
				int max = rs.getInt("max");
				rs.close();
				statement.closeOnCompletion();
				return max;
			}
			
			throw new SchoolRegisterException(Message.FAILED_SELECT_MSG);
		}
		catch(SQLException sqle)
		{
			throw new SchoolRegisterException(sqle);
		}
	}
}
