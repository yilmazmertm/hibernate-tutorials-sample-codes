package com.springdemo;

import com.spring.demo.entity.Instructor;
import com.spring.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            Instructor tempInstructor = new Instructor("Mert", "Yilmaz", "yilmazmertm@gmail.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail("youtube.com/yilmazmertm", "Swimming ! ! ! ");
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            session.beginTransaction();
            session.save(tempInstructor);

            session.getTransaction().commit();

            System.out.println("Done.!");
        }
        finally {
            session.close();
        }
    }
}
