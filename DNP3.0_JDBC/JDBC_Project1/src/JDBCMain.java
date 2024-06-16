// Added the transaction processing part

import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCMain {
    private Connection con;
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        JDBCMain project = new JDBCMain();
        project.createConnection();

        boolean running = true;
        while (running) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Create Table");
            System.out.println("2. Insert Data");
            System.out.println("3. Update Data");
            System.out.println("4. Delete Data");
            System.out.println("5. Display Data");
            System.out.println("6. Batch Insertion");
            System.out.println("7. Call Stored Procedure (Simple)");
            System.out.println("8. Call Stored Procedure with Parameter");
            System.out.println("9. Call Stored Procedure with In/Out Parameter");
            System.out.println("10. Transaction Demo");
            System.out.println("11. Exit");

            System.out.print("Enter your choice: ");
            int choice = project.in.nextInt();
            project.in.nextLine(); // Clear the buffer

            switch (choice) {
                case 1:
                    project.createTable();
                    break;
                case 2:
                    project.insertData();
                    break;
                case 3:
                    project.updateData();
                    break;
                case 4:
                    project.deleteData();
                    break;
                case 5:
                    project.displayData();
                    break;
                case 6:
                    project.batchInsertion();
                    break;
                case 7:
                    project.callableExample();
                    break;
                case 8:
                    project.callableParaExample();
                    break;
                case 9:
                    project.callableParaInOutExample();
                    break;
                case 10:
                    project.transactionDemo();
                    break;
                case 11:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }

        project.closeConnection();
    }

    public void createConnection() {
        try {
            // Step 1: Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the Connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dnpdb1", "root", "SoumikSen2003.");
            System.out.println("Database connection successful.");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(JDBCMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void closeConnection() {
        try {
            if (con != null) con.close();
            System.out.println("Database connection closed.");
        } catch (SQLException ex) {
            Logger.getLogger(JDBCMain.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(JDBCMain.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(JDBCMain.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(JDBCMain.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(JDBCMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void displayData() {
        Statement st = null;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM users4;");
            System.out.println("Displaying all users:");
            System.out.println("------------------------------------------------");
            System.out.printf("%-20s %-10s %-10s%n", "Name", "Age", "Salary");
            System.out.println("------------------------------------------------");
            while (rs.next()) {
                String userName = rs.getString("name");
                int userAge = rs.getInt("age");
                float userSalary = rs.getFloat("salary");
                System.out.printf("%-20s %-10d %-10.2f%n", userName, userAge, userSalary);
            }
            System.out.println("------------------------------------------------");
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCMain.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(JDBCMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void callableExample() {
        System.out.println("Calling stored procedures.");
        try {
            CallableStatement st = con.prepareCall("{call Simple()}");
            boolean hasResult = st.execute();
            if (hasResult) {
                ResultSet res = st.getResultSet();
                while (res.next()) {
                    System.out.println(res.getString("name"));
                }
                res.close();
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void callableParaExample() {
        System.out.println("Calling stored procedures with parameter.");
        System.out.print("Enter the age criteria above which people's name having age will be displayed: ");
        int age = in.nextInt();
        try {
            CallableStatement st = con.prepareCall("{call SimplePara(?)}");
            st.setInt(1, age);
            boolean hasResult = st.execute();
            if (hasResult) {
                ResultSet res = st.getResultSet();
                while (res.next()) {
                    System.out.println(res.getString("name"));
                }
                res.close();
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void callableParaInOutExample() {
        System.out.println("Calling stored procedures with parameter and receiving output.");
        System.out.print("Enter the age criteria above which people's name having age will be displayed: ");
        int age = in.nextInt();
        try {
            CallableStatement st = con.prepareCall("{call SimpleParaInOut(?, ?)}");
            st.setInt(1, age);
            st.registerOutParameter(2, Types.INTEGER);
            boolean hasResult = st.execute();
            if (hasResult) {
                int countReturned = st.getInt(2);
                System.out.println("No. of members got = " + countReturned);
                ResultSet res = st.getResultSet();
                while (res.next()) {
                    System.out.println(res.getString("name"));
                }
                res.close();
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void transactionDemo() {
        System.out.println("Transaction Demo");
        PreparedStatement st1 = null;
        PreparedStatement st2 = null;
        try {
            // Start transaction
            con.setAutoCommit(false);

            System.out.println("Enter details for the first record.");
            st1 = con.prepareStatement("INSERT INTO users4 (name, age, salary) VALUES (?, ?, ?)");
            System.out.print("Enter name: ");
            String name1 = in.nextLine();
            System.out.print("Enter age: ");
            int age1 = in.nextInt();
            System.out.print("Enter salary: ");
            float salary1 = in.nextFloat();
            in.nextLine(); // Clear the buffer

            System.out.println("Enter details for the second record.");
            st2 = con.prepareStatement("INSERT INTO users4 (name, age, salary) VALUES (?, ?, ?)");
            System.out.print("Enter name: ");
            String name2 = in.nextLine();
            System.out.print("Enter age: ");
            int age2 = in.nextInt();
            System.out.print("Enter salary: ");
            float salary2 = in.nextFloat();
            in.nextLine(); // Clear the buffer

            // Insert first record
            st1.setString(1, name1);
            st1.setInt(2, age1);
            st1.setFloat(3, salary1);
            st1.executeUpdate();

            // Insert second record
            st2.setString(1, name2);
            st2.setInt(2, age2);
            st2.setFloat(3, salary2);
            st2.executeUpdate();

            // Commit transaction
            con.commit();
            System.out.println("Transaction committed successfully.");

        } catch (SQLException ex) {
            try {
                // Rollback transaction in case of error
                if (con != null) {
                    con.rollback();
                    System.out.println("Transaction rolled back due to an error.");
                }
            } catch (SQLException e) {
                Logger.getLogger(JDBCMain.class.getName()).log(Level.SEVERE, null, e);
            }
            Logger.getLogger(JDBCMain.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (st1 != null) st1.close();
                if (st2 != null) st2.close();
                // Restore auto-commit mode
                con.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(JDBCMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
