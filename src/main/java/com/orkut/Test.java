package com.orkut;

public class Test {

	public static void main(String[] args) {
		
		Stud student1 = new Stud();
		student1.setName("Rakesh");
		student1.setCollegeName("Aurora");
		Passport p1 = new Passport();
		p1.setPptNumber("12345");
		student1.setPassport(p1);
		
		
		Stud student2 = new Stud();
		student2.setName("Ravi");
		student2.setCollegeName("GRRR");
		Passport p2 = new Passport();
		p2.setPptNumber("98765");
		student2.setPassport(p2);
		
		System.out.println(student1.getName() + student1.getCollegeName() + student1.getPassport().getPptNumber());
		System.out.println(student2.getName() + student2.getCollegeName() + student2.getPassport().getPptNumber());
		
		
	}
}
