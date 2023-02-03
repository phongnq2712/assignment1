package model;

import java.util.ArrayList;

/**
 * Assignment 1
 * Student 1: 	Quoc Phong Ngo - 40230574
 * Student 2: 	Jimil Suchitkumar Prajapati - 40205477
 *  
 * IEmployee interface
 */

public interface IEmployee {
	public Employee addNewEmployee(ArrayList<Object> empData);
	public float calculateSalary();
}
