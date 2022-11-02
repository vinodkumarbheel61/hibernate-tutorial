package com.geeks.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.build.AllowSysOut;

import com.geeks.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		 SessionFactory factory= new Configuration()
				 .configure("hibernate.cfg.xml")
				 .addAnnotatedClass(Student.class)
				 .buildSessionFactory();
		// create session 
		Session session = factory.getCurrentSession();
		try {			 
			 int studentId =1;			 
			 // now get a new session and start transaction
			  session=factory.getCurrentSession();
			  session.beginTransaction();
			 // retrieve student based on the id: primary key
			 System.out.println("\nGetting student with id: "+ studentId);
			 
			 Student myStudent = session.get(Student.class, studentId);
			 
			 System.out.println("Updating student...");
			 myStudent.setFirstName("vikram");
			 
			 // commit the transaction
			 session.getTransaction().commit();
			 
			 System.out.println("Done!");
			 
			 
			 //New Code 
			  session=factory.getCurrentSession();
			  session.beginTransaction();
			  
			  // update email for all students
			  session.createQuery("update Student set email='bheel@gmail.com'").executeUpdate();
			 
			  
			  session.getTransaction().commit();
			  System.out.println("Done!");
			 
		} finally {
			factory.close();
		}

	}

}
