package com.owen.springtest.hibernatemapping._5_many_to_many.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.owen.springtest.hibernatemapping._5_many_to_many.entity.Course;
import com.owen.springtest.hibernatemapping._5_many_to_many.entity.Instructor;
import com.owen.springtest.hibernatemapping._5_many_to_many.entity.InstructorDetail;
import com.owen.springtest.hibernatemapping._5_many_to_many.entity.Review;
import com.owen.springtest.hibernatemapping._5_many_to_many.entity.Student;

public class DeletePacmanCourseDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();

			// get the pacman course from db
			int courseId = 10;
			Course tempCourse = session.get(Course.class, courseId);
			
			// delete the course
			System.out.println("Deleting course: " + tempCourse);
			
			session.delete(tempCourse);
						
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			
			// add clean up code
			session.close();
			
			factory.close();
		}
	}

}





