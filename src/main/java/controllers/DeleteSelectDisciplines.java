package controllers;

import db.DBManager;
import entiny.Discepline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeleteSelectDisciplines", urlPatterns ="/deleteSelectDiscipline")
public class DeleteSelectDisciplines extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBManager manager = new DBManager();
        String[]ids = new String[]{"2","4"};// заглушка для проверки метода
        manager.deleteDisceplines(ids);
        List<Discepline> disceplines1 = manager.getAllActiveDisceplines();
        req.setAttribute("disciplines",disceplines1);
        req.getRequestDispatcher("WEB-INF/disceplines.jsp").forward(req,resp);
    }
}
