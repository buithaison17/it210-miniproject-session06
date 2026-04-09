package miniproject.ss06.service;

import miniproject.ss06.model.Course;
import java.util.List;

public interface CourseService {
    List<Course> findAll();
    Course findById(int id);
    boolean deleteCourse(int id);
}