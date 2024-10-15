package com.j2se.jdbc;
//Try-catch-finally
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class Test2 {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		try {
			// Step 1 : Load the Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loading processs completed....");

			// Step 2 : Create the Connection
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "patel");
			System.out.println("Connection created successfully..." + connection);

			// Step 3 : Write the Query
			String q1 = "insert into employee values(111,'Sajid',70000)";
			String q2 = "insert into employee values(112,'Mobin',90000)";
			String q3 = "insert into employee values(113,'Baban',50000)";

			// Step 4 : Process the Query
			statement = connection.createStatement();
			statement.executeUpdate(q1);
			statement.executeUpdate(q2);
			statement.executeUpdate(q3);
			System.out.println("Data Inserted successfully...");
		}

		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		// Step 5 : Close the Resource
		finally {
			try {
				connection.close();
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		System.out.println("Connection closed successfully");

	}

}
