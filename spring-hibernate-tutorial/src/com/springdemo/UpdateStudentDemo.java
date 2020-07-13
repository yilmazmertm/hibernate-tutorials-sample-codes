package com.springdemo;

import com.spring.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class UpdateStudentDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            int studentId = 1;

            session.beginTransaction();
            System.out.println("Getting the studetn with Student ID : " + studentId);

            Student myStudent = session.get(Student.class, studentId);

            System.out.println("Updating the objects..");

            myStudent.setFirstName("MertMert");

            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Updating email for all the students ");
            session.createQuery("update Student set email = 'foo@gmail.com'").executeUpdate();
            session.getTransaction().commit();
            myStudent.setFirstName("Done .!");
        }
        finally {
            factory.close();
        }
    }
}
