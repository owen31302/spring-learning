package com.owen.springtest.hibernatemapping._4_one_to_many_uni.demo;

import com.owen.springtest.hibernatemapping._4_one_to_many_uni.entity.Course;
import com.owen.springtest.hibernatemapping._4_one_to_many_uni.entity.Instructor;
import com.owen.springtest.hibernatemapping._4_one_to_many_uni.entity.InstructorDetail;
import com.owen.springtest.hibernatemapping._4_one_to_many_uni.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCoursesAndReviewsDemo {

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

            // create a course
            Course tempCourse = new Course("Pacman - How To Score One Million Points");

            // add some reviews
            tempCourse.addReview(new Review("Great course ... loved it!"));
            tempCourse.addReview(new Review("Cool course, job well done"));
            tempCourse.addReview(new Review("What a dumb course, you are an idiot!"));

            // save the course ... and leverage the cascade all :-)
            System.out.println("Saving the course");
            System.out.println(tempCourse);
            System.out.println(tempCourse.getReviews());

            session.save(tempCourse);

			
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





