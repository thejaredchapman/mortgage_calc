final class ValueTracker{
	
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
		
		public String getDate(){
			return date;
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


