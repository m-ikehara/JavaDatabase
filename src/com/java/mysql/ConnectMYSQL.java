package com.java.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectMYSQL {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/SHOPPING?connectionTimezone=JST";
		String user = "root";
		String password = "passw0rd!";
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			
			String sql =
					"DELETE FROM PRODUCT WHERE PRICE=0";
			Statement st = conn.createStatement(); // データベースを送信する役割
			int count = st.executeUpdate(sql);
			System.out.println("結果:" + count);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
