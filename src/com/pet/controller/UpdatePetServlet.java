package com.pet.controller;

import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

public class UpdatePetServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String type = req.getParameter("type");
        String age = req.getParameter("age");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/petdb","root","jagath");

            PreparedStatement ps = con.prepareStatement(
                    "UPDATE pets SET name=?, type=?, age=? WHERE id=?");
            ps.setString(1, name);
            ps.setString(2, type);
            ps.setInt(3, Integer.parseInt(age));
            ps.setInt(4, Integer.parseInt(id));
            ps.executeUpdate();

            out.println("<h3>Pet Updated Successfully!</h3>");
            out.println("<a href='viewPets'>Back to list</a>");

        } catch(Exception e) {
            out.println("Error: "+e.getMessage());
        }
    }
}
