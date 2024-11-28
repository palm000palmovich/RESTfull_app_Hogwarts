package ru.hogwarts.school.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.services.FacultyService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path = "/facullty")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;

    //GET
    @GetMapping("/{id}/find")
    public ResponseEntity<Faculty> findFaculty(@PathVariable("id") long id){
        Faculty foundFaculty = facultyService.findFaculty(id);
        if (foundFaculty == null){return ResponseEntity.notFound().build();}
        return ResponseEntity.ok(foundFaculty);
    }

    //POST
    @PostMapping
    public Faculty createFaculty(
            @RequestBody Faculty faculty){return facultyService.createFaculty(faculty);}

    //PUT
    @PutMapping
    public ResponseEntity<Faculty> editFaculty(
            @RequestBody Faculty faculty){
        Faculty editedFaculty = facultyService.editFaculty(faculty);
        if (editedFaculty == null){return ResponseEntity.notFound().build();}
        return ResponseEntity.ok(editedFaculty);
    }

    //DELETE
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Faculty> deleteFaculty(
            @PathVariable("id") long id){
        Faculty deletedFaculty = facultyService.deleteFaculty(id);
        if (deletedFaculty == null){return ResponseEntity.notFound().build();}
        return ResponseEntity.ok(deletedFaculty);
    }

    @GetMapping
    public Collection<Faculty> allFacultets(){
        return facultyService.getAllFacultys();
    }

    @GetMapping("{color}/color")
    public ResponseEntity<List<Faculty>> facultetWithColor(
            @PathVariable("color") String color){
        List<Faculty> facInCol = facultyService.facultetsPureColor(color);
        if (facInCol == null){return ResponseEntity.notFound().build();}
        return ResponseEntity.ok(facInCol);
    }
}
