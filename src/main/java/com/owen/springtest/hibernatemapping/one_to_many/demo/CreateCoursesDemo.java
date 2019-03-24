package com.owen.springtest.hibernatemapping.one_to_many.demo;


import com.owen.springtest.hibernatemapping.one_to_many.entity.Course;
import com.owen.springtest.hibernatemapping.one_to_many.entity.Instructor;
import com.owen.springtest.hibernatemapping.one_to_many.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCoursesDemo {

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

			// get the instructor from db
			int theId = 1;
			Instructor instructor = session.get(Instructor.class, theId);

			// create some courses
			Course course1 = new Course("Air Guitar");
			Course course2 = new Course("The matrix");

			// add courses to instructor
			instructor.add(course1);
			instructor.add(course2);

			// save the courses
			session.save(course1);
			session.save(course2);

			
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





