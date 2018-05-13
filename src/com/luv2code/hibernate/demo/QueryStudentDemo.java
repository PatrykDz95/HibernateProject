package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();


                try{
                //use the session object to save Java object

                    //start a transaction
                    session.beginTransaction();

                    //query students
                    List<Student> theStudents = session.createQuery("from Student").getResultList();


                    //query students: lastName='Duck'
                    theStudents=session.createQuery("from Student s where s.lastName='Duck'").getResultList();

                    //display the students
                    System.out.println("Students who have last name Duck");
                    displayStudents(theStudents);

                    //query students: lastname =Duck or firstName = Patryk
                    theStudents=session.createQuery("from Student s " +
                            "where s.lastName='Duck' OR s.firstName='Patryk'").getResultList();

                    System.out.println("Students who have first name Patryk or last name Duck");
                    displayStudents(theStudents);


                    //query students: where email LIKE '%@gmail.com
                    theStudents=session.createQuery("from Student s " +
                            "where s.email LIKE '%gmail.com' ").getResultList();

                    System.out.println("Students who have email ending with gmail.com");
                    displayStudents(theStudents);

                    //commit transaction
                    session.getTransaction().commit();
                    System.out.println("Done!");
                }
                finally {
            factory.close();
                }
    }

    private static void displayStudents(List<Student> theStudents) {
        for(Student tempStudent : theStudents){
            System.out.println(tempStudent);
        }
    }


}
