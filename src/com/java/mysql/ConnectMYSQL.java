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
		try (Connection conn = DriverManager.getConnection(url, user, password)) {

			conn.setAutoCommit(false);

			String sql = "UPDATE PRODUCT SET CATEGORY_ID = 2 WHERE CATEGORY_ID = 1";
			Statement st = conn.createStatement(); // データベースを送信する役割
			int count = st.executeUpdate(sql);
			System.out.println("結果:" + count);

			conn.commit();

			sql = "DELETE FROM PRODUCT WHERE CATEGORY_ID = 2";
			st = conn.createStatement();
			count = st.executeUpdate(sql);
			System.out.println("結果:" + count);

			conn.rollback();

			ResultSet res = st.executeQuery("SELECT * FROM PRODUCT");

			while (res.next()) {
				int id = res.getInt("ID");
				String name = res.getString("NAME");
				int price = res.getInt("PRICE");
				int categoryId = res.getInt("CATEGORY_ID");
				System.out.println(String.format("ID:%d NAME:%s PRICE:%d CATEGORY_ID:%d,id,name,price,categoryId"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
//トランザクション制御