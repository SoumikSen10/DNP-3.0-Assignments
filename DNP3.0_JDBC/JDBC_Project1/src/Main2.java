// Learning Prepared Statement

import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main2 {
    public static void main(String[] args) {
        Main2 project3 = new Main2();
        project3.createConnection();
    }

    public void createConnection() {
        Scanner in = new Scanner(System.in);
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            // Step 1: Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the Connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dnpdb1", "root", "SoumikSen2003.");

            System.out.println("Database connection successful.");

            // Step 3: Create statement
            st = con.prepareStatement("INSERT INTO users2 VALUES (?,?)");

            // Step 4: Execute Query
            System.out.println("Inserting data into users table");
            System.out.print("Enter the name to be inserted: ");
            String data = in.nextLine();
            System.out.print("Enter age of user: ");
            int age = in.nextInt();
            st.setString(1,data);
            st.setInt(2,age);

            st.execute();
            System.out.println("Insertion completed");

            System.out.println("Displaying all users");
            rs = st.executeQuery("SELECT * FROM users2;");

            while(rs.next())
            {
                String userName = rs.getString("name"); //parameter is name of column to be displayed of a particular row
                String userAge = rs.getString("age"); //parameter is age of column to be displayed of a particular row
                System.out.println(userName+"         "+userAge);
            }
            st.close();
            }
            catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Main2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

