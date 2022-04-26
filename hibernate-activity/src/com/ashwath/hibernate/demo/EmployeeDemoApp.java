package com.ashwath.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ashwath.hibernate.demo.entity.Employee;

public class EmployeeDemoApp {

	public static void main(String[] args) {
		//create session factory
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Employee.class)
										.buildSessionFactory();
				
		//create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			int employeeId = 1;
			
			// create an employee object
			Employee employee = new Employee("Percy", "Jackson", "Delphi");
			
			//start a transaction
			session.beginTransaction();
			
			//save the object
			session.save(employee);
			
			//commit the transaction
			session.getTransaction().commit();
			
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve employee using id
			employee = session.get(Employee.class, employeeId);
			
			session.getTransaction().commit();
			
			System.out.println("Retrieved employee : "+employee);
			
			//query to return all employees
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			@SuppressWarnings("unchecked")
			List<Employee> employees = session
									   .createQuery("from Employee"
									   		+ " where company='Delphi'")
									   .getResultList();
			
			//display the result
			for(Employee e : employees) {
				System.out.println(e);
			}
			
			session.getTransaction().commit();
			
			//delete employee using an employee id
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			employee = session.get(Employee.class, employeeId);
			System.out.println("The employee to be deleted : "+employee);
			
			session.delete(employee);
			
			session.getTransaction().commit();
			
			
			
			
			
			
			
		} 
		finally {
			
			sessionFactory.close();
		}
				

	}

}
