package DEMO.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class All_data_Show {
    
    private static final String url = "jdbc:postgresql://localhost/OwnSpring";
    private static final String id = "postgres";
    private static final String password = "1378";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, id, password);
            String query = "Select * from user_data";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            int count = 0;
            while (resultSet.next()) {
                count += 1;
                System.out.println();
                System.out.println("Person ID :- " + resultSet.getString("personid"));
                System.out.println("First-Name " + resultSet.getString("firstname"));
                System.out.println("Last-Name " + resultSet.getString("lastname"));
                System.out.println("Address " + resultSet.getString("address"));
                System.out.println("City " + resultSet.getString("city"));
                System.out.println();
            }
            System.out.println("Total data inserted in this data base is " + count);
            System.out.println();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
