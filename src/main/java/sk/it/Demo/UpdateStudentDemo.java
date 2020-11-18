package sk.it.Demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.it.hibernate.entity.Student;

public class UpdateStudentDemo {
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

            Student student = session.get(Student.class, studentId);
            student.setFirstName("Jakobysss ");

            //session.createQuery("update Student set email='mail@gmail.com'").executeUpdate();

            session.getTransaction().commit();
            System.out.println("Done!");

        }finally {
            factory.close();
        }
    }
}
