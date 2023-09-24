package com.fapethedev.ogine.model.database.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fapethedev.ogine.model.database.entities.Student;
import com.fapethedev.ogine.model.database.exception.StudentManagerException;
import com.fapethedev.ogine.view.component.label.Message;
import com.fapethedev.ogine.model.database.util.SQuery;

/**
 * @author FATIGBA Abiola Pierre-Edy
 */
public class StudentManager 
{
	private static volatile StudentManager singleton;
	private final Connection connection;
	
	private StudentManager()
	{
		connection = DBConnectionManager.getSingleton().getConnection();
	}
	
	public static StudentManager getInstance()
	{
		if(singleton == null)
		{
			synchronized(StudentManager.class)
			{
				if(singleton == null)
				{
					singleton = new StudentManager();
				}
			}
		}
		return singleton;
	}
	
	public void addStudent(Student student) throws StudentManagerException
	{
		Student.PersonalInfo personal = student.personal();
		Student.FatherInfo father = student.father();
		Student.MotherInfo mother = student.mother();
		Student.TutorInfo tutor = student.tutor();
		Student.MoreInfo more = student.more();
		try(var statement = connection.prepareStatement(SQuery.ADD_STUDENT)) {
			setStudentInfoQuery(personal, father, mother, tutor, more, statement);

			if(statement.executeUpdate() < 0)
			{
				throw new StudentManagerException(Message.FAILED_INSERT_MSG);
			}
		}
		catch(Exception e)
		{
			System.out.println("e = " + e.getMessage());
			throw new StudentManagerException(e);
		}
	}
	
	
	public void updateStudentByName(Student.PersonalInfo.Name name, Student student) throws StudentManagerException
	{
		Student.PersonalInfo personal = student.personal();
		Student.FatherInfo father = student.father();
		Student.MotherInfo mother = student.mother();
		Student.TutorInfo tutor = student.tutor();
		Student.MoreInfo more = student.more();

		try (var pStatement = connection.prepareStatement(SQuery.UPDATE_STUDENT)) {
			setStudentInfoQuery(personal, father, mother, tutor, more, pStatement);
			pStatement.setInt(20, getIdByName(name));

			if (pStatement.executeUpdate() < 0) {
				throw new StudentManagerException(Message.FAILED_UPDATE_MSG);
			}
		}
		catch (Exception e) {
			throw new StudentManagerException(e);
		}
	}

	public void deleteStudentByName(Student.PersonalInfo.Name name) throws StudentManagerException
	{

		try (var pStatement = connection.prepareStatement(SQuery.DELETE_STUDENT_BY_ID)) {
			pStatement.setInt(1, getIdByName(name));

			if (pStatement.executeUpdate() < 0) {
				throw new StudentManagerException(Message.FAILED_DELETE_MSG);
			}
		}
		catch (Exception e) {
			throw new StudentManagerException(e);
		}
	}
	
	public boolean checkStudentName(Student.PersonalInfo.Name name) throws StudentManagerException
	{
		try(var statement = connection.prepareStatement(SQuery.GET_STUDENT_ID_BY_NAME)) {

			statement.setString(1, name.last());
			statement.setString(2, name.first());
			try(var rs = statement.executeQuery()) {
				return rs.next();
			}
		}
		catch (Exception e) {
			throw new StudentManagerException(e);
		}
	}
	
	public ArrayList<Student> getAllStudents() throws StudentManagerException
	{
		ArrayList<Student> studentList = new ArrayList<>();
		try (var statement = connection.prepareStatement(SQuery.GET_ALL_STUDENTS);
			 var rs = statement.executeQuery()){
			
			while(rs.next())
			{
				Student.PersonalInfo.Name name = new Student.PersonalInfo.Name(
						rs.getString(3),
						rs.getString(4));
				Student.PersonalInfo personalInfo = new Student.PersonalInfo(
						rs.getString(2),
						name,
						rs.getDate(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8)
				);
				Student.FatherInfo fatherInfo = new Student.FatherInfo(
						rs.getString(9),
						rs.getString(10),
						rs.getString(11)
				);
				Student.MotherInfo motherInfo = new Student.MotherInfo(
						rs.getString(12),
						rs.getString(13),
						rs.getString(14)
				);
				Student.TutorInfo tutorInfo = new Student.TutorInfo(
						rs.getString(15),
						rs.getString(16),
						rs.getString(17)
				);
				Student.MoreInfo moreInfo = new Student.MoreInfo(
						rs.getString(18),
						rs.getString(19),
						rs.getString(20)
				);
				Student student = new Student(personalInfo, fatherInfo,
						motherInfo, tutorInfo, moreInfo);

				studentList.add(student);
			}
		}
		catch(Exception e)
		{
			throw new StudentManagerException(e);
		}
		return studentList;
	}
	
