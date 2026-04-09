package miniproject.ss06.service.impl;

import miniproject.ss06.enums.LevelCourse;
import miniproject.ss06.model.Course;
import miniproject.ss06.repository.impl.CourseRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl {

    @Autowired
    private CourseRepositoryImpl repo;

    public List<Course> filter(LevelCourse level, double maxPrice) {
        return repo.findAll().stream()
                .filter(c -> c.getLevelCourse() == level)
                .filter(c -> c.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }
}