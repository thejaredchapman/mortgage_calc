import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
	
	private static final int MONTHS_IN_A_YEAR = 12;
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the listing price amount:");
		float listingPrice = scanner.nextFloat();

        System.out.println("Enter the down payment amount in $:");
        float downPayment = scanner.nextFloat();
		
		System.out.println("Enter the annual interest rate:");
		float annualInterestRate = scanner.nextFloat();
		
		System.out.println("Enter the term in years:");
		int termInYears = scanner.nextInt();

        scanner.close();

        float principal = listingPrice - downPayment;
		
		float monthlyInterestRate  = annualInterestRate / MONTHS_IN_A_YEAR / 100;
		int numberOfPayments = termInYears * MONTHS_IN_A_YEAR;
		
        double mathPower = Math.pow(1 * annualInterestRate , numberOfPayments);
		double monthlyPayment = principal * (monthlyInterestRate * mathPower / (mathPower - 1));
        double totalPaybackAmount = monthlyPayment * numberOfPayments;

		System.out.println("Monthly payment: "+ NumberFormat.getCurrencyInstance().format(monthlyPayment));
		System.out.println("Your annual interest rate is " + annualInterestRate);
        //Numberformat.getPercentInstance(val);
		System.out.println("Total payback amount: " + NumberFormat.getCurrencyInstance().format(totalPaybackAmount));
	}

}
