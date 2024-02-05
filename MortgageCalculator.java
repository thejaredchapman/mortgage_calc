import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Scanner;

public class MortgageCalculator {
	 
	private static final int MONTHS_IN_A_YEAR = 12;
	private static final int DEFAULT_TERM = 30;
	private static final int TOTAL_PAYMENTS = 360;

	HashMap<String, Double> paymentStructure = new HashMap<String, Double>();
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the listing price amount:");
		float listingPrice = scanner.nextFloat();

        System.out.println("Enter the down payment amount in $:");
        float downPayment = scanner.nextFloat();
		
		System.out.println("Enter the annual interest rate:");
		float annualInterestRate = scanner.nextFloat();
        scanner.close();

        float principal = listingPrice - downPayment;
		
		float monthlyInterestRate  = annualInterestRate / MONTHS_IN_A_YEAR / 100;
		
		// MORTGAGE PAYMENT CALCULATION
        double mathPower = Math.pow(1 * annualInterestRate , TOTAL_PAYMENTS);
		double monthlyPayment = principal * (monthlyInterestRate * mathPower / (mathPower - 1));
        double totalPaybackAmount = monthlyPayment * TOTAL_PAYMENTS;

		float monthlywithoutIntrest = monthlyInterestRate / annualInterestRate;
		// need to convert or cast  into double
		
		// PRINCIPAL - MORTGAGE PAYMENT WITHOUT INTEREST

		double mathPowerNoIntrest = Math.pow(1.0, TOTAL_PAYMENTS);
		double monthlyPaymentNoIntrest = principal * (monthlywithoutIntrest * mathPowerNoIntrest / (mathPowerNoIntrest - 1));
		double remainingPrincipal = monthlyPaymentNoIntrest * TOTAL_PAYMENTS;

		double remainingInterest = totalPaybackAmount - remainingPrincipal;

		//calculatePayment (String[] args) {
		//	for the duration of the loan term
		//  while remainder = principal - monthlyPayment
		//  monthlyPayment = newPayment
		//	newPayment = remainder *  monthlyInterestRate 
		//	return newPayment
		// write recursively to return itself until duration
		// then save entries into hashmap
		// use java.util.Date to enum Month & Year for ID
		// then get it to show in graph form
		while (principal > 0)
    {	
        remainingMonths( num - 1 );
        System.out.println(num);
        num = num - 1;           // Decrementing the value of num by 1
    }  

			
		//}
		System.out.println("Monthly payment: "+ NumberFormat.getCurrencyInstance().format(monthlyPayment));
		System.out.println("Your annual interest rate is " + annualInterestRate);
        //Numberformat.getPercentInstance(val);
		System.out.println("Total payback amount or Amoritization: " + NumberFormat.getCurrencyInstance().format(totalPaybackAmount));

		System.out.println("Your remaining principal balance is " + NumberFormat.getCurrencyInstance().format(remainingPrincipal));
		System.out.println("Your remaining interest for your loan is " + NumberFormat.getCurrencyInstance().format(remainingInterest));
		System.out.println("Monthly payment without Inerest Rate: "+ NumberFormat.getCurrencyInstance().format(monthlyPaymentNoIntrest));
        //Numberformat.getPercentInstance(val);
		System.out.println("Total payback amount or Amoritzation: " + NumberFormat.getCurrencyInstance().format(totalPaybackAmount));
	}

}
