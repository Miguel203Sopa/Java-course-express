
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.print.attribute.standard.Severity;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        var usuario = request.getParameter("usuario");
        var password = request.getParameter("password");

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()){

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<body>");
            out.println("<h1> Servlet at "+request.getContextPath()+"</h1>");
            out.println("<h2>Parametros recibidos</h2>");
            out.println("<p>El Valor del parametro de usuario es: "+usuario+" </p>");
            out.println("<p>El valor del parametro de password es: " +password+"  </p>");

            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
            processRequest(request,response);
    }



}
