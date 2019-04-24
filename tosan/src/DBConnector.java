import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {

   private static final String driver = "org.postgresql.Driver";
   private static final String url = "jdbc:postgresql://localhost:5432/postgres";
   private static final String user = "postgres";
   private static final String password = "12345";

   public static Connection connection;


   public static Connection getConnection(){


       if (connection != null) return connection ;
       else {

           try {
//               Class.forName(driver);
               connection = DriverManager.getConnection(url, user, password);
               System.out.println("connection created");
           } catch (Exception e) {
               e.printStackTrace();
               System.out.println("connection failed");
           }
       }

return connection;
   }

}
