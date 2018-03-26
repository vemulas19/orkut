package com.orkut;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationController {

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public String getAllUsers(Model model) throws SQLException, ClassNotFoundException {
		System.out.println("Entered into controller!!");

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring", "root", "admin");
			PreparedStatement stmt = con.prepareStatement("select *from student");

			ResultSet rs = stmt.executeQuery();
			
			List<Stud> list = new ArrayList<Stud>();
			while (rs.next()) {

				Stud std = new Stud();
				
				String name = rs.getString("name");
				String password = rs.getString("password");
				String mail = rs.getString("email");

				std.setName(name);
				std.setPassword(password);
				std.setMail(mail);
				list.add(std);
			}
			System.out.println(list);
			model.addAttribute("stdList", list);
		
			con.close();		
			return "response";
	}
}
