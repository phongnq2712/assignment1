import java.util.ArrayList;
import java.util.Scanner;

import model.Bill;
import model.Cheque;
import model.Employee;
import model.FullTimeEmp;
import model.PartTimeEmp;

/**
 * Assignment 1
 * Student 1: 	Quoc Phong Ngo - 40230574
 * Student 2: 	Jimil Suchitkumar Prajapati - 40205477
 *  
 * 
 */
public class Assignment1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Object> objects = new ArrayList<Object>();
		int seqCheque = 1;
		float salaryCheque = 0;
		while(true) {
			System.out.println("-----------------------");
			System.out.println("1. Add an employee");
			System.out.println("2. Add a bill");
			System.out.println("3. Issue cheques");
			System.out.println("4. Exit");
			System.out.print("Your choice:");
			int cmd = scanner.nextInt();
			switch (cmd){
			case 1:
				// Add new employee
				System.out.println("Enter employee type (F for Full-time, P for Part-time):");
				scanner.nextLine();
				String empType = scanner.nextLine();				
				System.out.println("Enter employee ID:");
				int empID = scanner.nextInt();
				System.out.println("Enter employee age:");
				int empAge = scanner.nextInt();
				System.out.println("Enter employee first name:");
				scanner.nextLine();
				String empFirstName = scanner.nextLine();
				System.out.println("Enter employee last name:");
				String empLastName = scanner.nextLine();
				ArrayList<Object> empData = new ArrayList<Object>();
				empData.add(empID);
				empData.add(empAge);
				empData.add(empFirstName);
				empData.add(empLastName);
				
				if("F".equals(empType)) {
					// full-time employee
					System.out.println("Enter employee salary:");
					float empSalary = scanner.nextFloat();
					FullTimeEmp fullTimeEmp = new FullTimeEmp();
					empData.add(empSalary);
					Employee newFullTimeEmp = fullTimeEmp.addNewEmployee(empData);
					salaryCheque = newFullTimeEmp.getSalary();
				} else if ("P".equals(empType)) {
					// part-time employee
					System.out.println("Enter echelon:");
					int echelon = scanner.nextInt();
					empData.add(echelon);
					System.out.println("Enter number of hour worked:");
					int hourWorked = scanner.nextInt();
					empData.add(hourWorked);
					PartTimeEmp partTimeEmp = new PartTimeEmp();
					Employee newPartTimeEmp = partTimeEmp.addNewEmployee(empData);
					salaryCheque = newPartTimeEmp.getSalary();
				}
				// add new cheque
				Cheque cheque = new Cheque(seqCheque ++, empFirstName + " " + empLastName, salaryCheque);
				objects.add(cheque);
				
				break;
			case 2:
				// Add a bill
				System.out.println("Enter name of the company:");
				scanner.nextLine();
				String company = scanner.nextLine();
				System.out.println("Enter the bill amount:");
				float amount = scanner.nextFloat();
				System.out.println("Enter the day:");
				int day = scanner.nextInt();
				System.out.println("Enter the month: (Jan, Feb, ... Dec)");
				scanner.nextLine();
				String month = scanner.nextLine();
				System.out.println("Enter the year:");
				int year = scanner.nextInt();
				ArrayList<Object> billData = new ArrayList<>();
				billData.add(seqCheque ++);
				billData.add(company);
				billData.add(amount);
				billData.add(day);
				billData.add(month);
				billData.add(year);
				Bill bill = new Bill();
				objects.add(bill.addNewBill(billData));
				
				break;
			
			case 3:
				// issue cheques using polymorphism
				if(objects.size() > 0) {
					for (int i = 0; i < objects.size(); i++) {
						if(objects.get(i).toString() != null) {
							System.out.println(objects.get(i).toString());
						}
					}
				} else {
					System.out.println("No cheques required.");
				}
												
				break;
			case 4:
				// Exit
				scanner.close();
				System.out.println("Exiting...");
				return;
				
			default:
				System.out.println("Enter right value");
			}
		}
	}

}
