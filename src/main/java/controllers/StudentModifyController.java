package controllers;

import db.DBManager;
import entiny.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentModifyController",urlPatterns = "/student-modify")
public class StudentModifyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("hiddenModify");          //поле -> name="hiddenModify из students.jsp"
        DBManager manager = new DBManager();
        Student student = manager.getStudentById(id);
        req.setAttribute("student", student);
        req.getRequestDispatcher("WEB-INF/student-modify.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String surname = req.getParameter("surname");
        String name = req.getParameter("name");
        String group = req.getParameter("group");
        String date = req.getParameter("date");

        DBManager manager = new DBManager();
        manager.modifyStudent(id, surname, name, group,date);
        resp.sendRedirect("/students");
    }
}
