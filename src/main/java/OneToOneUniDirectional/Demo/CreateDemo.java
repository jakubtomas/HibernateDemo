package OneToOneUniDirectional.Demo;

import OneToOneUniDirectional.hibernate.entity.Instructor;
import OneToOneUniDirectional.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
