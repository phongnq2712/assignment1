package model;

import java.util.ArrayList;
import utility.Constant;

public class PartTimeEmp extends Employee implements IEmployee {
	
	private int echelon;
	
	private int numberOfHour;
	
	public PartTimeEmp() {
		super();
	}

	public PartTimeEmp(int ID, int age, String lastName, 
			String firstName, int echelon, int numberOfHour, float salary) {
		super();
		this.ID = ID;
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
		this.echelon = echelon;
		this.numberOfHour = numberOfHour;
		this.salary = salary;
	}
	
	public int getEchelon() {
		return echelon;
	}

	public void setEchelon(int echelon) {
		this.echelon = echelon;
	}

	public int getNumberOfHour() {
		return numberOfHour;
	}

	public void setNumberOfHour(int numberOfHour) {
		this.numberOfHour = numberOfHour;
	}

	@Override
	public Employee addNewEmployee(ArrayList<Object> empData) {
		if(empData.size() > 0) {
			int empID = 0;
			int empAge = 0;
			String empFirstName = "";
			String empLastName = "";
			float empSalary = 0;
			int echelon = 0;
			int hourWorked = 0;
			empID = (int) empData.get(0);
			empAge = (int) empData.get(1);
			empFirstName = (String) empData.get(2);
			empLastName = (String) empData.get(3);
			echelon = (int) empData.get(4);
			hourWorked = (int) empData.get(5);
			if(echelon > 0 && hourWorked > 0) {
				switch (echelon) {
				case 1:
					empSalary = Constant.ECHELON_1  * hourWorked;
					break;
				case 2:
					empSalary = Constant.ECHELON_2  * hourWorked;
					break;
				case 3:
					empSalary = Constant.ECHELON_3  * hourWorked;
					break;
				case 4:
					empSalary = Constant.ECHELON_4  * hourWorked;
					break;
				case 5:
					empSalary = Constant.ECHELON_5  * hourWorked;
					break;

				default:
					break;
				}
			}
			PartTimeEmp partTimeEmp = new PartTimeEmp(empID, empAge, empFirstName, empLastName, 
					echelon, hourWorked, empSalary);
			
			return partTimeEmp;
		}
		return null;
	}

}
