package miniproject.ss06.service;

import miniproject.ss06.enums.LevelCourse;
import miniproject.ss06.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Course> findAll();
    Optional<Course> findByCourseCode(String courseCode);
    Course findById(int id);
    List<Course> filter(LevelCourse level, double maxPrice);
    boolean deleteCourse(int id);
}
