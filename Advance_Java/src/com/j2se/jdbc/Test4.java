package com.j2se.jdbc;
//take data from End-user and store in database
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


class Test4 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver loading processs completed....");

		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "patel");
		System.out.println("Connection created successfully..." + connection);

		Statement statement = connection.createStatement();

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Enter employee ID");
			int eid = scanner.nextInt();

			System.out.println("Enter employee Name");
			String ename = scanner.next();

			System.out.println("Enter employee Salary");
			double esal = scanner.nextDouble();

			String q1 = "insert into employee values(" + eid + ",'"+ ename +"'," + esal + ")";
			System.out.println(q1);
			statement.executeUpdate(q1);
			System.out.println("Values are inserted successfully.... Do you want one more record(Yes/No)");
			String option = scanner.next();
			if (option.equals("No"))
				break;
		}

		scanner.close();
		statement.close();
		System.out.println("Connection closed successfully....");

	}

}
