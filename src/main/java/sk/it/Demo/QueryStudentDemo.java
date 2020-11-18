package sk.it.Demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.it.hibernate.entity.Student;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

           // Student tempStudent = new Student("Paul", "Robinson ", "paul@gmail.com");

            session.beginTransaction();

            List<Student> theStudents = session.createQuery("from Student").list();

            printStudents(theStudents);


            // Query students : lastName Robinson
            System.out.println("======================================");
            System.out.println("======================================");
            System.out.println("======================================");

            theStudents = session.createQuery("from Student s where s.lastName = 'Robinson'").list();


            printStudents(theStudents);




            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }


    private static void printStudents(List<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }
    }
}
