import java.text.NumberFormat;
import java.util.Scanner;

public class SalaryAffordability {

    private static double LOW_RANGE = .25;
    private static double MID_RANGE = .36;
    private static double HIGH_RANGE = .40;


    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your gross salary?");
        double salary = scanner.nextDouble();

        System.out.println("What are you *TOTAL* monthly debts including student loans?");
        double monthlyDebts = scanner.nextDouble();

        double monthlySalary = salary / 12;
        
        double monthlyLowRange = monthlySalary * LOW_RANGE;
        double lowListingPrice = monthlyLowRange * 360;

        double monthlyMidRange = monthlySalary * MID_RANGE;
        double midListingPrice = monthlyMidRange * 360;

        double monthlyHighRange = monthlySalary * HIGH_RANGE;
        double highListingPrice = monthlyHighRange * 360;

        scanner.close();

        System.out.println("These figures are total including intrest and taxes");
        System.out.println("Based on what you can afford in ranges 25%, 36% & 40% ");
        System.out.println("low monthly payment " + NumberFormat.getCurrencyInstance().format(monthlyLowRange));
        System.out.println("low listing price " + NumberFormat.getCurrencyInstance().format(lowListingPrice));
        System.out.println("\n");
        System.out.println("mid monthly payment " + NumberFormat.getCurrencyInstance().format(monthlyMidRange));
        System.out.println("mid listing price " + NumberFormat.getCurrencyInstance().format(midListingPrice));
        System.out.println("\n");
        System.out.println("high monthly payment " + NumberFormat.getCurrencyInstance().format(monthlyHighRange));
        System.out.println("high listing price " + NumberFormat.getCurrencyInstance().format(highListingPrice));



    }

}
