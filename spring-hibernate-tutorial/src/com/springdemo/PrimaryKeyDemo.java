package com.springdemo;

import com.spring.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class PrimaryKeyDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            System.out.println("Creating 3 new student object ");
            Student tempStudent1 = new Student("Paul", "Wall", "paulwall@gmail.com");
            Student tempStudent2 = new Student("Mert", "Yilmaz", "mertyilmaz@gmail.com");
            Student tempStudent3 = new Student("Daft", "Punk", "daftpunk@gmail.com");

            session.beginTransaction();

            System.out.println("Saving student objects ");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            session.getTransaction().commit();

        }
        finally {
            session.close();
        }
    }
}
