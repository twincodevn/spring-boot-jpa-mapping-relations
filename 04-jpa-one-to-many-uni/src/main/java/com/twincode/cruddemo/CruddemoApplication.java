package com.twincode.cruddemo;

import com.twincode.cruddemo.dao.AppDAO;
import com.twincode.cruddemo.entity.Course;
import com.twincode.cruddemo.entity.Instructor;
import com.twincode.cruddemo.entity.InstructorDetail;
import com.twincode.cruddemo.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
//				createCourseAndReviews(appDAO);
				retrieveCourseAndReviews(appDAO);

		};
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {
		int theId = 10;
		Course course = appDAO.findCourseAndReviewsById(theId);
		System.out.println("Course retrieving : " + course);
		System.out.println("Course reviews : " + course.getReviews());
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		// create a course
		Course tempCourse = new Course("Pacman");
		// add some reviews
		tempCourse.addReview(new Review("Great course ... "));
		tempCourse.addReview(new Review("Cool course ..."));
		// save the course
		appDAO.save(tempCourse);
	}

	private void deleteCourse(AppDAO appDAO) {
		int theId = 10;
		appDAO.deleteCourse(theId);
		System.out.println("Deleting success!");
	}

	private void deleteInstructorWithCourses(AppDAO appDAO) {
		int theId = 1;
		appDAO.deleteInstructor(theId);
		System.out.println("Deleting success!");
	}

	private void updateCourse(AppDAO appDAO) {
		int theId = 10;
		Course course =appDAO.findCourseById(theId);
		course.setTitle("twincode course");
		appDAO.update(course);
	}

	private void findInstructorWithCourseJoinFetch(AppDAO appDAO) {
		int theId = 1;
		// find the instructor
		Instructor temp = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println(temp.getCourses());


	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId = 1;

		System.out.println("Finding ínstructor id : " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor " + tempInstructor);

		// find courses list

		List<Course> courseList = appDAO.findCoursesByInstructorId(theId);

		System.out.println(courseList);

	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId = 1;

		System.out.println("Finding ínstructor id : " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor " + tempInstructor);

		System.out.println("associated courese: " + tempInstructor.getCourses().get(0));

		System.out.println("Done!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		// create the instructor
		Instructor tempInstructor = new Instructor("Chad","VN","a@gmail.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("linkyoutube","code");

		// associate the objects

		tempInstructor.setInstructorDetail(tempInstructorDetail);
		// create some code
		Course tempCourse1 = new Course("JAVA");
		Course tempCourse2 = new Course("The Pinball Master");

		// add courses to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		appDAO.save(tempInstructor);

		System.out.println("Done");

	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 4;
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("done deleting !");
	}


	private void findInstructorDetail(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Finding instructor detail id: " + theId);
		InstructorDetail temp = appDAO.findInstructorDetailById(theId);

		System.out.println("tempInstructorDetail: " + temp);

		System.out.println("the associated instructor:  " + temp.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Deleting instructor have id " + theId);
		appDAO.deleteInstructorById(1);
		System.out.println("Done");
	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Finding instructor id: " + theId);
		Instructor temp = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + temp);

		System.out.println("the associated instructor detail:  " + temp.getInstructorDetail());

	}

	private void createInstructor(AppDAO appDAO){
		// create the instructor
		Instructor tempInstructor = new Instructor("Chad","VN","a@gmail.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("linkyoutube","code");

		// associate the objects

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		System.out.println("Saving instructor: " + tempInstructor);

		appDAO.save(tempInstructor);

		System.out.println("Done");
	}
}
