package data.web;

import data.domain.Parent;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name ="/PDServ")
public class ParentDetServ extends HttpServlet {

    @EJB
    private Parent pa;


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");

        var opcion = request.getParameter("opcionPD");

        if(opcion.equals("1") ){

        }




        try (PrintWriter out = response.getWriter()) {


        }
    }

}
