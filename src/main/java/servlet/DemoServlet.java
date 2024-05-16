package servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DemoServlet extends GenericServlet{
    public void service(ServletRequest req, ServletResponse res) throws IOException, ServletException{
        String name = req.getParameter("username");
        PrintWriter pw = res.getWriter();
        pw.println("<html><body>");
        pw.println("<h1>Welcome " + name + "</h1>");
        pw.println("</html></body>");
    }
}
