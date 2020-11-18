package sk.it.Demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.it.hibernate.entity.Student;

public class PrimaryKeyDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

            Student tempStudent1 = new Student("Jack1", "Robinson1 ", "paul@gmail.com");
            Student tempStudent2 = new Student("Jack2", "Robinson2 ", "paul@gmail.com");
            Student tempStudent3 = new Student("Jack3", "Robinson3 ", "paul@gmail.com");

            session.beginTransaction();

            System.out.println("Saving the student ");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}
