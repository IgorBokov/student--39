package controllers;

import db.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="ModifyDiscipline", urlPatterns = "modifySelectDiscipline")
public class ModifyDiscipline extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBManager dbManager = new DBManager();
        String id = "1";
        String newDisc = "RadioIndustry";
        dbManager.modifyDiscipline(id,newDisc);
    }
}
