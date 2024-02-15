import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Scanner;

public class MortgageCalculator {

	public class ValueTracker{
	
		public double interestAtCurrentMonth;
		public double principalAtCurrentMonth;

		public ValueTracker(double interestAtCurrentMonth, double principalAtCurrentMonth) {
			this.interestAtCurrentMonth = interestAtCurrentMonth;
			this.principalAtCurrentMonth = principalAtCurrentMonth;
		}
	}
		 
	private static final int MONTHS_IN_A_YEAR = 12;
	private static final int DEFAULT_TERM = 30;
	private static final int TOTAL_PAYMENTS = 360;

	HashMap<Integer, ValueTracker> paymentStructure = new HashMap<Integer, ValueTracker>();
	public static void main(String[] args) {
		
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

		for (int i=0; i<2; i++) {
			double monthlyInterest = currentPrincipal * (r/n);
			System.out.println("this is the "+ monthlyInterest);
			double monthlyPrincipal = monthlyPayment - monthlyInterest;
			System.out.println("this is the "+ monthlyPrincipal);
			totalInterest += monthlyInterest;
		}
		
		


		// PRINCIPAL - MORTGAGE PAYMENT WITHOUT INTEREST

		double principalNoInterest = (P * (r/n)/r)/(1 - Math.pow((1+(r/n)/r),(-1*n*t)));
		double monthlyPaymentNoIntrest = principalNoInterest / 12;
		double remainingPrincipal = monthlyPaymentNoIntrest * TOTAL_PAYMENTS;

		System.out.println();
		System.out.println("Your principal is " + NumberFormat.getCurrencyInstance().format(principal));
		System.out.println("Monthly payment: "+ NumberFormat.getCurrencyInstance().format(monthlyPayment));
		System.out.println("Your annual interest rate is " + annualInterestRate);
        //Numberformat.getPercentInstance(val);
		System.out.println("Monthly payment without interest Rate: "+ NumberFormat.getCurrencyInstance().format(monthlyPaymentNoIntrest));
        //Numberformat.getPercentInstance(val);
		System.out.println("Total payback amount or Amoritzation: " + NumberFormat.getCurrencyInstance().format(totalPaybackAmount));
	}

}
