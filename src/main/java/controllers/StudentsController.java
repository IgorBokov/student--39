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

@WebServlet(name="StudentsController", urlPatterns = "/students")
public class StudentsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBManager manager = new DBManager();
        List<Student> students1 = manager.getAllActiveStudents();
        req.setAttribute("students", students1);/*Придумали назв., "посылки" - "students"
        она будет отправлена в students.jsp, поле - items="${students}" */
        req.getRequestDispatcher("WEB-INF/students.jsp").forward(req,resp);
    }
}
