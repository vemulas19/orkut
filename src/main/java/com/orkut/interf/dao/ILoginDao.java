package com.orkut.interf.dao;

import org.springframework.ui.Model;

import com.orkut.pojo.Student;

public interface ILoginDao {

	public String loginUser(Student stud, Model model1);

	public void getAllStud(String name);
}
