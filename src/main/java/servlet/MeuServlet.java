package servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@WebServlet("/servlet")
public class MeuServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    String email = req.getParameter("email");
    String password = req.getParameter("password");

    if ("vinihp13@gmail.com".equals(email) && "vini123".equals(password)) {
      getServletContext().getRequestDispatcher("/html/perfil.html").forward(req, resp);
    } else {
      getServletContext().getRequestDispatcher("/index.html").forward(req, resp);
    }
  }
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

  }
}