package DEMO.Data;

import java.sql.Connection;
import java.sql.DriverManager;

public class exces {
    private static final String url = "jdbc:postgresql://localhost/OwnSpring";
    private static final String id = "postgres";
    private static final String password = "1378";
     
    public static void main(String url, String id, String password) {
        try {
            Connection connection = DriverManager.getConnection(url, id, password);
            System.out.println(connection);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
}