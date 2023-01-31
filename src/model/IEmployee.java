package model;

import java.util.ArrayList;

public interface IEmployee {
	
	Employee addNewEmployee(ArrayList<Object> empData);
	String toString(); //makes sure that it has a method to print cheques
}
