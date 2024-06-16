// Learning JDBC setup and fetching data from DB

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main
{
    public static void main(String[] args)
    {
        Main project1 = new Main();
        project1.createConnection();
    }

    public void createConnection()
    {
        try
        {
            // Step 1: Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the Connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dnpdb1","root","SoumikSen2003.");

            System.out.println("Database connection successful.");

            // Step 3: Create statement
            Statement st = con.createStatement();

            // Step 4: Execute Query
            System.out.println("Displaying all users");
            ResultSet rs = st.executeQuery("SELECT * FROM users");

            while(rs.next())
            {
                String name = rs.getString("name"); //parameter is name of column to be displayed of a particular row
                System.out.println(name);
            }

            System.out.println("Displaying users name starting with A");
            ResultSet rs1 = st.executeQuery("SELECT * FROM users WHERE name like 'A%';");
            st.close();
            while(rs1.next())
            {
                String name = rs1.getString("name"); //parameter is name of column to be displayed of a particular row
                System.out.println(name);
            }

        }
        catch(ClassNotFoundException | SQLException ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}