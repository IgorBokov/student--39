package db;

import entiny.Discepline;
import entiny.Mark;
import entiny.Student;
import entiny.Term;

import java.util.List;

public interface IDBManager {
    List<Student> getAllActiveStudents(); // запросить список студентов

    void deleteStudent(String[] ids); // удалить студента

    Student getStudentById(String id); // вывести данные студента по id

    List<Discepline> getAllActiveDisceplines();

    void deleteDisceplines(String[] ids);

    Discepline getDicseplineById(String id);

    void modifyDiscipline(String id, String newDiscepline);

    void createStudent(String surname, String name, String group, String date);

    void modifyStudent(String id, String surname, String name, String group, String date);

    List<Term> getAllActiveTerm();
    List<Mark> getMarksByStudent(String idStudent, String idTerm);
}
