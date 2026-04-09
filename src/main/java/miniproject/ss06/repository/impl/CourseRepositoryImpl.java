package miniproject.ss06.repository.impl;

import miniproject.ss06.enums.LevelCourse;
import miniproject.ss06.model.Course;
import miniproject.ss06.repository.CourseRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepositoryImpl implements CourseRepository {

    private static final List<Course> courses = new ArrayList<>();

    static {
        courses.add(new Course(1, "IELTS Foundation", LevelCourse.BEGINNER,
                "Lộ trình nền tảng IELTS", "Mr. John", "45 giờ",
                3500000, false, 0));

        courses.add(new Course(2, "IELTS 6.5 Intensive", LevelCourse.INTERMEDIATE,
                "Khóa tăng tốc band 6.5", "Ms. Anna", "60 giờ",
                5500000, true, 12));

        courses.add(new Course(3, "TOEIC Basic", LevelCourse.BEGINNER,
                "Luyện thi TOEIC nền tảng", "Mr. David", "40 giờ",
                2500000, false, 0));

        courses.add(new Course(4, "Advanced Communication", LevelCourse.ADVANCED,
                "Kỹ năng giao tiếp nâng cao", "Ms. Rose", "50 giờ",
                4500000, false, 5));

        courses.add(new Course(5, "Pronunciation Master", LevelCourse.INTERMEDIATE,
                "Chỉnh sửa phát âm chuyên sâu", "Mr. Ken", "30 giờ",
                3000000, false, 0));
    }

    @Override
    public List<Course> findAll() {
        return courses;
    }

    @Override
    public Course findById(String id) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Course findById(int id) {
        return courses.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void delete(int id) {
        courses.removeIf(c -> c.getId() == id);
    }
}