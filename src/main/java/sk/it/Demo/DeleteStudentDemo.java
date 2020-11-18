package sk.it.Demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.it.hibernate.entity.Student;

public class DeleteStudentDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            int studentId = 1;

            session = factory.getCurrentSession();
            session.beginTransaction();

            Student myStudent = session.get(Student.class, studentId);


            // delete Student
            session.delete(myStudent);



            session.getTransaction().commit();
            System.out.println("Done! Delete Account ");

        }finally {
            factory.close();
        }
    }
}
