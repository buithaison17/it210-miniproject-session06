package miniproject.ss06.controller;

import miniproject.ss06.enums.LevelCourse;
import miniproject.ss06.model.Course;
import miniproject.ss06.service.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseServiceImpl service;

    @GetMapping({"", "/", "/course-list"})
    public String showCourses(
            @RequestParam(defaultValue = "BEGINNER") LevelCourse level,
            @RequestParam(defaultValue = "10000000") double maxPrice,
            Model model
    ) {
        List<Course> courses = service.filter(level, maxPrice);

        model.addAttribute("courses", courses);
        model.addAttribute("selectedLevel", level);
        model.addAttribute("maxPrice", maxPrice);

        return "course-list";
    }
}