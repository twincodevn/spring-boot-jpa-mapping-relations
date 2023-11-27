package com.twincode.cruddemo.dao;

import com.twincode.cruddemo.entity.Course;
import com.twincode.cruddemo.entity.Instructor;
import com.twincode.cruddemo.entity.InstructorDetail;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class AppDAOImpl implements AppDAO{

    // define field for entity manager
    EntityManager entityManager;
    // inject entity manager using constructor injection
    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class,id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        Instructor tempInstructor = entityManager.find(Instructor.class,id);
        entityManager.remove(tempInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class,id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        InstructorDetail temp = entityManager.find(InstructorDetail.class,id);
        temp.getInstructor().setInstructorDetail(null);
        entityManager.remove(temp);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {
        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id=:data",Course.class);
        query.setParameter("data",theId);

        return query.getResultList();
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {
        TypedQuery<Instructor> query = entityManager.createQuery("select i from Instructor i JOIN FETCH i.courses where i.id = :data",Instructor.class);
        query.setParameter("data",id);
        return query.getSingleResult();

    }

    @Override
    @Transactional
    public Course findCourseById(int id) {
       return entityManager.find(Course.class,id);
    }

    @Override
    @Transactional
    public void update(Course tempCourse) {
        entityManager.merge(tempCourse);
    }

    @Override
    @Transactional
    public void deleteInstructor(int id) {
        Instructor tempInstructor = entityManager.find(Instructor.class,id);

        InstructorDetail tempInstructorDetail = tempInstructor.getInstructorDetail();
        tempInstructorDetail.setInstructor(null);

        for(Course course : tempInstructor.getCourses()){
            course.setInstructor(null);
        }

        entityManager.remove(tempInstructor);

    }

    @Override
    @Transactional
    public void deleteCourse(int id) {
        Course tempCourse = entityManager.find(Course.class,id);

        entityManager.remove(tempCourse);


    }
}
