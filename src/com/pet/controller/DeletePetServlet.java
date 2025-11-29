package com.pet.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

public class DeletePetServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/petdb","root","jagath");

            PreparedStatement ps = con.prepareStatement("DELETE FROM pets WHERE id=?");
            ps.setInt(1, Integer.parseInt(id));
            ps.executeUpdate();

            out.println("<h3>Pet Deleted Successfully!</h3>");
            out.println("<a href='viewPets'>Go back to list</a>");

        } catch(Exception e){
            out.println("Error: "+e.getMessage());
        }
    }
}
