package com.app.main;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.app.model.Employee;

public class Lounch {

	static Scanner sc = new Scanner(System.in);
	static Session session = getSession();
	static Transaction tsn;
	public static void main(String[] args) {
		
		
		
		while(true){
			
			System.out.println("Enter\n 1.Insert Data\n 2.Read Data\n 3.Update Data\n 4.Delete Data\n 5.Read All Data\n 6.Exit");
			int choice = sc.nextInt();
			if(choice == 6)break;
			
			
			switch(choice) {
			case 1:
				insertData();
				break;
			case 2:
				readData();
				break;
			case 3:
				updateData();
				break;
			case 4:
				deleteData();
				break;
			case 5:
				readAllData();
				break;
			
			}
			
		}
		
		
		
		System.out.println(session);
		
	}

	private static void readAllData() {
		// TODO Auto-generated method stub
		
	
		
		Criteria createCriteria = session.createCriteria(Employee.class);
		
		List<Employee> emp = createCriteria.list();
		
		for(Employee e:emp) {
			System.out.println("Employee ID: "+e.getEmp_ID()+" Employee Name:-"+e.getEmp_Name());
		}
		
		
		
	}

	private static void deleteData() {
		// TODO Auto-generated method stub
		
		System.out.println("Enter The Employee ID");
		int Emp_ID = sc.nextInt();
		
		Employee emp = session.get(Employee.class, Emp_ID);
		
		if(emp!=null) {
			
			tsn = session.beginTransaction();
			
			session.delete(emp);
			
			System.out.println("Deleted");
			
			tsn.commit();
			
		}
		else {
			System.out.println("Employee Not Found "+Emp_ID);
		}
		
	}

	private static void updateData() {
		// TODO Auto-generated method stub
		
		System.out.println("Enter The Emp_ID");
		int Emp_ID = sc.nextInt();
		
		Employee emp = session.get(Employee.class, Emp_ID);
		
		if(emp!=null) {
			
			System.out.println("Enter The Name");
			String Emp_Name = sc.next();
			

			tsn = session.beginTransaction();
			emp.setEmp_Name(Emp_Name);
			session.update(emp);
			
			
			
			System.out.println("Data updated!");
			
		}
		else {
			System.out.println("Emp ID "+Emp_ID+" Not Found");
		}
		
		tsn.commit();
		
	}

	private static void readData() {
		// TODO Auto-generated method stub
		
		System.out.println("Enter The Emp_ID");
		int Emp_ID = sc.nextInt();
		
		Employee emp = session.get(Employee.class, Emp_ID);
		
		if(emp!=null) {
			System.out.println("Employee ID "+emp.getEmp_ID()+" Employee Name "+emp.getEmp_Name());
		}
		else {
			System.out.println("Employee with id "+Emp_ID+" Not Found");
		}
		
	
		
		
	}

	private static void insertData() {
		// TODO Auto-generated method stub
		
		System.out.println("Enter The Emp_ID:");
		int Emp_ID = sc.nextInt();
		
		System.out.println("Enter The Emp_Name:");
		String Emp_Name = sc.next();
		
		Employee emp = new Employee(Emp_ID, Emp_Name);
		
		tsn = session.beginTransaction();
		
		int row = (int)session.save(emp);
		
		if(row == row) {
			System.out.println("Data Saved!");
		}
		else {
			System.out.println("Something Went Wrong!");
		}
		
		
		tsn.commit();
		
		
		
	}

	private static Session getSession() {
		Configuration conn = new Configuration();
		conn.configure();
		
		SessionFactory bsf = conn.buildSessionFactory();
		
		Session session = bsf.openSession();
		return session;
	}
}
