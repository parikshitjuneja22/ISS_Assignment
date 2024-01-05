package com.example.intelijjdbc;

import java.io.*;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String uname, pass;
        uname = request.getParameter("uname");
        pass = request.getParameter("pwd");

        if (uname.compareTo("admin")==0) {
            if (pass.compareTo("admin123")==0) {
                out.println("<h1>Welcome</h1>" + uname + "\n");
                out.println("<h1>Authentication Successfull</h1>" + "\n");

                try {
                    out.print("<form action=\"");
                    out.print(response.encodeURL("directory.jsp"));
                    out.print("\" ");
                    out.println("method=POST>");
                    out.println("<input type=submit value=\"Directory\">");
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            else {
                out.println("<h1>Authentication Failed</h1>" + "\n");
            }
        } else {
            out.println("<h1>Authentication Failed</h1>" + "\n");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    public void destroy() {
    }
}