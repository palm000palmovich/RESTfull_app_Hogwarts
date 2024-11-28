package ru.hogwarts.school.services;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.*;

@Service
public class FacultyServiceImpl implements FacultyService {
    private Map<Long, Faculty> facultets = new HashMap<>();
    private long lastId = 0;

    //Создание - добавление факультетов
    @Override
    public Faculty createFaculty(Faculty faculty){
        faculty.setId(++lastId);
        facultets.put(faculty.getId(), faculty);
        return faculty;
    }

    //Поиск факультета
    @Override
    public Faculty findFaculty(long id){
        if (!facultets.containsKey(id)){return null;}
        return facultets.get(id);
    }

    //Редактирование факультета
    @Override
    public Faculty editFaculty(Faculty faculty){
        if (facultets.containsKey(faculty.getId())){
            facultets.put(faculty.getId(), faculty);
            return faculty;
        }
        return null;
    }

    //Удаление факультета
    @Override
    public Faculty deleteFaculty(long id){
        if (facultets.containsKey(id)){return facultets.remove(id);}
        return null;
    }

    //Вывод всех факультетов
    @Override
    public Collection<Faculty> getAllFacultys(){
        if (facultets == null){return null;} return facultets.values();
    }

    //Вывод факультетов по цвету
    @Override
    public List<Faculty> facultetsPureColor(String color){
        if (facultets == null){return null;}
        List<Faculty> facultetsColorsList = new ArrayList<>();
        for (final Faculty faculty : facultets.values()){
            if (faculty.getColor().equals(color)){facultetsColorsList.add(faculty);}
        }
        return facultetsColorsList;
    }

}
