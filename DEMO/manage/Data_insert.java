package DEMO.manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Data_insert {

    private static final String url = "jdbc:postgresql://localhost/OwnSpring";
    private static final String id = "postgres";
    private static final String password = "1378";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
                Connection connection = DriverManager.getConnection(url, id, password)) {

            int ids = (int) Math.floor(Math.random() * 10000000);
            System.out.print("Enter Your first name: ");
            String name = scanner.next();
            System.out.print("Enter Your last name: ");
            String last_name = scanner.next();
            System.out.print("Enter full address: ");
            String address = scanner.next();
            System.out.print("Enter city: ");
            String city = scanner.next();

            String query = "insert into user_data(personid, firstname, lastname, address, city) values(?,?,?,?,?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, ids);
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, last_name);
                preparedStatement.setString(4, address);
                preparedStatement.setString(5, city);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Data inserted successfully");
                    System.out.println("Your id is " + ids);
                } else {
                    System.out.println("Failed to insert data");
                }
            } catch (SQLException e) {
                System.out.println("Error inserting data:");
                System.out.println(e.getMessage());
                
            }
        } catch (SQLException e) {
            System.out.println("Error establishing database connection:");
            System.out.println(e.getMessage());
        }
    }
}