	public Student getStudentByName(Student.PersonalInfo.Name name) throws StudentManagerException
	{
		try (var statement = connection.prepareStatement(SQuery.GET_STUDENT_BY_NAME)) {
			statement.setString(1, name.last());
			statement.setString(2, name.first());

			try (var rs = statement.executeQuery()) {
				if (rs.next()) {
					Student.PersonalInfo.Name nameInfo = new Student.PersonalInfo.Name(
							rs.getString(3),
							rs.getString(4));
					Student.PersonalInfo personalInfo = new Student.PersonalInfo(
							rs.getString(2),
							nameInfo,
							rs.getDate(5),
							rs.getString(6),
							rs.getString(7),
							rs.getString(8)
					);
					Student.FatherInfo fatherInfo = new Student.FatherInfo(
							rs.getString(9),
							rs.getString(10),
							rs.getString(11)
					);
					Student.MotherInfo motherInfo = new Student.MotherInfo(
							rs.getString(12),
							rs.getString(13),
							rs.getString(14)
					);
					Student.TutorInfo tutorInfo = new Student.TutorInfo(
							rs.getString(15),
							rs.getString(16),
							rs.getString(17)
					);
					Student.MoreInfo moreInfo = new Student.MoreInfo(
							rs.getString(18),
							rs.getString(19),
							rs.getString(20)
					);

					return new Student(personalInfo, fatherInfo,
							motherInfo, tutorInfo, moreInfo);
				}
				throw new StudentManagerException(Message.FAILED_SELECT_MSG);
			}
		}
		catch(Exception e)
		{
			throw new StudentManagerException(e);
		}
	}
	
	public int getIdByName(Student.PersonalInfo.Name name) throws StudentManagerException
	{
		try (var statement = connection.prepareStatement(SQuery.GET_STUDENT_ID_BY_NAME)) {
			statement.setString(1, name.last());
			statement.setString(2, name.first());
			try (ResultSet rs = statement.executeQuery()) {

				if (rs.next()) {
					return rs.getInt("id");
				}
				throw new StudentManagerException(Message.FAILED_SELECT_MSG);
			}
		}
		catch(Exception e) {
			throw new StudentManagerException(e);
		}
	}
	
	public int getMaxStudents() throws StudentManagerException
	{
		try
		{
			return countStudents(SQuery.GET_MAX_STUDENTS);
		}
		catch(Exception e)
		{
			throw new StudentManagerException(e);
		}
	}

	public int getMaxMale() throws StudentManagerException
	{
		try
		{
			return countStudents(SQuery.GET_MAX_MALE_STUDENTS);
		}
		catch(Exception e)
		{
			throw new StudentManagerException(e);
		}
	}
	
	public int getMaxFemale() throws StudentManagerException
	{
		try
		{
			return countStudents(SQuery.GET_MAX_FEMALE_STUDENTS);
		}
		catch(Exception e)
		{
			throw new StudentManagerException(e);
		}
	}

	private void setStudentInfoQuery(Student.PersonalInfo personal, Student.FatherInfo father,
									 Student.MotherInfo mother, Student.TutorInfo tutor, Student.MoreInfo more,
									 PreparedStatement pStatement) throws SQLException {
		pStatement.setString(1, personal.profile());
		pStatement.setString(2, personal.name().last());
		pStatement.setString(3, personal.name().first());
		pStatement.setDate(4, personal.birthDate());
		pStatement.setString(5, personal.sex());
		pStatement.setString(6, personal.cni());
		pStatement.setString(7, personal.bloodGroup());
		pStatement.setString(8, father.name());
		pStatement.setString(9, father.number());
		pStatement.setString(10, father.function());
		pStatement.setString(11, mother.motherName());
		pStatement.setString(12, mother.motherNumber());
		pStatement.setString(13, mother.motherFunction());
		pStatement.setString(14, tutor.tutorName());
		pStatement.setString(15, tutor.tutorNumber());
		pStatement.setString(16, tutor.tutorFunction());
		pStatement.setString(17, more.phoneNumber());
		pStatement.setString(18, more.address());
		pStatement.setString(19, more.religion());
	}

	private int countStudents(String query) throws SQLException, StudentManagerException {
		var statement = connection.prepareStatement(query);
		var rs = statement.executeQuery();
		if(rs.next())
		{
			int max = rs.getInt("max");

			rs.close();
			statement.closeOnCompletion();
			return max;
		}

		throw new StudentManagerException(Message.FAILED_SELECT_MSG);
	}
}