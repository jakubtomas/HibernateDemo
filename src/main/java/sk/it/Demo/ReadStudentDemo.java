package sk.it.Demo;

import org.dom4j.util.AttributeHelper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.it.hibernate.entity.Student;

public class ReadStudentDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

            Student tempStudent = new Student("Read Student name2 ", "Robinson ", "paul@gmail.com");

            // start a transaction
            session.beginTransaction();
            System.out.println("Save Student" + tempStudent.getId());
            session = factory.getCurrentSession();


            System.out.println("saving student");
            System.out.println(tempStudent);


            session.save(tempStudent);
            //commit transaction
            session.getTransaction().commit();

            System.out.println("DOne next ");

            System.out.println("Save  student , generated id " + tempStudent.getId());

            // now get a new session and start transaction
            session= factory.getCurrentSession();
            session.beginTransaction();

            // retrieve student base on the id primary key
            System.out.println("Getting student with id " + tempStudent.getId());

            Student myStudent = session.get(Student.class, tempStudent.getId()); // primary key

            System.out.println("get complete " + myStudent);

            session.getTransaction().commit();

            System.out.println("DONE ");
        }finally {
            factory.close();
        }
    }
}
