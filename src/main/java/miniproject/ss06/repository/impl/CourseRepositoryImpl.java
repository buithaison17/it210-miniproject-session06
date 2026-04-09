package miniproject.ss06.repository.impl;

import miniproject.ss06.enums.LevelCourse;
import miniproject.ss06.model.Course;
import miniproject.ss06.repository.CourseRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepositoryImpl implements CourseRepository {

    private static List<Course> courses = new ArrayList<>();

    static {
        courses.add(new Course(1,"IELTS 5.5", LevelCourse.BEGINNER,"Basic IELTS","Mr A","3 tháng",3000000,false));
        courses.add(new Course(2,"IELTS 6.5", LevelCourse.INTERMEDIATE,"Improve IELTS","Ms B","4 tháng",5000000,false));
        courses.add(new Course(3,"IELTS 7.5", LevelCourse.ADVANCED,"Advanced IELTS","Mr C","5 tháng",7000000,true));
        courses.add(new Course(4,"TOEIC 600", LevelCourse.BEGINNER,"TOEIC cơ bản","Ms D","2 tháng",2000000,false));
        courses.add(new Course(5,"TOEIC 900", LevelCourse.ADVANCED,"TOEIC nâng cao","Mr E","3 tháng",6000000,false));
    }

    public List<Course> findAll() {
        return courses;
    }
}