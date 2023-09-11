package controllers;

import db.DBManager;
import entiny.Student;
import entiny.Term;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentProgressController", urlPatterns = "/student-progress")
public class StudentProgressController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBManager manager = new DBManager();
        String idStudent = req.getParameter("hiddenProgress"); // name="hiddenProgress"
        Student student = manager.getStudentById(idStudent);
        req.setAttribute("student", student); //передаем на отображение value="${student.id}"
        List<Term> terms = manager.getAllActiveTerm();
        req.getRequestDispatcher("WEB-INF/student-progress.jsp").forward(req,resp);
    }
}
