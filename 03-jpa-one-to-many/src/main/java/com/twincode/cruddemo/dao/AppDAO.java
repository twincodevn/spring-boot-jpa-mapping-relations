package com.twincode.cruddemo.dao;

import com.twincode.cruddemo.entity.Instructor;
import com.twincode.cruddemo.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor theInstructor);
    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);





}
