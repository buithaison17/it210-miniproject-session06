package miniproject.ss06.controller;

import miniproject.ss06.model.Course;
import miniproject.ss06.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping({"/courses", "/"})
public class CourseController {

    @Autowired
    private CourseService courseService;


    @GetMapping
    public String showCourses(Model model) {
        model.addAttribute("courses", courseService.findAll());
        return "course-list";
    }


    @PostMapping("/delete/{id}")
    public String deleteCourse(@PathVariable int id,
                               RedirectAttributes redirectAttributes) {

        boolean deleted = courseService.deleteCourse(id);

        if (!deleted) {
            redirectAttributes.addFlashAttribute(
                    "error",
                    "Không thể hủy khóa học đã có học viên đăng ký!"
            );
        } else {
            redirectAttributes.addFlashAttribute(
                    "success",
                    "Hủy khóa học thành công!"
            );
        }

        return "redirect:/course";
    }
}