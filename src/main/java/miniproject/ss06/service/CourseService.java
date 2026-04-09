package miniproject.ss06.service;

import miniproject.ss06.enums.LevelCourse;
import miniproject.ss06.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAll();
    Course findById(int id);
    List<Course> filter(LevelCourse level, double maxPrice);
    boolean deleteCourse(int id);
}
