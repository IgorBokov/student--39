package controllers;

import db.DBManager;
import entiny.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeleteSelectStudents", urlPatterns = "/deleteSelectStudents")
public class DeleteSelectStudents extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBManager dbManager = new DBManager();
        String[]ids = new String[]{"2","4"};// заглушка для проверки метода
        dbManager.deleteStudent(ids);
        List<Student> students = dbManager.getAllActiveStudents();
        req.setAttribute("students", students);
        req.getRequestDispatcher("WEB-INF/students.jsp").forward(req, resp);
    }
}
