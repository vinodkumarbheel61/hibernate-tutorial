package com.geeks.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.geeks.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		 SessionFactory factory= new Configuration()
				 .configure("hibernate.cfg.xml")
				 .addAnnotatedClass(Student.class)
				 .buildSessionFactory();
		// create session 
		Session session = factory.getCurrentSession();
		try {
		
			// start a transaction
			session.beginTransaction();
			// Query Students
			List<Student> theStudents= session.createQuery("from Student").list();
			
			// Display Students
		     displayStudents(theStudents);
			
			// Using Stream API 
//			theStudents.stream().forEach(ele -> System.out.println(ele));
		     
	   
		     // Query Students: last name = "kumar"
		     theStudents=session.createQuery("from Student s where s.lastName='kumar'").list();
		     
		     // Display the Students
		     System.out.println("\n\nStudents who have last name of Kumar");
		     displayStudents(theStudents);
		     
		     
		     // Query Students: last name = "kumar" OR first name = "mukesh"
		     theStudents=session.createQuery("from Student s where s.lastName='kumari' OR s.firstName='mukesh'").list();
		     
		     // Display the Students
		     System.out.println("\n\nStudents who have last name of Kumar or first name of mukesh");
		     displayStudents(theStudents);
		     
		  // Query Students: email like "360factors.com"
		     theStudents=session.createQuery("from Student s where s.email LIKE '%360factors.com'").list();
		     
		  // Display the Students
		     System.out.println("\n\nStudents who have email ends with '360factors.com'");
		     displayStudents(theStudents);
		     
			// commit transaction
			 session.getTransaction().commit();
			 
			 System.out.println("Done!");
			 
		} finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			 System.out.println(tempStudent);
		 }
	}

}
