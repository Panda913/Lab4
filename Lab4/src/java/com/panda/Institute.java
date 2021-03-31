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
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public   class Institute {
	
	 private static ArrayList<Faculty> faculties  = new ArrayList();
       

	

	public static  ArrayList<Faculty> getFaculties() {
		return  faculties;
	}

	public static void addFaculty(Faculty s) {
            boolean add = faculties.add(s);
             
             
	}

	public static  void removeFaculty(Faculty s) {
             boolean remove =  faculties.remove(s);
	}

//	public Faculty searchBigestFaculty() {
//		return Collections.max(faculties, Faculty::compare);
//	}

	public Faculty searchBigestFaculty() {
		Faculty bigestFaculty = faculties.get(0);
		for (Faculty faculty : faculties)
			bigestFaculty = faculty.compare(bigestFaculty) > 0 ? faculty : bigestFaculty;
		return bigestFaculty;
	}

	public int getCountAllStudents() {
		int count = 0;
		for (Iterator<Faculty> iterator = faculties.iterator(); iterator.hasNext();)
			count += iterator.next().getStudents().size();
		return count;
	}
	
	public List<Student> getExcellentStudents(){
		List<Student> excellentStudents = new ArrayList<>();
		for(Faculty f: faculties)
			for(Student s: f.getStudents())
					if(s.isExcellentStudent())
						excellentStudents.add(s);
		return excellentStudents;
	}

	

	

	@Override
	public String toString() {
		return "Institute [  faculties=" + faculties + "]";
	}

}
/*
students1.add(s8);

		Faculty f1 = new Faculty("FICT", students1);
		Faculty f2 = new Faculty("RTF", students2);
		Faculty f3 = new Faculty("FMM", students3);
		
		List<Faculty> faculties = new ArrayList<>();
		faculties.add(f1);
		faculties.add(f2);
		faculties.add(f3);
		
        Institute i = new Institute("KPI", faculties);

		System.out.println("Загальна сума студентів: " + i.getCountAllStudents());
		System.out.println("Найбільший факультет: " + i.searchBigestFaculty());
		System.out.println("Найбільший факультет: " + i.getExcellentStudents());*/
