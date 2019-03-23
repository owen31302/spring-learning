package com.owen.springtest.hibernate.demo;


import com.owen.springtest.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author yuchlin on 3/19/19
 */
public class CreateStudentDemo {
    public static void main(String[] args){

        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));

        // create session factory
        // https://stackoverflow.com/a/37880064
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = sessionFactory.getCurrentSession();

        try{
            // use the session object to save Java object

            // create a student object
            System.out.println("Creating new student object ...");
            Student student = new Student("Owen", "Lin", "owen@com");

            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the student ...");
            session.save(student);

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done.");

        }finally {
            sessionFactory.close();
        }

    }
}
