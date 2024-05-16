package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String parameterA = request.getParameter("a");
        response.getWriter().println("Servlet Multiplicacao-writter");
        response.getWriter().println("<br />");
        response.getWriter().println("a=" + parameterA);
        response.getWriter().close();
    }
}
