package com.app.model;

public class Employee {
	
	private int Emp_ID;
	private String Emp_Name;
	
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}


	public Employee(int emp_ID, String emp_Name) {
		super();
		Emp_ID = emp_ID;
		Emp_Name = emp_Name;
	}


	public int getEmp_ID() {
		return Emp_ID;
	}


	public void setEmp_ID(int emp_ID) {
		Emp_ID = emp_ID;
	}


	public String getEmp_Name() {
		return Emp_Name;
	}


	public void setEmp_Name(String emp_Name) {
		Emp_Name = emp_Name;
	}


	@Override
	public String toString() {
		return "Employee [Emp_ID=" + Emp_ID + ", Emp_Name=" + Emp_Name + "]";
	}
	
	

}
