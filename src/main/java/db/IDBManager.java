package db;

import entiny.Discepline;
import entiny.Student;

import java.util.List;

public interface IDBManager {
    List<Student> getAllActiveStudents(); // запросить список студентов

    void deleteStudent(String[] ids); // удалить студента

    Student getStudentById(String id); // вывести данные студента по id

    List<Discepline> getAllActiveDisceplines();

    void deleteDisceplines(String[] ids);

    Discepline getDicseplineById(String id);

    void modifyDiscipline(String id, String newDiscepline);
    void createStudent(String surname,String name,String group,String date);

}
