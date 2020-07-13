package com.springdemo;

import com.spring.demo.entity.Instructor;
import com.spring.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteInstructorDetailsDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();

            int theId = 3;

            InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);

            System.out.println("Temp Instructor Detail : " + tempInstructorDetail);
            System.out.println("Associated Instructor : " + tempInstructorDetail.getInstructor());


            // breaking the connection
            tempInstructorDetail.getInstructor().setInstructorDetail(null);

            //DELETE
            session.delete(tempInstructorDetail);

            session.getTransaction().commit();
            System.out.println("Done.!");
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        finally {
            factory.close();
            session.close();
        }
    }
}
