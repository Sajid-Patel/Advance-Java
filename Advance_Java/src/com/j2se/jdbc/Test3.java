package com.j2se.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Try with resources
class Test3 {

	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
				"patel"); Statement statement = connection.createStatement();) {
			String q1 = "select * from employee";
			ResultSet set = statement.executeQuery(q1);
			while (set.next()) {
				System.out.println(set.getInt(1) + " " + set.getString("ename") + " " + set.getDouble(3));
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
