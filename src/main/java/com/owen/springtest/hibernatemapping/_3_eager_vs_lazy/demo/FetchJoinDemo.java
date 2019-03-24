package com.owen.springtest.hibernatemapping._3_eager_vs_lazy.demo;


import com.owen.springtest.hibernatemapping._2_one_to_many.entity.Course;
import com.owen.springtest.hibernatemapping._2_one_to_many.entity.Instructor;
import com.owen.springtest.hibernatemapping._2_one_to_many.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class FetchJoinDemo {

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

			// Resolve the issue: Option2 -> Hibernate query with HQL

			// get the instructor from db
			int theId = 1;

			Query<Instructor> query =
							session.createQuery("select i from Instructor i " +
									      			"join fetch i.courses " +
													"where i.id=:theInstructorId",
							Instructor.class);

			// set parameter on query
			query.setParameter("theInstructorId", theId);

			Instructor instructor = query.getSingleResult();

			System.out.println("[Owen] Instructor: " + instructor);


			// commit transaction
			session.getTransaction().commit();

			session.close();

			System.out.println("[Owen] Courses: " + instructor.getCourses());

			System.out.println("[Owen] Done!");


		}
		finally {
			session.close();

			factory.close();
		}
	}

}





