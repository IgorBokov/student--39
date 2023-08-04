package db;

import entiny.Student;
import java.util.List;

public interface IDBManager {
    List<Student> getAllActiveStudents(); // запросить список студентов
    void deleteStudent(String[] ids);
    Student getStudentById(String id); // вывести данные студента по id

}
