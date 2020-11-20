package OneToOne.Demo;

import OneToOne.hibernate.entity.Instructor;
import OneToOne.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.it.hibernate.entity.Student;

public class CreateDemo {
    public static void main(String[] args) {



            SessionFactory factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Instructor.class)
                    .addAnnotatedClass(InstructorDetail.class)
                    .buildSessionFactory();

            Session session = factory.getCurrentSession();

            try{

                Instructor tempInstructor = new Instructor("chad ", "Pista", "email@gmail.com");
                InstructorDetail tempInstructorDetail = new InstructorDetail("https://www.youtube.com/watch?v=HW-heSo9580" , "hockey");

                tempInstructor.setInstructorDetail(tempInstructorDetail);
                session.beginTransaction();

                System.out.println("Saving the tempInstructor ");
                session.save(tempInstructor);

                session.getTransaction().commit();
            }finally {
                factory.close();
            }

    }
}
