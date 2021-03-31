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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Faculty {
	private String name;
	private List<Student> students;

	public Faculty(String name, List<Student> students) {
		super();
		this.name = name;
		this.students = students;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return new ArrayList<>(students);
	}

	public void addStudent(Student s) {
		this.students.add(s);
	}

	public void removeStudent(Student s) {
		this.students.remove(s);
	}

	public List<Student> getExcellentStudents() {
		List<Student> excellentStudents = new ArrayList<>();
		for (Iterator iterator = students.iterator(); iterator.hasNext(); ) {
			Student s = (Student) iterator.next();
			if (s.isExcellentStudent())
				excellentStudents.add(s);
		}
		return excellentStudents;
	}


	
	public int compare(Faculty other) {
		return this.students.size()-other.students.size();
	}

	@Override
	public String toString() {
		return "Faculty [name=" + name + "]";
	}

}

