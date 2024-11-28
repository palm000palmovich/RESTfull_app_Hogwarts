package ru.hogwarts.school.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.services.StudentService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path = "/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    //GET
    @GetMapping("/{id}/find")
    public ResponseEntity<Student> getStudentInfo(
                                @PathVariable("id") long id){
        Student stud = studentService.findStudent(id);
        if (stud == null){return ResponseEntity.notFound().build();}
        return ResponseEntity.ok(stud);
    }

    //POST
    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    //PUT
    @PutMapping
    public ResponseEntity<Student> editStudents(
            @RequestBody Student student){
        Student stud = studentService.editStudent(student);
        if (stud == null){return ResponseEntity.notFound().build();}
        return ResponseEntity.ok(stud);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(
            @PathVariable("id") Long id){
        Student stud = studentService.deleteStudent(id);
        if (stud == null){return ResponseEntity.notFound().build();}
        return ResponseEntity.ok(stud);
    }

    //Вывод всех студентов
    @GetMapping
    public Collection<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    //Вывод студентов по возрасту
    @GetMapping("/{age}/age")
    public List<Student> studsInAge(@PathVariable("age") int age){
        return studentService.studentsPureAge(age);
    }
}