package model;

/**
 * Assignment 1
 * Student 1: 	Quoc Phong Ngo - 40230574
 * Student 2: 	
 *  
 * Cheque class
 */
public class Cheque extends Payment {

 	public Cheque() {
 		super();
 	}
	
 	public Cheque(int chequeNumber, String payeeName, float amount) {
 		super();
 		this.chequeNumber = chequeNumber;
 		this.payeeName = payeeName;
 		this.amount = amount;
 	}

 	@Override
 	public String toString() {
 		return "Cheque No:" + chequeNumber + ", Payee Name:" + payeeName + ", Amount:" + String.format("%.02f", amount);
 	}
	
}
