package miniproject.ss06.controller;

import miniproject.ss06.enums.LevelCourse;
import miniproject.ss06.model.Course;
import miniproject.ss06.service.CourseService;
import miniproject.ss06.service.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Locale;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Controller
@RequestMapping({"/courses", "/"})
public class CourseController {

    @Autowired
    private CourseService courseService;


    @GetMapping({"", "/", "/course-list"})
    public String showCourses(
            @RequestParam(name = "level", defaultValue = "BEGINNER") LevelCourse level,
            @RequestParam(name = "maxPrice", defaultValue = "10000000") double maxPrice,
            Model model
    ) {

        List<Course> courses = courseService.filter(level, maxPrice);

        model.addAttribute("courses", courses);
        model.addAttribute("selectedLevel", level);
        model.addAttribute("maxPrice", maxPrice);

        return "course-list";
    }

    @GetMapping("/detail/{courseCode}")
    public String showCourseDetail(@PathVariable("courseCode") String courseCode, Model model) {
        model.addAttribute("course", courseService.findByCourseCode(courseCode)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Course not found: " + courseCode)));
        return "course-detail";
    }

    @PostMapping("/delete/{id}")
    public String deleteCourse(@PathVariable("id") int id,
                               RedirectAttributes redirectAttributes) {
        boolean deleted = courseService.deleteCourse(id);

        if (!deleted) {
            redirectAttributes.addFlashAttribute("error",
                    "Không thể hủy khóa học đã có học viên đăng ký!");
        } else {
            redirectAttributes.addFlashAttribute("success",
                    "Hủy khóa học thành công!");
        }

        return "redirect:/courses";

    }
}
