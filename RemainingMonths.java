public class RemainingMonths {
  
        private int monthsLeft;
        private static int TOTAL_AMOUNT_OF_PAYMENTS = 360;
    
        /**
         * This method transfers the values called from CounterTester to instance variables
         * and increases/decreases by the values passed to it. It also returns the value
         * of count. 
         *
         * @param args
         */ 
        public RemainingMonths ()
        {       
           monthsLeft = TOTAL_AMOUNT_OF_PAYMENTS - 1;
        }   
           
        public void decrease ()
        {
            monthsLeft = monthsLeft - 1;
        }
    
        public int getRemainingMonths()
        {
            return monthsLeft ;
        }    

}
