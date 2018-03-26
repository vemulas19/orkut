package com.orkut;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orkut.pojo.Student;

@Controller
public class UpdateAndDeleteController {

	@RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
	public String updateStudent(@ModelAttribute("studForm") Student stud, Model model) throws ClassNotFoundException, SQLException{
		System.out.println("Testing update Student");
		System.out.println(stud.getName());
		System.out.println(stud.getPassword());
		System.out.println(stud.getMail());
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring", "root", "admin");
		PreparedStatement stmt = con.prepareStatement("UPDATE spring.student SET name = ?, password = ? where email=?");
		stmt.setString(1, stud.getName());
		stmt.setString(2, stud.getPassword());
		stmt.setString(3, stud.getMail());
		
		int i = stmt.executeUpdate();	
		model.addAttribute("message", "Succefully Update the record!!");
		model.addAttribute("isFromRegister",false);
		return "result";
	}
	
}
