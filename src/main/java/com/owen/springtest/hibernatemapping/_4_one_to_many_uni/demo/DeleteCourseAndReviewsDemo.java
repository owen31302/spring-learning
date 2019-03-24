package com.owen.springtest.hibernatemapping._4_one_to_many_uni.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.owen.springtest.hibernatemapping._4_one_to_many_uni.entity.Course;
import com.owen.springtest.hibernatemapping._4_one_to_many_uni.entity.Instructor;
import com.owen.springtest.hibernatemapping._4_one_to_many_uni.entity.InstructorDetail;
import com.owen.springtest.hibernatemapping._4_one_to_many_uni.entity.Review;


public class DeleteCourseAndReviewsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();

			// get the course
			int theId = 10;
			Course tempCourse = session.get(Course.class, theId);
			
			// print the course
			System.out.println("Deleting the course ... ");
			System.out.println(tempCourse);
			
			// print the course reviews
			System.out.println(tempCourse.getReviews());
			
			// delete the course
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





