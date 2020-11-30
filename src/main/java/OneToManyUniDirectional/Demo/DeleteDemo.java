package OneToManyUniDirectional.Demo;

import OneToManyUniDirectional.entity.Instructor;
import OneToManyUniDirectional.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {



            SessionFactory factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Instructor.class)
                    .addAnnotatedClass(InstructorDetail.class)
                    .buildSessionFactory();

            Session session = factory.getCurrentSession();

            try{

                // start transaction
                session.beginTransaction();

                // get instructor by primary key
                int theId = 1;
                Instructor tempInstructor = session.get(Instructor.class, theId);

                //delete the instructors
                if (tempInstructor != null) {
                    System.out.println("deleting " + tempInstructor);

                    //NOTE  will also delete associated details object
                    // because of cascadetype.ALL

                    session.delete(tempInstructor);
                }

                session.getTransaction().commit();
                System.out.println("Delete object ");
            }finally {
                factory.close();
            }

    }
}
