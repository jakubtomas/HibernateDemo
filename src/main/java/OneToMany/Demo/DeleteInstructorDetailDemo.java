package OneToMany.Demo;

import OneToMany.entity.Instructor;
import OneToMany.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {
    public static void main(String[] args) {



            SessionFactory factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Instructor.class)
                    .addAnnotatedClass(InstructorDetail.class)
                    .buildSessionFactory();

            Session session = factory.getCurrentSession();

        try {

            // start transaction
            session.beginTransaction();

            int theId = 4;

            InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);

            // print the instructor detail
            System.out.println("temInstructorDetail " + tempInstructorDetail);

            // print the associated instructor
            System.out.println("the associated instructor ! +" + tempInstructorDetail.getInstructor());

            // now lets delete the instructor detail
            System.out.println("Deleting tempInstrcutor detial "  + tempInstructorDetail);

            tempInstructorDetail.getInstructor().setInstructorDetail(null);

            session.delete(tempInstructorDetail);

            session.getTransaction().commit();
            System.out.println("Delete object ");

        } catch (Exception exception) {
            exception.printStackTrace();

        } finally {
            factory.close();
        }

    }
}
