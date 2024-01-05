package com.example.intelijjdbc;

import java.io.*;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "hellodirec", value = "/hello-direc")
public class direct extends HttpServlet {
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
        String name, number, city, state;
        name = request.getParameter("name");
        number = request.getParameter("num");
        city = request.getParameter("city");
        state = request.getParameter("state");


//                out.println("<h1>Welcome</h1>" + uname + "\n");
//                out.println("<h1>Authentication Successfull</h1>" + "\n");

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping?autoReconnect=true&useSSL=false", "root", "");
                    Statement s = con.createStatement();
                    String s1 = "insert into direc values ('" + name + "','" + number + "','" + city + "','" + state + "');";
                    s.executeUpdate(s1);
                    System.out.println("success");
                    out.println("<h1>Name</h1>" + name + "\n");
                    out.println("<h1>Number</h1>" + number + "\n");
                    out.println("<h1>City</h1>" + city + "\n");
                    out.println("<h1>State</h1>" + state + "\n");

                    out.print("<form action=\"");
                    out.print(response.encodeURL("sname.jsp"));
                    out.print("\" ");
                    out.println("method=POST>");
                    out.println("<input type=submit value=\"Search by Name\">");

                    out.print("<form action=\"");
                    out.print(response.encodeURL("snum.jsp"));
                    out.print("\" ");
                    out.println("method=POST>");
                    out.println("<input type=submit value=\"Search by Number\">");
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    public void destroy() {
    }
}