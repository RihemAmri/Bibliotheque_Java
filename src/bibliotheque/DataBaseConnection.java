package bibliotheque;

import java.sql.*;

public class DataBaseConnection {
//    final private String url = "jdbc:mysql://localhost:3306/biblio";
//    final private String user = "root";
//    final private String password = "112713";
    private Connection connection;
    
    public Connection getConnection()  {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/biblio","root","112713");
            System.out.println("Database connected successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
        return connection;
    }
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            System.out.println("Error while closing the connection: " + e.getMessage());
        }
    }
}
