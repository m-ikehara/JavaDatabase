package com.java.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Lesson2 {

	public static void main(String[] args) {
		
		
		
		String url = "jdbc:mysql://localhost:3306/SCHOOL?connectionTimezone=JST";
		String user = "root";
		String password = "passw0rd!";
		try(Connection conn = DriverManager.getConnection(url,user,password)) {
			
			String sql = null;
			Statement st = conn.createStatement();
			ResultSet res;
			int count;
			
			//問題１
		    //sql = "DROP TABLE STUDENT";  		
		    //count = st.executeUpdate(sql);
		    //System.out.println( "(１)の結果"+count);
		    
			//問題２
//	        sql = 
//				"CREATE TABLE `STUDENT` (" +
//			    "`ID` INT NOT NULL AUTO_INCREMENT,"+
//			    "`NAME` VARCHAR(20) NOT NULL,"+
//			    "`AGE` INT NOT NULL,"+
//			    "`CLASS` INT NOT NULL DEFAULT 0,"+
//			    "`CLUB_ID` INT,"+
//			    "PRIMARY KEY (`ID`)"+
//			    ")";
//		    count = st.executeUpdate(sql);
//		    System.out.println( "(２)の結果"+count);
		    
			//問題３
//		    sql = 
//		    	" INSERT INTO STUDENT (" +
//		        "NAME,AGE,CLASS,CLUB_ID" +
//		        ")" +
//		        " VALUES(" +
//		        "'Jon',17,2,1" +
//		        " ),(" +
//		        "'Cathy',17,2,7" +
//		        " ),(" +
//		        "'Mike',16,2,2" +
//		        " ),(" +
//		        "'Emily',18,3,6" +
//		        " ),(" +
//		        "'Ema',17,1,5"+
//		        "),("+
//		        " 'Alex',17,1,2" +
//		        " ),(" +
//		        " 'Ben',18,3,2" +
//		        " ),(" +
//		        "'Christina',16,1,6" +
//		        " ),(" +
//		        "'Dahiel',18,1,1"+
//		        "),("+
//		        "'Jasmine',15,2,5"+
//		        "),("+
//		        " 'Ivan',16,1,3"+
//		        "),("+
//		        "'James',17,2,3"+
//		        "),("+
//		        "'Sara',16,1,7"+
//		        "),("+
//		        "'Mary',17,3,7"+
//		        "),("+
//		        "'Siri',19,3,NULL"+
//		        ")";
//			
//		    count = st.executeUpdate(sql);
//		    System.out.println( "(３)の結果"+count);
		    
			//問題４
//			conn.setAutoCommit(false);
		    
			//問題５
//		    sql =
//				"UPDATE STUDENT SET CLUB_ID = 8 WHERE CLUB_ID IS NULL";
//		    count = st.executeUpdate(sql);
//		    System.out.println( "(５)の結果"+count);
		    
			//問題６
		    //conn.commit();
		    
			//問題７
//		    sql =
//		        "UPDATE STUDENT SET CLUB_ID = 2 WHERE CLUB_ID IS 7";
//		    count = st.executeUpdate(sql);
//		    System.out.println( "(７)の結果"+count);
		    
			//問題８
//		    sql =
//		    	"DELETE FROM STUDENT WHERE CLUB_ID = 2";
//		    count = st.executeUpdate(sql);
//		    System.out.println( "(８)の結果"+count);
		    
			//問題９
			//conn.rollback();
		    
			//問題１０
		    sql =
				"SELECT A.NAME,A.AGE,A.CLASS,B.NAME" +
                "FROM STUDENT A ORDER BY CLASS"+
                "LEFT OUTER JOIN CLUB B ON A.CLUB_ID = B.ID";
				
		    res = st.executeQuery("SELECT * FROM STUDENT");
		    
		    while(res.next()) {
			  String name = res.getString("NAME");
			  int age = res.getInt("AGE");
			  int kumi = res.getInt("CLASS");
			  String clubName = res.getString("NAME");
			  System.out.println(String.format("NAME:%s AGE:%d CLASS:%d NAME:%s",name,age,kumi,clubName));
		    }
		} catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
