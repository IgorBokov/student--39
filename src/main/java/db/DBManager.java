package db;

import entiny.Discepline;
import entiny.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DBManager implements IDBManager {

    @Override
    public List<Student> getAllActiveStudents() {

        ArrayList<Student> students = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // подключили драйвер jdbc
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_39?user = root&password = 324980");
            Statement stmt = con.createStatement();  // создали пустой запрос
            ResultSet rs = stmt.executeQuery("SELECT * FROM student WHERE status = 1");

            while (rs.next()) {
                Student studentNew = new Student();
                readingStudentFieldsFromDB(rs, studentNew);
                students.add(studentNew);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    private void readingStudentFieldsFromDB(ResultSet rs, Student student) throws SQLException {
        student.setId(rs.getInt("id"));
        student.setSurname(rs.getString("surname"));
        student.setName(rs.getString("name"));
        student.setGroup(rs.getString("group"));
        student.setDate(rs.getDate("date"));
        student.setStatus(1);
    }

    @Override
    public void deleteStudent(String[] ids) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // подключили драйвер jdbc
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_39?user" + " = root&password = 324980");
            Statement stmt = con.createStatement();  // создали пустой запрос
            for (String delStudent : ids)
                stmt.executeUpdate("UPDATE `students_39`.`student` SET `status` = '0' WHERE id = ('" + delStudent + "');");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Student getStudentById(String id) {

        Student student = new Student();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // подключили драйвер jdbc
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_39?user" + " = root&password = 324980");
            Statement stmt = con.createStatement();  // создали пустой запрос
            ResultSet rs = stmt.executeQuery("SELECT * FROM student WHERE id = '" + id + "'");
            while (rs.next()) {
                readingStudentFieldsFromDB(rs, student);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return student;
    }

    @Override
    public List<Discepline> getAllActiveDisceplines() {
        ArrayList<Discepline> disceplines = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // подключили драйвер jdbc
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_39?user" + " = root&password = 324980");
            Statement stmt = con.createStatement();  // создали пустой запрос
            ResultSet rs = stmt.executeQuery("SELECT * FROM discipline WHERE status = '1'");
            while (rs.next()) {
                Discepline discepline = new Discepline();
                discepline.setId(rs.getInt("id")); //"id" - это название из таблицы базы данных
                discepline.setDiscepline(rs.getString("discipline"));//"discipline" - это название из таблицы базы данных
                disceplines.add(discepline);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return disceplines;
    }

    @Override
    public void deleteDisceplines(String[] ids) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // подключили драйвер jdbc
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_39?user" + " = root&password = 324980");
            Statement stmt = con.createStatement();  // создали пустой запрос
            for (String delDiscipline : ids)
                stmt.executeUpdate("UPDATE `students_39`.`discipline` SET `status` = '0' WHERE id = '" + delDiscipline + "';");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Discepline getDicseplineById(String id) {

        Discepline discepline = new Discepline();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // подключили драйвер jdbc
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_39?user" + " = root&password = 324980");
            Statement stmt = con.createStatement();  // создали пустой запрос
            ResultSet rs = stmt.executeQuery("SELECT * FROM discipline WHERE id = '" + id + "'");
            while (rs.next()) {
                discepline.setId(rs.getInt("id"));
                discepline.setDiscepline(rs.getString("discipline"));
                discepline.setStatus(rs.getInt("status"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return discepline;
    }

    @Override
    public void modifyDiscipline(String id, String newDiscepline) {
        {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver"); // подключили драйвер jdbc
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_39?user" + " = root&password = 324980");
                Statement stmt = con.createStatement();  // создали пустой запрос
                stmt.executeUpdate("UPDATE students_39.discipline SET discipline = '" + newDiscepline + "' WHERE id = '" + id + "'");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void createStudent(String surname, String name, String group, String date) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // подключили драйвер jdbc
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_39?user = root&password = 324980");
            Statement stmt = con.createStatement();  // создали пустой запрос
            stmt.execute("INSERT INTO `student` (`surname`, `name`, `group`, `date`) VALUES ('" + surname + "', '" + name + "', '" + group + "', '" + date + "');");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}