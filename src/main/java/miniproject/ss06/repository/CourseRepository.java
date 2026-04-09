package miniproject.ss06.repository;

import miniproject.ss06.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseRepository {
    List<Course> findAll();
    Course findById(String id);
    void delete(String id);

    Optional<Course> findByCourseCode(String courseCode);

    Course findById(int id);

    void delete(int id);
}