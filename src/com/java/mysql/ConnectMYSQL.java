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
					"INSERT INTO PRODUCT (" +
					" NAME,PRICE,CATEGORY_ID" +
					")" +
					" VALUES(" +
					"  '味のもとのもと',500,3" +
					"),(" +
					"'そっくりクレヨン',300,4" +
					"),(" +
					"'超サイクロン掃除機',30000,6" +
					"),(" +
					"'Java入門編',1500,1" +
					"),(" +
					"'アンキパン',200,NULL" +
					"),(" +
					"'生キャラメルプリン',500,3" +
					"),(" +
					"'手を動かして学ぶJava',2500,1" +
					"),(" +
					"'できるJavaプログラミング入門',2000,1" +
					"),(" +
					"'日曜産業セット',5000,5" +
					"),(" +
					"'ここほれワイヤー',2500,6" +
					"),(" +
					"'タイムカメラ',12000,6" +
					"),(" +
					"'JavaScriptを学ぼう',1800,1" +
					"),(" +
					"'サンプル',0,NULL" +
					")";
			Statement st = conn.createStatement(); // データベースを送信する役割
			int count = st.executeUpdate(sql);
			System.out.println("結果:" + count);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
