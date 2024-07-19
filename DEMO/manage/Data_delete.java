package DEMO.manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Data_delete {
    private static final String url = "jdbc:postgresql://localhost/OwnSpring";
    private static final String id = "postgres";
    private static final String password = "1378";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter whose ID to Delete :-- ");
            int ids = scanner.nextInt();
            try {
                Connection connection = DriverManager.getConnection(url, id, password);
                System.out.println(connection);
                String query = "delete from user_data where personid = (?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, ids);
                
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
