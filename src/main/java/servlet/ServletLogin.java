package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@WebServlet("/servlet-login")
public class ServletLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        String emailDB = "fakenaty@gmail.com", passwordDB = "cbum123";  //aqui tem que ter a verificação com os dados do DB

        try {
            PrintWriter pw = resp.getWriter();
            if (email.equals(emailDB) && password.equals(passwordDB)) {
                pw.println("<html><body>Usuario conectado</body></html>");
                getServletContext().getRequestDispatcher("/html/perfil.html").forward(req, resp);
            } else {
                pw.println("<html><body>Email ou Senha incorretos</body></html>");
                getServletContext().getRequestDispatcher("/index.html").forward(req, resp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
  
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

    }
}