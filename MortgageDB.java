import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import MortgageCalculator.ValueTracker;

public class MortgageDB {

    public static int add(MortgageCalculator valueT) {
        var sql = "INSERT INTO mortgage(date, interestAtCurrentMonth, principalAtCurrentMonth, totalInterest, totalPrincipal) "
        + "VALUES(?,? )" ;

        try (var conn =  DB.connect();
            var pstmt = conn.prepareStatement(sql)) {
        for (var valueT : valueT) {
            pstmt.setString(1, product.getName());
            pstmt.setDouble(2, product.getPrice());
            pstmt.addBatch();
        }
        pstmt.executeBatch();

   } catch (SQLException e) {
       e.printStackTrace();
   }
}

}
    
