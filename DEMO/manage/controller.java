package DEMO.manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import DEMO.Data.exces;

public class controller {
    private static final String url = "jdbc:postgresql://localhost/OwnSpring";
    private static final String id = "postgres";
    public static final String password = "1378";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println();
            System.out.println("Welcome DATA Management");
            System.out.println();
            while (true) {
                System.out.println("All DATA Detail Press = 1");
                System.out.println("Specific Data find Press = 2");
                System.out.println("For Exit Press aney key");
                System.out.println();
                System.out.print("Enter your option :-- ");
                int option = scanner.nextInt();
                System.out.println();

                switch (option) {
                    case 1:
                        All_data();
                        break;

                    default:
                        System.out.println("Thanks for using DATA Management");
                        return;
                }
            }
        }

    }

    public static void All_data() {
        try {
            Connection connection = DriverManager.getConnection(url, id, password);
            String quary = "Select * from user_data";
            PreparedStatement ps = connection.prepareStatement(quary);
            ResultSet resultSet = ps.executeQuery();
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
