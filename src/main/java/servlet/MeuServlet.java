package servlet;
import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/meu-servlet")
public class MeuServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    if (req.getParameter("username") == "ademiro") {
      req.getRequestDispatcher("html/tela_principal.html").forward(req, resp);
    }else req.getRequestDispatcher("index.html").forward(req, resp);
  }
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

  }
}