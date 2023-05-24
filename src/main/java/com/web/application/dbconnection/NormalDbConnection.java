package com.web.application.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class NormalDbConnection {

	// download mssql driver
	public static void main(String[] args) {
		Connection connection = null;
		// String conUrl = "jdbc:sqlserver://localhost:8080; databaseName=NewJoinee2022;
		// user=New_joinee_2022; password=P@ssw0rd;";
		String conUrl = "jdbc:sqlserver://192.168.168.12:1433;database=New_joinee_2022;encrypt=true;trustServerCertificate=true;";
		String user = "NewJoinee2022";
		String password = "P@ssw0rd";

		try {
			connection = DriverManager.getConnection(conUrl, user, password);
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select * from product");
			while (result.next()) {
				System.out.println("product id : " + result.getString(1));
				System.out.println("price : " + result.getString(2));
				System.out.println("product name : " + result.getString(3));
				System.out.println("Quantity : " + result.getString(4));
				System.out.println();
			}
			System.out.println("connection success....!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("connection failed....!" + e);
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (Exception e) {
				}
		}

	}

}
