package EmployeeManagement;

import java.sql.*;

public class CreateTable {

    public static void main(String[] args) throws Exception {

        Connection c = DBConnection.getConnection();

        String table = """
                CREATE TABLE IF NOT EXISTS Employee(
                    employee_id INT PRIMARY KEY,
                    name VARCHAR(100),
                    department VARCHAR(100),
                    salary DOUBLE,
                    designation VARCHAR(100),
                    contact VARCHAR(20),
                    email VARCHAR(100),
                    address VARCHAR(200)
                )
                """;

        Statement s = c.createStatement();
        s.executeUpdate(table);

        System.out.println(
                "Employee Table Created Successfully"
        );

        c.close();
    }
}
