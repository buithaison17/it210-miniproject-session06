package miniproject.ss06.service.impl;

import miniproject.ss06.model.Course;
import miniproject.ss06.repository.CourseRepository;
import miniproject.ss06.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(int id) {
        return courseRepository.findById(id);
    }

    @Override
    public boolean deleteCourse(int id) {
        Course course = courseRepository.findById(id);

        if (course == null) {
            return false;
        }

        if (course.getStudentCount() > 0) {
            return false;
        }

        courseRepository.delete(id);
        return true;
    }
}