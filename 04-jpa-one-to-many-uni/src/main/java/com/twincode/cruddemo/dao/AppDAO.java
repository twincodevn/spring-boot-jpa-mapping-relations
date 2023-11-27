package com.twincode.cruddemo.dao;

import com.twincode.cruddemo.entity.Course;
import com.twincode.cruddemo.entity.Instructor;
import com.twincode.cruddemo.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {
    void save(Instructor theInstructor);
    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);

    List<Course> findCoursesByInstructorId(int theId);


    Instructor findInstructorByIdJoinFetch(int id);


    Course findCourseById(int id);

    void update(Course tempCourse);

    void deleteInstructor(int id);

    void deleteCourse(int id);

    void save(Course theCourse);

    Course findCourseAndReviewsById(int id);







}
