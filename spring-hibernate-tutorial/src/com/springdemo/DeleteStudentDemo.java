package com.springdemo;

import com.spring.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = factory.getCurrentSession();
        try{
            int studentId = 3;

            session.beginTransaction();
            System.out.println("Getting the studetn with Student ID : " + studentId);

            Student myStudent = session.get(Student.class, studentId);
            System.out.println("Deleting the student : " + myStudent);
            session.delete(myStudent);

            // Alternate delete approach
            System.out.println("Deleting the student with the ID: " + studentId);
            session.createQuery("delete from Student where id ="+ studentId);

            session.getTransaction().commit();
            System.out.println("Done");

        }
        finally {
            factory.close();
        }
    }
}
