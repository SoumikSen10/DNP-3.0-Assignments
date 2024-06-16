// Creating JDBC and inserting data into DB

import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main1 {
    public static void main(String[] args) {
        Main1 project2 = new Main1();
        project2.createConnection();
    }

    public void createConnection() {
        Scanner in = new Scanner(System.in);
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            // Step 1: Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the Connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dnpdb1", "root", "SoumikSen2003.");

            System.out.println("Database connection successful.");

            // Step 3: Create statement
            st = con.createStatement();

            // Step 4: Execute Query
            System.out.println("Inserting data into users table");
            System.out.print("Enter the name to be inserted: ");
            String data = in.nextLine();

            // Check if the name already exists
            rs = st.executeQuery("SELECT COUNT(*) FROM users WHERE name = '" + data + "'");
            rs.next();
            int count = rs.getInt(1);

            if (count > 0) {
                System.out.println("The name '" + data + "' already exists in the table.");
            } else {
                int rowsInserted = st.executeUpdate("INSERT INTO users VALUES ('" + data + "');");
                if (rowsInserted > 0) {
                    System.out.println("Insertion successful!");

                    System.out.println("Updated table content after data insertion:");
                    rs = st.executeQuery("SELECT * FROM users");
                    while (rs.next()) {
                        String name = rs.getString("name"); // parameter is name of column to be displayed of a particular row
                        System.out.println(name);
                    }
                } else {
                    System.out.println("Insertion unsuccessful!");
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Main1.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Step 5: Close resources
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Main1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
