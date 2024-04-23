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
			ResultSet res = st.executeQuery("SELECT * FROM PRODUCT"); //データベースから結果を取得する役割
			
			while(res.next()) {
				int id = res.getInt("ID");
				String name = res.getString("NAME");
				int price = res.getInt("PRICE");
				int categoryId = res.getInt("CATEGORY_ID");
				System.out.println(String.format("ID:%d NAME:%s PRICE:%d CATEGORY_ID:%d", id,name,price,categoryId));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
