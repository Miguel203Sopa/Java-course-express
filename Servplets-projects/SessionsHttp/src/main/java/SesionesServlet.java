import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

public class SesionesServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        HttpSession sesion = request.getSession();
        String titulo;
        Integer contadorVistas =(Integer)(sesion.getAttribute("contadorVistas"));

        //validamossss
        if(contadorVistas==null){
            contadorVistas =1;
            titulo="bienvenido";
        }else{
            contadorVistas++;
            titulo="BIENVENIDO DE NUEVO";
        }

        sesion.setAttribute("contadorVistas",contadorVistas);

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()){

            out.println("<!DOCTYPE html>");
            out.println("<html data-bs-theme='dark'>");

            out.println("<head>");
            out.println("<title>Servlet operanteeeeeeee</title>");
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB\" crossorigin=\"anonymous\">");

            out.println("</head>");
            out.println("<body class='container mt-5'>");
            out.println("<h1 class='mb-4 text-center text-warning'> manejo de cookies</h1>");
            out.println("<p>Sesiones HTTP: "+titulo+"</p>");
            out.println("<p>Numero de accesos: "+contadorVistas+"</p>");
            out.println("<p>ID de la sesion: "+sesion.getId()+"</p>");
            out.println("<a href='/SessionsHttp/index.html'>regresa al inicio</a>");
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        processRequest(request,response);
    }
}
