package OneToMany.Demo;

import OneToMany.entity.Course;
import OneToMany.entity.Instructor;
import OneToMany.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {
    public static void main(String[] args) {



            SessionFactory factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Instructor.class)
                    .addAnnotatedClass(InstructorDetail.class)
                    .addAnnotatedClass(Course.class)
                    .buildSessionFactory();

            // create session
            Session session = factory.getCurrentSession();

            try{

                Instructor tempInstructor = new Instructor("firstName ", "lastn name a", "email@gmail.com");
                InstructorDetail tempInstructorDetail = new InstructorDetail("https://www.youtube.com/watch?v=HW-heSo4560" , "hockey");

                tempInstructor.setInstructorDetail(tempInstructorDetail);
                session.beginTransaction();

                System.out.println("saving the instructorDetial " + tempInstructorDetail);
                System.out.println("Saving the instructor " + tempInstructor);
                session.save(tempInstructor);

                // commit transaction
                session.getTransaction().commit();
            }finally {
                // add clean up code
                session.close();

                factory.close();
            }

    }
}
