package com.springdemo;

import com.spring.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class QueryStudentDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();

            List<Student> theStudents = session.createQuery("from Student").getResultList();
            displayStudents(theStudents);

            String criterionFirstName = "Paul";
            String criterionLastName = "Wall";

            System.out.println("Listing students where last name is : " + criterionLastName);
            theStudents = session.createQuery("from Student s where s.lastName = '" + criterionLastName + "'").getResultList();
            displayStudents(theStudents);

            System.out.println("Listing students with name : " + criterionFirstName + " " +  criterionLastName);
            theStudents = session.createQuery("from Student s where s.lastName= '" + criterionLastName + "' OR s.firstName = '"+ criterionFirstName + "'").getResultList();
            displayStudents(theStudents);

            String criterionEmail = "%gmail.com";
            System.out.println("Listing students with e-mail : " + criterionEmail);
            theStudents = session.createQuery("from Student s where s.email like '"+ criterionEmail + "'").getResultList();
            displayStudents(theStudents);

            session.getTransaction().commit();

            System.out.println("Done");
        }
        finally {
            sessionFactory.close();
        }
    }

    private static void displayStudents(List<Student> theStudents) {
        for (Student tempStudent: theStudents){
            System.out.println(tempStudent.getFirstName() + " " + tempStudent.getLastName());
        }
    }
}
