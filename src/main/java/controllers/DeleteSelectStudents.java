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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        DBManager dbManager = new DBManager();
        String hiddenDelet = req.getParameter("hiddenDelete");
        String[]ids = hiddenDelet.split(" ");
        dbManager.deleteStudent(ids);
        resp.sendRedirect("/students");
    }
}
