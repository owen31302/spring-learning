package com.owen.springtest.hibernatemapping._3_eager_vs_lazy.demo;


import com.owen.springtest.hibernatemapping._2_one_to_many.entity.Course;
import com.owen.springtest.hibernatemapping._2_one_to_many.entity.Instructor;
import com.owen.springtest.hibernatemapping._2_one_to_many.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class EagerLazyDemo {

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

			System.out.println("[Owen] Instructor: " + instructor);

			// break lazy loading by closing the session
			//session.close();

			// lazy loading happens here
			System.out.println("[Owen] Courses: " + instructor.getCourses());

			// commit transaction
			session.getTransaction().commit();

			session.close();

			// Resolve the issue: Option1 -> call the getter method while session in open,
			// and the later use will still be valid.
			// This works fine because the data was loaded at line 42.
			System.out.println("[Owen] Courses: " + instructor.getCourses());

			System.out.println("[Owen] Done!");


		}
		finally {
			session.close();

			factory.close();
		}
	}

}





