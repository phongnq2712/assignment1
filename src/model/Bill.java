package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * @author phong
 *
 */
public class Bill extends Payment {

	private String month;
	
	private int day;
	
	private int year;

	public Bill() {
		super();
	}

	public Bill(int chequeNumber, String payeeName, double amount, int day, String month, int year) {
		super();
		this.chequeNumber = chequeNumber;
		this.payeeName = payeeName;
		this.amount = amount;
		this.day = day;
		this.month = month;
		this.year = year;
	}

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

	public Bill addNewBill(ArrayList<Object> billData) {
		if(billData.size() > 0) {
			int seqCheque = 0;
			String payeeNameName = "";
			float amt = 0;
			int dayNum = 0;
			String monthName = "";
			int yearNum = 0;

			seqCheque = (int)billData.get(0);
			payeeNameName = (String) billData.get(1);
			amt = (float) billData.get(2);
			dayNum = (int) billData.get(3);
			monthName = (String) billData.get(4);
			yearNum = (int) billData.get(5);
			Bill bill = new Bill(seqCheque, payeeNameName, amt, dayNum, monthName, yearNum);
			return bill;
		}
		else {
			return null;
		}
	}

	public boolean isBillDueThisMonth(LocalDate currentDate, LocalDate lastDateOfMonth) {
		if (currentDate.isBefore(lastDateOfMonth)) {
			return true;
		} else if (currentDate.isAfter(lastDateOfMonth)) {
			return false;
		} else {
			return true; //both are same
		}
    }

	@Override
	public String toString() {
		
		LocalDate enteredDate = LocalDate.now(); //dummy value, it'll change in try block.
		//parsing date into year-month-day
		SimpleDateFormat formatter = new SimpleDateFormat("MMM");
		try {
			Date monthAbbriviation = formatter.parse(this.getMonth());
			formatter.applyPattern("M");
			int monthNumber = Integer.parseInt(formatter.format(monthAbbriviation)); //to get 1 instead of Jan

			enteredDate = LocalDate.of(this.getYear(), monthNumber, this.getDay()); //YYYY-MM-DD
		} catch (ParseException e) {
			e.printStackTrace();
		}

		//checking if bill is due this month, future bill will not be shown in current month.
		LocalDate currentDate = LocalDate.now();
		currentDate.getMonth();
		//last date of current month
		LocalDate lastDateOfMonth= currentDate.withDayOfMonth(currentDate.getMonth().length(currentDate.isLeapYear()));

		if(isBillDueThisMonth(enteredDate, lastDateOfMonth)) {
			return "Cheque No:" + chequeNumber + ", Payee Name:" + payeeName + ", Amount:" + amount + ", Due Date: " + day + "-" + month + "-" + year;
		}
		else {
			return null;
		}

	}
	
}
