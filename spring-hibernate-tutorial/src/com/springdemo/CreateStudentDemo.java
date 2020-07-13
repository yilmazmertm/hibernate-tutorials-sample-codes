package com.springdemo;

import com.spring.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateStudentDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            System.out.println("Creating a new student object ");
            Student tempStudent = new Student("Paul", "Wall", "paulwall@gmail.com");

            session.beginTransaction();

            session.save(tempStudent);

            session.getTransaction().commit();

            System.out.println("Done.!");
        }
        finally {
            session.close();
        }
    }
}
