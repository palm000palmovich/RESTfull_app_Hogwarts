import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.services.StudentService;
import ru.hogwarts.school.services.StudentServiceImpl;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentServiceTest {
    private StudentService studentService;
    private Student student1;
    private Student student2;
    private Student student3;

    @BeforeEach
    public void setUp(){
        studentService = new StudentServiceImpl();
        student1 = new Student(1l, "Алик Махакян", 24);
        student2 = new Student(2l, "Мурад сардаров", 17);
        student3 = new Student(3l, "Федор Ничеперонко", 35);

        studentService.createStudent(student1);
        studentService.createStudent(student2);
        studentService.createStudent(student3);
    }

    @Test
    public void createStudentTest(){
        studentService.createStudent(student1);
        studentService.createStudent(student2);
        studentService.createStudent(student3);

        Collection<Student> expected = studentService.getAllStudents();

        Collection<Student> actual = new HashSet<>();
        actual.add(student1);
        actual.add(student2);
        actual.add(student3);

        assertEquals(expected.size(), actual.size());

    }

    @Test
    public void  findStudentTest(){
        Student actual = student2;

        Student expected = studentService.findStudent(2);

        assertEquals(expected, actual);
    }

}
