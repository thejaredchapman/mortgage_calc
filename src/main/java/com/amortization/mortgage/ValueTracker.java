package com.amortization.mortgage;

import java.util.Calendar;

final class ValueTracker{
	
 		Integer id;
		public String myUser;
		public String email;
		public double interestAtCurrentMonth;
		public double principalAtCurrentMonth;
		public double totalInterest;
		public double totalPrincipal;
		public String paymentPeroid;

		public ValueTracker(Integer id, String myUser, String email, Calendar paymentPeroid, double interestAtCurrentMonth, double principalAtCurrentMonth, 
				double totalInterest, double totalPrincipal) {

			this.id = id;
			this.myUser = myUser;
			this.email = email;
			this.interestAtCurrentMonth = interestAtCurrentMonth;
			this.principalAtCurrentMonth = principalAtCurrentMonth;
			this.totalInterest = totalInterest;
			this.totalPrincipal = totalPrincipal;
		}
		public int getId(){
			return id;
		}

		public String getMyUser(){
			return myUser;
		}

		public String getEmail(){
			return email;
		}

		public String getPaymentPeroid(){
			return paymentPeroid;
		}
		public double getInterestAtCurrentMonth(){
			return interestAtCurrentMonth;
		}

		public double getPrincipaltAtCurrentMonth(){
			return principalAtCurrentMonth;
		}

		public double getTotalInterest(){
			return totalInterest;
		}

		public double getTotalPrincipal(){
			return totalPrincipal;
		}

		public String toString(){
			return String.format("This will return the interest at current month %f this is the %f, this is the %f, and this is the %f\n", interestAtCurrentMonth, principalAtCurrentMonth, totalInterest, totalPrincipal);	
		}

	}


