package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        HttpSession session = req.getSession();
        //RequestDispatcher dispatcher = null;
        Connection con = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/teste_trab_eng2", "root", "Vinnoshp15!");
            PreparedStatement pst = con.prepareStatement("select * from usuario where email=? and senha=?");
            pst.setString(1, email);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {

                session.setAttribute("nome", rs.getString("nome"));
                req.getRequestDispatcher("html/perfil.html").forward(req, resp);
            }else{
                req.setAttribute("status", "failed");
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doGet(req, resp);
    }
}
