package ru.hogwarts.school.services;

import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.List;

public interface StudentService {
    //Создание-добавление студента
    Student createStudent(Student student);

    //Поиск студента
    Student findStudent(long id);

    //Редактирование студента
    Student editStudent(Student student);

    //Удаление студента
    Student deleteStudent(long id);

    //Вывод всех студентов
    Collection<Student> getAllStudents();

    //Поиск студентов по возрасту
    List<Student> studentsPureAge(int age);
}
