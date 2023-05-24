package com.web.application.jdbctemplate;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



public class JdbcService {

	@Service
	public class FirstDemoServices {

		@Autowired
		DbConnection dbconnection;

		public Object db_operation(String procedure_name, Object request1) throws Exception {
			Connection connection = null;
			ResultSet rs = null;
			CallableStatement callableStatement = null;

			connection = dbconnection.getConnection();
			try {

				Object response = new Object();
				callableStatement = connection.prepareCall("{call " + procedure_name + "(?)}");
				callableStatement.setString(1, request1.toString());

				rs = callableStatement.executeQuery();
				System.out.println("Query executed successfully");

				while (rs.next()) {
					response = rs.getObject("responseJson");
					System.out.println("response received");
					return response;
				}

			} catch (Exception e) {

				throw e;
			} finally {
				try {
					dbconnection.closeConnection(connection, rs, callableStatement);
				} catch (Exception e) {
					System.out.println("database connection gets closed");
				}
			}

			return null;
		}

	}

}
