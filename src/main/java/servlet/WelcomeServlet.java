package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();
        writer.append("<!DOCTYPE html>\r\n")
                .append("<html>\r\n")
                .append("<head>\r\n")
                .append("<title>Form input</title>\r\n")
                .append("</head>\r\n")
                .append("<body>\r\n")
                .append("<form action=\"validate-user\" method=\"POST\">\r\n")
                .append("Enter your login: \r\n")
                .append("<input type=\"text\" name=\"login\" />\r\n")
                .append("Enter your password: \r\n")
                .append("<input type=\"text\" name=\"password\" />\r\n")
                .append("<input type=\"submit\" value=\"Log\" />\r\n")
                .append("</form>\r\n")
                .append("</body>\r\n")
                .append("</html>\r\n");
        writer.close();
    }
}
