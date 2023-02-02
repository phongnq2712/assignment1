package model;

import java.util.ArrayList;

/**
 * Assignment 1
 * Student 1: 	Quoc Phong Ngo - 40230574
 * Student 2: 	Jimil Suchitkumar Prajapati - 40205477
 *  
 * FullTimeEmp class
 */

public class FullTimeEmp extends Employee implements IEmployee {
	
	public FullTimeEmp() {
		super();
	}

	public FullTimeEmp(int ID, int age, String firstName, 
			String lastName, float salary) {
		super();
		this.ID = ID;
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}

	@Override
	public Employee addNewEmployee(ArrayList<Object> empData) {
		if(empData.size() > 0) {
			int empID = 0;
			int empAge = 0;
			String empFirstName = "";
			String empLastName = "";
			float empSalary = 0;
			empID = (int) empData.get(0);
			empAge = (int) empData.get(1);
			empFirstName = (String) empData.get(2);
			empLastName = (String) empData.get(3);
			empSalary = (Float) empData.get(4);
			FullTimeEmp fullTimeEmp = new FullTimeEmp(empID, empAge, empFirstName, empLastName, empSalary);
			
			return fullTimeEmp;
		}
		return null;
	}

	@Override
	public String toString() {
		return " Payee Name:" + firstName +" "+lastName + ", Amount:" + salary;
	}

	@Override
	public float calculateSalary(int echelon, int hourWorked) {
		return salary;
	}

	

}
