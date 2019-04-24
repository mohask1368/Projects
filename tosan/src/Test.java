import java.sql.*;

public class Test {

    public static void main(String[] args) {


        try {
            Connection connection = DBConnector.getConnection();
            Statement statement = connection.createStatement();
            int resultSet = statement.executeUpdate("update member set name='11111' where name ='ss'");
            System.out.println(resultSet);
            System.out.println("inserted");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("not inserted");
        }


    }
}
