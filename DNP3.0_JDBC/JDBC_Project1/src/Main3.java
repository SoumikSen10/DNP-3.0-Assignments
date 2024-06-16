// Creating database table

import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main3 {
    private Connection con;

    public static void main(String[] args) {
        Main3 project4 = new Main3();
        project4.createConnection();
        project4.createTable();
        project4.insertData();
        project4.displayData();
    }

    public void createConnection() {
        try {
            // Step 1: Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the Connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dnpdb1", "root", "SoumikSen2003.");
            System.out.println("Database connection successful.");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Main3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createTable() {
        try {
            String query = "CREATE TABLE IF NOT EXISTS users3 (name VARCHAR(100), age INT, salary FLOAT);";
            Statement st = con.createStatement();
            st.execute(query);
            System.out.println("Table created successfully.");
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(Main3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertData() {
        Scanner in = new Scanner(System.in);
        PreparedStatement st = null;

        try {
            // Step 3: Create statement for insertion
            st = con.prepareStatement("INSERT INTO users3 (name, age, salary) VALUES (?, ?, ?)");

            // Step 4: Execute insertion query
            System.out.println("Inserting data into users3 table");
            System.out.print("Enter the name to be inserted: ");
            String name = in.nextLine();
            System.out.print("Enter age of user: ");
            int age = in.nextInt();
            System.out.print("Enter salary of user: ");
            float salary = in.nextFloat();

            st.setString(1, name);
            st.setInt(2, age);
            st.setFloat(3, salary);

            st.executeUpdate();
            System.out.println("Insertion completed.");
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(Main3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void displayData() {
        Statement st = null;
        ResultSet rs = null;

        try {
            // Step 5: Create statement for selection
            st = con.createStatement();

            // Step 6: Execute selection query
            rs = st.executeQuery("SELECT * FROM users3;");
            System.out.println("Displaying all users:");
            while (rs.next()) {
                String userName = rs.getString("name");
                int userAge = rs.getInt("age");
                float userSalary = rs.getFloat("salary");
                System.out.println(userName + "         " + userAge + "         " + userSalary);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main3.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Step 7: Close resources
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Main3.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}


