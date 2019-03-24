package com.owen.springtest.hibernatemapping.one_to_many.demo;


import com.owen.springtest.hibernatemapping.one_to_many.entity.Course;
import com.owen.springtest.hibernatemapping.one_to_many.entity.Instructor;
import com.owen.springtest.hibernatemapping.one_to_many.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteCoursesDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();

			// get a course
			int theId = 10;
			Course course = session.get(Course.class, theId);

			// delete it
			System.out.println("Deleting course: " + course);

			session.delete(course);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			session.close();

			factory.close();
		}
	}

}





