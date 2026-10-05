package EmployeeManagement;

import java.sql.*;

public class CreateDataBase {

    public static void main(String[] args) throws Exception {

        Connection c = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/",
                "root",
                "YOUR_PASSWORD"
        );

        String database =
                "CREATE DATABASE IF NOT EXISTS EmployeeDB";

        Statement s = c.createStatement();
        s.executeUpdate(database);

        System.out.println("Database Created Successfully");

        c.close();
    }
}
