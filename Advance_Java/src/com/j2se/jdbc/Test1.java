package com.j2se.jdbc;

//Throws keyword
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class Test1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Step 1 : Load the Driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver loading processs completed....");

		// Step 2 : Create the Connection
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "patel");
		System.out.println("Connection created successfully..." + connection);

		// Step 3 : Write the Query
		String q1 = "create table employee (eid number,ename varchar2(30),esal number)";

		// Step 4 : Process the Query
		Statement statement = connection.createStatement();
		int x = statement.executeUpdate(q1);
		System.out.println("Table created successfully..." + x);

		// Step 5 : Close the Resource
		statement.close();
		connection.close();
		System.out.println("Connection closed successfully");

	}

}
