package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by rahul.pant on 27/12/17.
 */
@WebServlet(name = "Hello IOT", urlPatterns = "/")
public class HelloIOT extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.getWriter().write("Hello, Rahul!");
        System.out.println("Completed");
    }
}
