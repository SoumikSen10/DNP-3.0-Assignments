// Creating database table, inserting data, updating ,deleting data , batch operation and calling stored procedures and passing parameters in stored procedures  and receiving data from out mode parameters of procedures .

import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main4 {
    private Connection con;
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Main4 project5 = new Main4();
        project5.createConnection();
        project5.createTable();
        project5.insertData();
        project5.displayData();
        project5.updateData();
        project5.displayData();
        project5.deleteData();
        project5.displayData();
        project5.batchInsertion();
        project5.displayData();
        project5.callableExample();
        project5.callableParaExample();
        project5.callableParaInOutExample();
        project5.closeConnection();
    }

    public void callableExample()
    {
        System.out.println("Calling stored procedures.");
        try {
            CallableStatement st = con.prepareCall("{call Simple()}");
            Boolean hasResult = st.execute();
            if(hasResult)
            {
                ResultSet res = st.getResultSet();
                while(res.next())
                {
                    System.out.println(res.getString("name"));
                }
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(Main4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void callableParaExample()
    {
        System.out.println("Calling stored procedures with parameter.");

        System.out.print("Enter the age criteria above which people's name having age will be displayed: ");

        int age = in.nextInt();

        try {
            CallableStatement st = con.prepareCall("{call SimplePara(?)}");

            st.setInt(1,age);

            Boolean hasResult = st.execute();
            if(hasResult)
            {
                ResultSet res = st.getResultSet();
                while(res.next())
                {
                    System.out.println(res.getString("name"));
                }
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(Main4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void callableParaInOutExample()
    {
        System.out.println("Calling stored procedures with parameter and receiving output .");

        System.out.print("Enter the age criteria above which people's name having age will be displayed: ");

        int age = in.nextInt();

        try {
            CallableStatement st = con.prepareCall("{call SimpleParaInOut(?,?)}");

            st.setInt(1,age);
            st.registerOutParameter(2, Types.INTEGER);

            Boolean hasResult = st.execute();
            if(hasResult)
            {
                int countReturned = st.getInt(2);
                System.out.println("No. of members got = " + countReturned);
                ResultSet res = st.getResultSet();
                while(res.next())
                {
                    System.out.println(res.getString("name"));
                }
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(Main4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createConnection() {
        try {
            // Step 1: Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the Connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dnpdb1", "root", "SoumikSen2003.");
            System.out.println("Database connection successful.");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Main4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void closeConnection() {
        try {
            if (con != null) con.close();
            System.out.println("Database connection closed.");
        } catch (SQLException ex) {
            Logger.getLogger(Main4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void batchInsertion() {
        Statement st = null;
        try {
            st = con.createStatement();
            st.addBatch("INSERT INTO users4 (name, age, salary) VALUES ('Max', 18, 30000)");
            st.addBatch("INSERT INTO users4 (name, age, salary) VALUES ('Sam', 20, 40000)");
            st.addBatch("INSERT INTO users4 (name, age, salary) VALUES ('Tony', 22, 50000)");
            st.addBatch("INSERT INTO users4 (name, age, salary) VALUES ('Chase', 23, 45000)");
            st.addBatch("INSERT INTO users4 (name, age, salary) VALUES ('Jeredy', 40, 60000)");
            int[] ar = st.executeBatch();
            System.out.println("Batch insertion completed.");
            for (int i : ar) {
                System.out.println(i);
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(Main4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createTable() {
        try {
            String query = "CREATE TABLE IF NOT EXISTS users4 (name VARCHAR(100), age INT, salary FLOAT);";
            Statement st = con.createStatement();
            st.execute(query);
            System.out.println("Table created successfully.");
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(Main4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertData() {
        PreparedStatement st = null;
        try {
            st = con.prepareStatement("INSERT INTO users4 (name, age, salary) VALUES (?, ?, ?)");
            System.out.println("Inserting data into users4 table");
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
            in.nextLine(); // Clear the buffer
        } catch (SQLException ex) {
            Logger.getLogger(Main4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateData() {
        PreparedStatement st = null;
        try {
            st = con.prepareStatement("UPDATE users4 SET age = ? WHERE name = ?");
            System.out.print("Enter the name whose age is to be updated: ");
            String name = in.nextLine();
            System.out.print("Enter new age of user: ");
            int age = in.nextInt();
            st.setInt(1, age);
            st.setString(2, name);
            st.executeUpdate();
            System.out.println("Updation completed.");
            st.close();
            in.nextLine(); // Clear the buffer
        } catch (SQLException ex) {
            Logger.getLogger(Main4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteData() {
        PreparedStatement st = null;
        try {
            st = con.prepareStatement("DELETE FROM users4 WHERE name = ?");
            System.out.print("Enter the name whose data is to be deleted: ");
            String name = in.nextLine();
            st.setString(1, name);
            st.executeUpdate();
            System.out.println("Deletion completed.");
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(Main4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void displayData() {
        Statement st = null;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM users4;");
            System.out.println("Displaying all users:");
            while (rs.next()) {
                String userName = rs.getString("name");
                int userAge = rs.getInt("age");
                float userSalary = rs.getFloat("salary");
                System.out.println(userName + "         " + userAge + "         " + userSalary);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(Main4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
