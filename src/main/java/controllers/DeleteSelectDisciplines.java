package controllers;

import db.DBManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteSelectDisciplines", urlPatterns ="/deleteSelectDiscipline")
public class DeleteSelectDisciplines extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        DBManager manager = new DBManager();
        String hiddenDelete = req.getParameter("typeNameDeleteDiscipline");
        String[]ids = hiddenDelete.split(" ");
        manager.deleteDisceplines(ids);
        resp.sendRedirect("/terms");
    }
}
