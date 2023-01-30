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
public class Bill extends Payment implements IPayment {
	
	private String company;
	
	private int billNumber;

	private float billAmount;

	private String month;
	
	private int day;
	
	private int year;

	public Bill() {
		
	}

	public Bill( String company, float billAmount, int day, String month, int year) {
		//super();
		this.company = company;
		this.billAmount = billAmount;
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public float getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(float billAmount) {
		this.billAmount = billAmount;
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
			String companyName = "";
			float amt = 0;
			int dayNum = 0;
			String monthName = "";
			int yearNum = 0;

			companyName = (String) billData.get(0);
			amt = (float) billData.get(1);
			dayNum = (int) billData.get(2);
			monthName = (String) billData.get(3);
			yearNum = (int) billData.get(4);

			Bill bill = new Bill(companyName, amt, dayNum, monthName, yearNum);
			return bill;
		}
		else {
			return null;
		}
	}

	@Override
	public void printBillNCheque(ArrayList<Object> listOfObjects) {
		
		for(Object obj:listOfObjects) {
			if(obj instanceof Bill) {
				LocalDate enteredDate = LocalDate.now(); //dummy value, it'll change in try block.
				//parsing date into year-month-day
				SimpleDateFormat formatter = new SimpleDateFormat("MMM");
				try {
					Date monthAbbriviation = formatter.parse(((Bill)obj).getMonth());
					formatter.applyPattern("M");
					int monthNumber = Integer.parseInt(formatter.format(monthAbbriviation)); //to get 1 instead of Jan

					enteredDate = LocalDate.of(((Bill)obj).getYear(), monthNumber, ((Bill)obj).getDay()); //YYYY-MM-DD
				} catch (ParseException e) {
					e.printStackTrace();
				}

				//checking if bill is due this month, future bill will not be shown in current month.
				LocalDate currentDate = LocalDate.now();
				currentDate.getMonth();
				//last date of current month
				LocalDate lastDateOfMonth= currentDate.withDayOfMonth(currentDate.getMonth().length(currentDate.isLeapYear()));

				if(isBillDueThisMonth(enteredDate, lastDateOfMonth)) {
					Bill bill = new Bill( ((Bill)obj).getCompany(), ((Bill)obj).getBillAmount(), ((Bill)obj).getDay(), ((Bill)obj).getMonth(), ((Bill)obj).getYear());
					System.out.println(bill.toString());
				}
			}
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
		return "Cheque No-" + chequeNumber+1 +", Payee Name:" + company + ", Amount:" + billAmount + ", Due Date: " + day + "-" + month + "-" + year;
	}
	
}
