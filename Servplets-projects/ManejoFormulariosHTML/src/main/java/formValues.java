import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/formValues")
public class formValues extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //validacion de parametros/campos
        var usuario= request.getParameter("usuario");
        var password =request.getParameter("password");
        String tecnologias[] =request.getParameterValues("tecnologia");
        var genero =request.getParameter("genero");

        var ocupacion = request.getParameter("ocupacion");
        var comentarios = request.getParameter("comentarios");
        var valorOculto=request.getParameter("oculto");


        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()){

            out.println("<!DOCTYPE html>");
            out.println("<html data-bs-theme='dark'>");

            out.println("<head>");
            out.println("<title>Servlet operanteeeeeeee</title>");
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB\" crossorigin=\"anonymous\">");

            out.println("</head>");
            out.println("<body class='container mt-5'>");
            out.println("<h1 class='mb-4 text-center text-warning'> parametros procesados por el server "+request.getContextPath()+"</h1>");
            out.println("<table class='table table-bordered' table-striped'>");
            out.println("<tr><th>Usuario</th><td>"+usuario+"</td></tr>");
            out.println("<tr><th>Contraseña</th><td>"+password+"</td></tr>");
            out.println("<tr><th>Tecnologias</th><td>");
            if(tecnologias !=null){
                out.println(String.join("/",tecnologias));
            }else{
                out.println("Tecnologias no proporcionadas");

            }
            out.println("</td></tr>");


            out.println("<tr><th>Genero</th><td>"+genero+"</td></tr>");
            out.println("<tr><th>Ocupacion</th><td>"+ocupacion+"</td></tr>");
            out.println("<tr><th>Comentarios</th><td>"+comentarios+"</td></tr>");
            out.println("<tr><th>valor oculto</th><td>"+valorOculto+"</td></tr>");
            out.println("");
            out.println("<p>El Valor del parametro de usuario es: "+usuario+" </p>");
            out.println("<p>El valor del parametro de password es: " +password+"  </p>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI\" crossorigin=\"anonymous\"></script>");
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
