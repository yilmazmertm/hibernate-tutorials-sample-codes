package com.springdemo;

import com.spring.demo.entity.Instructor;
import com.spring.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();

            int theId =1;

            Instructor tempInstructor = session.get(Instructor.class, theId);
            System.out.println("Found Instructor :" + tempInstructor);

            if (tempInstructor != null){
                System.out.println("Deleting" + tempInstructor);

                session.delete(tempInstructor);
            }

            session.getTransaction().commit();

            System.out.println("Done.!");
        }
        finally {
            session.close();
        }
    }
}
