import java.text.NumberFormat;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Calendar;

public class MortgageCalculator {

	public static class ValueTracker{
	
		public double interestAtCurrentMonth;
		public double principalAtCurrentMonth;
		public double totalInterest;
		public double totalPrincipal;
		public String date;

		public ValueTracker(String date, double interestAtCurrentMonth, double principalAtCurrentMonth, 
				double totalInterest, double totalPrincipal) {
			this.date = date;
			this.interestAtCurrentMonth = interestAtCurrentMonth;
			this.principalAtCurrentMonth = principalAtCurrentMonth;
			this.totalInterest = totalInterest;
			this.totalPrincipal = totalPrincipal;
		}
		
		public double getInterestAtCurrentMonth(){
			return interestAtCurrentMonth;
		}

		public String toString(){
			return String.format("This will return the interest at current month %f this is the %f, this is the %f, and this is the %f\n", interestAtCurrentMonth, principalAtCurrentMonth, totalInterest, totalPrincipal);	
		}
	}
		 
	private static final int MONTHS_IN_A_YEAR = 12;
	private static final int DEFAULT_TERM = 30;
	private static final int TOTAL_PAYMENTS = 360;

	public static void main(String[] args) {

		Calendar date = Calendar.getInstance();

		ValueTracker valueT = new ValueTracker(date.getTime().toString(), DEFAULT_TERM, TOTAL_PAYMENTS, MONTHS_IN_A_YEAR, DEFAULT_TERM); 
		
		valueT.getInterestAtCurrentMonth();
		System.out.println(valueT.toString());

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the listing price amount:");
		double listingPrice = scanner.nextFloat();

        System.out.println("Enter the down payment amount in $:");
        double downPayment = scanner.nextFloat();
		
		System.out.println("Enter the annual interest rate:");
		double annualInterestRate = scanner.nextFloat();
        scanner.close();

        double principal = listingPrice - downPayment;
		   
		double P = principal;
		double t = DEFAULT_TERM;
		double n = MONTHS_IN_A_YEAR;
		double r = annualInterestRate/100;
		double monthlyPayment = (P * (r/n))/(1 - Math.pow((1+r/n),(-1*n*t)));

		double totalPaybackAmount = monthlyPayment * TOTAL_PAYMENTS;

		double totalInterest = 0;
		double currentPrincipal = P;

		ArrayList<ValueTracker>  paymentsMade = new ArrayList<ValueTracker>();

		for (int i=0; i<180; i++) {
			double monthlyInterest = currentPrincipal * (r/n);
			double monthlyPrincipal = monthlyPayment - monthlyInterest;
			totalInterest += monthlyInterest;
			currentPrincipal -= monthlyPrincipal;
	
			ValueTracker ve = new ValueTracker(date.getTime().toString(), monthlyInterest, monthlyPrincipal, totalInterest, currentPrincipal);
			paymentsMade.add(ve);
			
			String output = ve.toString();
			System.out.println(output);
		}
		
		// PRINCIPAL - MORTGAGE PAYMENT WITHOUT INTEREST

		System.out.println("Your principal is " + NumberFormat.getCurrencyInstance().format(principal));
		System.out.println("Monthly payment: "+ NumberFormat.getCurrencyInstance().format(monthlyPayment));
		System.out.println("Your annual interest rate is " + annualInterestRate);
		System.out.println("Total payback amount or Amoritzation: " + NumberFormat.getCurrencyInstance().format(totalPaybackAmount));
		
	}
}
