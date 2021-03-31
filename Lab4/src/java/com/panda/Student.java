/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.panda;

/**
 *
 * @author Привет
 */
public class Student {
	final private String firstName;
	final private String lastName;
	private int numberRecordBook;
	private double averageScore;

	public Student(String firstName, String lastName, int numberRecordBook) {
		this(firstName, lastName, numberRecordBook ,0);
	}

	/**
	 *
	 * @param firstName
	 * @param lastName
	 * @param numberRecordBook
	 * @param averageScore     in the range from 0 to 100 inclusive
	 */

	public Student(String firstName, String lastName, int numberRecordBook, double averageScore) {
		super();
		if (checkOnDigit(firstName) || checkOnDigit(lastName))
			throw new IllegalArgumentException("Invalid first name or last name: " + firstName + " " + lastName);
		this.firstName = firstName;
		this.lastName = lastName;
		this.numberRecordBook = numberRecordBook;
		if (averageScore < 0 || averageScore > 100)
			throw new IllegalArgumentException("Invalid average score: " + averageScore);
		this.averageScore = averageScore;
	}

	private boolean checkOnDigit(String s) {
		for (char ch : s.toCharArray())
			if (Character.isDigit(ch))
				return true;
		return false;
	}

	public int getNumberRecordBook() {
		return numberRecordBook;
	}

	public void setNumberRecordBook(int numberRecordBook) {
		this.numberRecordBook = numberRecordBook;
	}

	public double getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(double averageScore) {
		this.averageScore = averageScore;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public boolean isExcellentStudent() {
		return averageScore >= 95;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(averageScore);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + numberRecordBook;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Student)) {
			return false;
		}
		Student other = (Student) obj;
		if (Double.doubleToLongBits(averageScore) != Double.doubleToLongBits(other.averageScore)) {
			return false;
		}
		if (firstName == null) {
			if (other.firstName != null) {
				return false;
			}
		} else if (!firstName.equals(other.firstName)) {
			return false;
		}
		if (lastName == null) {
			if (other.lastName != null) {
				return false;
			}
		} else if (!lastName.equals(other.lastName)) {
			return false;
		}
		if (numberRecordBook != other.numberRecordBook) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", numberRecordBook=" + numberRecordBook
				+ ", averageScore=" + averageScore + "]";
	}

}
