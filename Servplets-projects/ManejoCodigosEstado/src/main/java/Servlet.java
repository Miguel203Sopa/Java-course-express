import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name="Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Datos
        var usuarioOK="admin";
        var passwordOK ="12345";

        //valores form
        var usuario=request.getParameter("usuario");
        var password=request.getParameter("password");


        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()){

            if( usuarioOK.equals(usuario) && passwordOK.equals(password) ){
                out.println("<!DOCTYPE html>");
                out.println("<html data-bs-theme='dark'>");

                out.println("<head>");
                out.println("<title>Cabeceros</title>");
                out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB\" crossorigin=\"anonymous\">");

                out.println("</head>");
                out.println("<body class='container mt-5'>");
                out.println("<h1 class='mb-4 text-center text-warning'> parametros procesados por el server "+request.getContextPath()+"</h1>");
                out.println("<h1>Servlet Servlet at"+request.getContextPath()+" </h1>");

                out.println("<h1>Autenticacion exitosa </h1>");
                out.println("<h2>Bienvenido "+usuario+"</h2>");



                out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI\" crossorigin=\"anonymous\"></script>");
                out.println("</body>");
                out.println("</html>");
            }else{
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Credenciales incorrectas");
            }


        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        processRequest(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        processRequest(request,response);
    }

}
