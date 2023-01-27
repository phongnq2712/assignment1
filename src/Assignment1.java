import java.time.DayOfWeek;
import java.time.Month;
import java.util.ArrayList;
import java.util.Scanner;

import model.Cheque;
import model.Employee;
import model.FullTimeEmp;
import model.PartTimeEmp;

/**
 * Assignment 1
 * Name: 		Quoc Phong Ngo
 * Student ID: 	40230574
 * @author phong
 *
 */
public class Assignment1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Object> objects = new ArrayList<Object>();
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
					objects.add(fullTimeEmp.addNewEmployee(empData));
				} else if ("P".equals(empType)) {
					// part-time employee
					System.out.println("Enter echelon:");
					int echelon = scanner.nextInt();
					empData.add(echelon);
					System.out.println("Enter number of hour worked:");
					int hourWorked = scanner.nextInt();
					empData.add(hourWorked);
					PartTimeEmp partTimeEmp = new PartTimeEmp();
					objects.add(partTimeEmp.addNewEmployee(empData));
				}
				
				break;
			case 2:
				// Add a bill
				
				break;
			
			case 3:
				System.out.println("Enter B for Bills, C for Cheques:");
				scanner.nextLine();
				String typeOfPayment = scanner.nextLine();
				if(objects.size() > 0) {
					if("C".equals(typeOfPayment)) {
						// print cheque of employees
						Cheque cheque = new Cheque();
						cheque.printBillNCheque(objects);
					}
				} else {
					System.out.println("No data found to issue cheque/bill");
				}
												
				break;
			case 4:
				scanner.close();
				System.out.println("shutting down...");
				return;
				
			default:
				throw new IllegalArgumentException("Unexpected value: " + cmd);
			}
		}
	}

}
