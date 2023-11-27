package com.twincode.cruddemo;

import com.twincode.cruddemo.dao.AppDAO;
import com.twincode.cruddemo.entity.Course;
import com.twincode.cruddemo.entity.Instructor;
import com.twincode.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
//			createInstructor(appDAO);
//			findInstructor(appDAO);
//			deleteInstructor(appDAO);
//			findInstructorDetail(appDAO);
//			deleteInstructorDetail(appDAO);
			createInstructorWithCourses(appDAO);
		};
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
