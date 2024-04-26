import java.sql.Connection;
import java.security.spec.ECField;
import java.sql.DriverManager;

public class MortgageDB {
    public Connection connect_to_db(){
        Connection = conn=null;
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:")
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}

/*import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public class MortgageDB {

    public static int add(ValueTracker valueTracker) {
        var sql = "INSERT INTO mortgage(date, interestAtCurrentMonth, principalAtCurrentMonth, totalInterest, totalPrincipal) "
        + "VALUES(?,? )" ;

        try (var conn =  DB.connect();
            var pstmt = conn.prepareStatement(sql)) {
        for (var ValueTracker : valueTracker) {
            pstmt.setString(1, valueTracker.getDate());
            pstmt.setDouble(2, valueTracker.getInterestAtCurrentMonth());
            pstmt.setDouble(3, valueTracker.getPrincipaltAtCurrentMonth());
            pstmt.setDouble(4, valueTracker.getTotalInterest());
            pstmt.setDouble(5, valueTracker.getTotalPrincipal());
            pstmt.addBatch();
        }
        pstmt.executeBatch();

   } catch (SQLException e) {
       e.printStackTrace();
   }
   

}}




//  CREATE TABLE amortization (
//          id INT NOT NULL AUTO_INCREMENT, 
//          MYUSER VARCHAR(30) NOT NULL,
//          EMAIL VARCHAR(30),
//          DATE VARCHAR(30),   
//          MONTHLYINTEREST VARCHAR(30),
//          MONTHLYPRINCIPAL VARCHAR(30),
//          TOTALINTEREST VARCHAR(30),
//          TOTALPRINCIPAL VARCHAR(30),
//          PRIMARY KEY (ID)
//  )
*/