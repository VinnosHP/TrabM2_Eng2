package servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@WebServlet("/servlet")
public class MeuServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    getServletContext().getContextPath();
    getServletContext().getRequestDispatcher("html/perfil.html");
  }
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

  }
}