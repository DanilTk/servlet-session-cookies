package servlet;

import validation.CredentialsValidator;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AuthentiticationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("login");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();

        writer.append("<!DOCTYPE html>\r\n")
                .append("<html>\r\n")
                .append("<head>\r\n")
                .append("<title>Welcome message</title>\r\n")
                .append("</head>\r\n")
                .append("<body>\r\n");
        if (CredentialsValidator.isLoginCorrect(name)) {
            if (CredentialsValidator.isPasswordCorrect(password)) {
                Cookie cookie = new Cookie("username", name);

                writer.append("Welcome " + name + ".\r\n");
                writer.append("Login success.\r\n");

                response.addCookie(cookie);
                response.sendRedirect("login");
            } else {
                writer.append("Incorrect password\n");
            }
        }
        writer.append("</body>\r\n")
                .append("</html>\r\n");
        writer.close();
    }
}
