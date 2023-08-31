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

@WebServlet(name="ModifyDiscipline", urlPatterns = "/modifySelectDiscipline")
public class ModifyDiscipline extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBManager manager = new DBManager();
        String id = "1";
        String newDisc = "RadioIndustry";
        manager.modifyDiscipline(id,newDisc);
        List<Discepline> disceplines1 = manager.getAllActiveDisceplines();
        req.setAttribute("disciplines",disceplines1);
        req.getRequestDispatcher("WEB-INF/disceplines.jsp").forward(req,resp);
    }
}
