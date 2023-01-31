// package model;

// import java.util.ArrayList;

// /**
//  * 
//  * @author phong
//  *
//  */
// public class Cheque extends Payment implements IPayment {

// 	public Cheque() {
// 		super();
// 	}
	
// 	public Cheque(int chequeNumber, String payeeName, double amount) {
// 		super();
// 		this.chequeNumber = chequeNumber;
// 		this.payeeName = payeeName;
// 		this.amount = amount;
// 	}

// 	@Override
// 	public void printBillNCheque(ArrayList<Object> listOfObjects) {
// 		int sequentialCheckNo = 1;
// 		for(Object obj:listOfObjects) {
// 			if(obj instanceof Employee) {
// 				Cheque cheque = new Cheque(sequentialCheckNo ++, ((Employee)obj).getFirstName() + " " + ((Employee)obj).getLastName(), 
// 						((Employee)obj).getSalary());
// 				System.out.println(cheque.toString());
// 			}
// 		}
// 	}
	
// 	@Override
// 	public String toString() {
// 		return "Cheque No:" + chequeNumber + ", Payee Name:" + payeeName + ", Amount:" + amount;
// 	}
	
// }
