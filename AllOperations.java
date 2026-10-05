package EmployeeManagement;

import java.sql.*;

public class AllOperations {

    public static final Connection c =
            DBConnection.getConnection();

    // CREATE - Add Employee
    public static void addEmployee() {

        String query = """
                INSERT INTO Employee
                (employee_id, name, department, salary,
                 designation, contact, email, address)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                """;

        try {
            PreparedStatement ps = c.prepareStatement(query);

            ps.setInt(1, 101);
            ps.setString(2, "Rahul");
            ps.setString(3, "IT");
            ps.setDouble(4, 55000);
            ps.setString(5, "Software Developer");
            ps.setString(6, "9876543210");
            ps.setString(7, "rahul@gmail.com");
            ps.setString(8, "Bangalore");
            ps.executeUpdate();

            ps.setInt(1, 102);
            ps.setString(2, "Priya");
            ps.setString(3, "HR");
            ps.setDouble(4, 45000);
            ps.setString(5, "HR Executive");
            ps.setString(6, "9876501234");
            ps.setString(7, "priya@gmail.com");
            ps.setString(8, "Mysore");
            ps.executeUpdate();

            System.out.println("Employee Records Added Successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ - Display Employees
    public static void viewEmployees() {

        String query = "SELECT * FROM Employee";

        try {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(query);

            while (rs.next()) {
                System.out.println("-----------------------------");
                System.out.println("Employee ID: " +
                        rs.getInt("employee_id"));
                System.out.println("Name: " +
                        rs.getString("name"));
                System.out.println("Department: " +
                        rs.getString("department"));
                System.out.println("Salary: " +
                        rs.getDouble("salary"));
                System.out.println("Designation: " +
                        rs.getString("designation"));
                System.out.println("Contact: " +
                        rs.getString("contact"));
                System.out.println("Email: " +
                        rs.getString("email"));
                System.out.println("Address: " +
                        rs.getString("address"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE - Update Employee
    public static void updateEmployee() {

        String query = """
                UPDATE Employee
                SET department = ?,
                    salary = ?,
                    designation = ?,
                    contact = ?,
                    email = ?,
                    address = ?
                WHERE employee_id = ?
                """;

        try {
            PreparedStatement ps = c.prepareStatement(query);

            ps.setString(1, "Development");
            ps.setDouble(2, 65000);
            ps.setString(3, "Senior Developer");
            ps.setString(4, "9876543210");
            ps.setString(5, "rahul.new@gmail.com");
            ps.setString(6, "Bangalore");
            ps.setInt(7, 101);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Employee Updated Successfully");
            else
                System.out.println("Employee ID Not Found");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE - Delete Employee
    public static void deleteEmployee() {

        String query =
                "DELETE FROM Employee WHERE employee_id = ?";

        try {
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, 102);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Employee Deleted Successfully");
            else
                System.out.println("Employee ID Not Found");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        addEmployee();

        System.out.println("\nEmployee Records:");
        viewEmployees();

        updateEmployee();

        System.out.println("\nAfter Update:");
        viewEmployees();

        deleteEmployee();

        System.out.println("\nAfter Delete:");
        viewEmployees();
    }
}
