package controllers;

import db.DBManager;
import entiny.Mark;
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
        req.setAttribute("terms", terms);
        String selectedTermId = req.getParameter("selectedTermId");
        if (selectedTermId != null) {
            req.setAttribute("selected", selectedTermId);
        } else {
            selectedTermId = terms.get(0).getId() + "";
            req.setAttribute("selected", terms.get(0).getId() + "");
        }
        List<Mark>marks = manager.getMarksByStudent(idStudent,selectedTermId);
        req.setAttribute("marks", marks);
        req.getRequestDispatcher("WEB-INF/student-progress.jsp").forward(req, resp);
    }
}
