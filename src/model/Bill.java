package model;

import java.util.ArrayList;

/**
 * 
 * @author phong
 *
 */
public class Bill extends Payment implements IPayment {
	
	private String month;
	
	private int day;
	
	private int year;

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public void printBillNCheque(ArrayList<Object> listOfObjects) {
		// TODO Auto-generated method stub
		
	}
	
}
