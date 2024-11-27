package ru.hogwarts.school.services;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {
    private Map<Long, Student> students = new HashMap<>();
    private long lastId = 0;


    //Создание-добавление студента
    @Override
    public Student createStudent(Student student){
        student.setId(++lastId);
        students.put(student.getId(), student);
        return student;
    }

    //Поиск студента
    @Override
    public Student findStudent(long id){
        if (!students.containsKey(id)){return null;}
        return students.get(id);
    }

    //Редактирование студента
    @Override
    public Student editStudent(Student student){
        if (students.containsKey(student.getId())){
            students.put(student.getId(), student);
            return student;
        }
        return null;
    }

    //Удаление студента
    @Override
    public Student deleteStudent(long id){
        if (students.containsKey(id)){
            return students.remove(id);
        }
        return null;
    }

    //Вывод всех студентов
    @Override
    public Collection<Student> getAllStudents(){
        if (students == null){return null;} return students.values();
    }

    //Поиск студентов по возрасту
    @Override
    public List<Student> studentsPureAge(int age){
        if (students == null){return null;}
        List<Student> studentInAgeList = new ArrayList<>();
        for (final Student student : students.values()){
            if (student.getAge() == age){studentInAgeList.add(student);}
        }
        return studentInAgeList;
    }

}
