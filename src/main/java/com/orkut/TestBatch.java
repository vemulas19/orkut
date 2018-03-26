package com.orkut;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.ui.Model;

public class TestBatch {
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring", "root", "admin");
		
		PreparedStatement stmt1 = con.prepareStatement("insert into student values(?,?,?)");

		stmt1.setString(1, "sneha1@gmail.com");
		stmt1.setString(2, "Sneha");
		stmt1.setString(3, "1234");

		stmt1.addBatch();
//		int i = stmt1.executeUpdate();

//		PreparedStatement stmt2 = con.prepareStatement("insert into student values(?,?,?)");

		stmt1.setString(1, "ramarao1@gmail.com");
		stmt1.setString(2, "Ramarao");
		stmt1.setString(3, "rama@123");
		
		stmt1.addBatch();
//		int i2 = stmt2.executeUpdate();

//		PreparedStatement stmt3 = con.prepareStatement("insert into student values(?,?,?)");

		stmt1.setString(1, "venu1@gmail.com");
		stmt1.setString(2, "Venu");
		stmt1.setString(3, "4536");

		stmt1.addBatch();
		
		int[] i = stmt1.executeBatch();
		System.out.println("success");
//		int i3 = stmt3.executeUpdate();
		con.close();
	}
}
