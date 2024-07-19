package DEMO.manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
                String query = "select * from user_data where personid = (?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, ids);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    int person = resultSet.getInt("personid");
                    System.out.println("Person ID :- " + person);
                    System.out.println("First-Name " + resultSet.getString("firstname"));
                    System.out.println("Last-Name " + resultSet.getString("lastname"));
                    System.out.println("Address " + resultSet.getString("address"));
                    System.out.println("City " + resultSet.getString("city"));
                    System.out.println("Are your sure to delete this information : Yes : No");
                    System.out.print("Type here :-- ");
                    // Scanner scanner2 = new Scanner(System.in);
                    String check = scanner.next().toLowerCase();
                    
                    if (check.equals("yes")) {
                        try {
                            String query2 = "delete from user_data where personid = (?)";

                            PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
                            preparedStatement2.setInt(1, person);
                            preparedStatement2.executeUpdate();
                            System.out.println("Data deleted successfully !");

                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("this data not deleted to your conformation");
                    }

                } else {
                    System.out.println("This ID has been not exist on the server !");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
