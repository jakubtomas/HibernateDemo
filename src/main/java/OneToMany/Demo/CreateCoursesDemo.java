package OneToMany.Demo;

import OneToMany.entity.Course;
import OneToMany.entity.Instructor;
import OneToMany.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {
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
                // start transaction
                session.beginTransaction();

                int theId = 1;

                Instructor tempInstructor = session.get(Instructor.class, theId);
                // create some courses

                Course tempCourse1 = new Course("Play guitar");
                Course tempCourse2 = new Course("Play piano");

                // add courses to instructor
                tempInstructor.add(tempCourse1);
                tempInstructor.add(tempCourse2);

                // save the courses
                session.save(tempCourse1);
                session.save(tempCourse2);

                // commit transaction
                session.getTransaction().commit();
            }finally {
                // add clean up code
                session.close();

                factory.close();
            }

    }
}
