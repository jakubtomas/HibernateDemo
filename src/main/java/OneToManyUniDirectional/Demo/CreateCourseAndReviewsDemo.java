package OneToManyUniDirectional.Demo;

import OneToManyUniDirectional.entity.Course;
import OneToManyUniDirectional.entity.Instructor;
import OneToManyUniDirectional.entity.InstructorDetail;
import OneToManyUniDirectional.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
			
			
			// create a course
			Course tempCourse = new Course("How to be happy like programmer");
			
			// add some reviews
			tempCourse.addReview(new Review("super kurz !"));
			tempCourse.addReview(new Review("velmi pjekny kust"));
			tempCourse.addReview(new Review("davaj zupa kurze "));
						
			// save the course ... and leverage the cascade all :-)
			System.out.println("Saving the course");
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
			
			session.save(tempCourse);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			
			// add clean up code
			session.close();
			
			factory.close();
		}
	}

}





