package com.example.intelijjdbc;

import java.io.*;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "hellosname", value = "/sname")
public class sname extends HttpServlet {
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
        String nname;
        nname = request.getParameter("name");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping?autoReconnect=true&useSSL=false", "root", "");
            Statement s = con.createStatement();
            PreparedStatement statement = con.prepareStatement("select * from direc where name='"+nname+"';");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                out.println(rs.getString(1));
                out.println(rs.getString(2));
                out.println(rs.getString(3));
                out.println(rs.getString(4));
            }
            System.out.println("success");
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