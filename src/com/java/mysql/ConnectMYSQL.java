package com.java.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectMYSQL {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/SHOPPING?connectionTimezone=JST";
		String user = "root";
		String password = "passw0rd!";
		try (Connection conn = DriverManager.getConnection(url,user,password);){
			
			Statement st = conn.createStatement(); //データベースを送信する役割
			ResultSet res = st.executeQuery("SELECT AVG(PRICE) AS 'AVG' FROM PRODUCT WHERE CATEGORY_ID =6;"); //データベースから結果を取得する役割
			
			while(res.next()) {
				int avg = res.getInt("AVG");
				System.out.println(String.format("AVG:%d", avg));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
