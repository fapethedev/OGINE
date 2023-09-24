package com.fapethedev.ogine.model.database.entities;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

/**
 * @author FATIGBA Abiola Pierre-Edy
 */
public record Student(
		PersonalInfo personal,
		FatherInfo father,
		MotherInfo mother,
		TutorInfo tutor,
		MoreInfo more
		){
	public record PersonalInfo(String profile,
		Name name,
		java.sql.Date birthDate,
		String sex,
		String cni,
		String bloodGroup){

		public record Name(String last, String first) implements Comparable<Name> {
			@Override
			public String toString() {
				return last.concat(" " + first);
			}

			@Override
			public int compareTo(@NotNull Name o) {
				return this.toString().compareTo(String.valueOf(o));
			}

		}

		@Override
		public String toString() {
			return name.toString()
					.concat(" " + birthDate)
					.concat(" " + sex.charAt(0))
					.concat(" " + bloodGroup);
		}
	}
	public record FatherInfo(String name,
	    String number,
		String function){

	}
	public record MotherInfo(String motherName,
		String motherNumber,
		String motherFunction){

	}

	public record TutorInfo(String tutorName,
							String tutorNumber,
							String tutorFunction){

	}
	public record MoreInfo(String phoneNumber,
		String address,
		String religion){
	}

	@Override
	public String toString()
	{
		return personal().toString();
	}
}
