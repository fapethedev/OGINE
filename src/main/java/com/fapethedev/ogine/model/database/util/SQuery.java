package com.fapethedev.ogine.model.database.util;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
public class SQuery {

	public static final String LOGIN_USER = "SELECT username, password, role FROM active_users WHERE username=?";
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	
	public static final String ADD_STUDENT = "INSERT INTO active_students(profile_picture, last_name, first_name, birth_date, sex, cni, blood_group, father_name," +
			" father_number, father_function, mother_name, mother_number, mother_function," +
			" tutor_name, tutor_number,tutor_function, phone_number, address, religion)" +
			" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String UPDATE_STUDENT = "UPDATE active_students SET profile_picture=?, last_name=?, first_name=?, birth_date=?,"
					+ " sex=?, cni=?, blood_group=?, father_name=?, father_number=?, father_function=?, mother_name=?,"
					+ " mother_number=?, mother_function=?, tutor_name=?, tutor_number=?, tutor_function=?,"
					+ " phone_number=?, address=?, religion=? WHERE id=?";
	public static final String GET_STUDENT_ID_BY_NAME = "SELECT id FROM active_students WHERE last_name=? AND first_name=?";
	public static final String DELETE_STUDENT_BY_ID = "UPDATE active_students SET student_state = FALSE WHERE id=?";
	public static final String GET_ALL_STUDENTS = "SELECT * FROM active_students";
	public static final String GET_STUDENT_BY_NAME = "SELECT * FROM active_students WHERE last_name=? AND first_name=?";
	public static final String GET_MAX_STUDENTS = "SELECT COUNT(id) AS max FROM active_students";
	public static final String GET_MAX_MALE_STUDENTS = "SELECT COUNT(id) AS max FROM active_students WHERE sex = 'Masculin' ";
	public static final String GET_MAX_FEMALE_STUDENTS = "SELECT COUNT(id) AS max FROM active_students WHERE sex = 'Feminin' ";
	public static final String GET_ALL_LEVELS = "SELECT * FROM levels";
}
