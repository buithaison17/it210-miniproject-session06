package miniproject.ss06.repository;

import miniproject.ss06.model.Course;

import java.util.List;

public interface CourseRepository {
    List<Course> findAll();
    Course findById(int id);
    void delete(int id);
}