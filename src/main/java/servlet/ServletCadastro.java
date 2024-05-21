package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet-cadastro")
public class ServletCadastro extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");

        String nameDB = "jorginho", emailDB = "inho123@gmail.com";  //aqui tem que ter a verificação com os dados do DB
        
        try {
            PrintWriter pw = resp.getWriter();
            if (name.equals(nameDB)) {
                pw.println("<html><body>Usuario ja cadastrado</body></html>");
                getServletContext().getRequestDispatcher("/html/cadastro.html").forward(req, resp);
            }else{
                if (email.equals(emailDB)) {
                    pw.println("<html><body>Email ja cadastrado</body></html>");
                    getServletContext().getRequestDispatcher("/html/cadastro.html").forward(req, resp);
                }else getServletContext().getRequestDispatcher("/html/login.html").forward(req, resp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }
}
