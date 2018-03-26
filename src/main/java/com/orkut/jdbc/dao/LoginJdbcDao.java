package com.orkut.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.springframework.ui.Model;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.orkut.interf.dao.ILoginDao;
import com.orkut.pojo.Student;

public class LoginJdbcDao implements ILoginDao {

	public String loginUser(Student stud, Model model1) {
		System.out.println("Jdbc database logic!!");
		// Database logic using jdbc
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring", "root", "admin");
			PreparedStatement stmt = con.prepareStatement("insert into student values(?,?,?)");
			System.out.println(stud.getName());
			stmt.setString(1, stud.getMail());
			stmt.setString(2, stud.getName());
			stmt.setString(3, stud.getPassword());

			int i = stmt.executeUpdate();
			con.close();
		} catch (MySQLIntegrityConstraintViolationException e) {
			System.out.println(e);
			model1.addAttribute("message", "User already exist!! ");
			return "result";
		} catch (Exception e) {
			model1.addAttribute("message", "Database server is down!! Please try after some time!! ");
			return "result";
		}

		model1.addAttribute("message", "Successfully Registered!! ");
		return "result";
	}

	public void getAllStud(String name) {
		System.out.println("Jdbc database logic!!");
		System.out.println("testing");
	}
}
