package ru.hogwarts.school.services;

import ru.hogwarts.school.model.Faculty;

import java.util.Collection;
import java.util.List;

public interface FacultyService {
    //Создание - добавление факультетов
    Faculty createFaculty(Faculty faculty);

    //Поиск факультета
    Faculty findFaculty(long id);

    //Редактирование факультета
    Faculty editFaculty(Faculty faculty);

    //Удаление факультета
    Faculty deleteFaculty(long id);

    //Вывод всех факультетов
    Collection<Faculty> getAllFacultys();

    //Вывод факультетов по цвету
    List<Faculty> facultetsPureColor(String color);
}
