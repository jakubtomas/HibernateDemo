package sk.it.Demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import sk.it.hibernate.entity.Student;
public class CreateStudentDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

            Student tempStudent = new Student("Paul", "Robinson ", "paul@gmail.com");

            session.beginTransaction();

            System.out.println("Saving the student ");
            session.save(tempStudent);

            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}
