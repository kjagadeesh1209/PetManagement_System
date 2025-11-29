package com.pet.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

public class PetServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String name = req.getParameter("name");
        String type = req.getParameter("type");
        String age  = req.getParameter("age");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/petdb","root","jagath");

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO pets(name,type,age) VALUES(?,?,?)");

            ps.setString(1, name);
            ps.setString(2, type);
            ps.setInt(3, Integer.parseInt(age));
            ps.executeUpdate();

            resp.sendRedirect("viewPets");

        }
        catch(Exception e){
            out.println("Error : " + e.getMessage());
        }
    }
}
