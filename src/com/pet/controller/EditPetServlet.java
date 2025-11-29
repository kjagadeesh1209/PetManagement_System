package com.pet.controller;

import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

public class EditPetServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");   // URL -> /editPet?id=1

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/petdb", "root", "jagath"
            );

            PreparedStatement ps = con.prepareStatement("SELECT * FROM pets WHERE id=?");
            ps.setInt(1, Integer.parseInt(id));
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                out.println("<h2>Edit Pet Details</h2>");

                out.println("<form action='updatePet' method='post'>");

                out.println("<input type='hidden' name='id' value='" + rs.getInt("id") + "'><br>");

                out.println("Name: <input type='text' name='name' value='" + rs.getString("name") + "'><br><br>");
                out.println("Type: <input type='text' name='type' value='" + rs.getString("type") + "'><br><br>");
                out.println("Age: <input type='number' name='age' value='" + rs.getInt("age") + "'><br><br>");

                out.println("<button type='submit'>Update</button>");
                out.println("</form>");
            } else {
                out.println("<h3>No Pet Found</h3>");
            }

        } catch (Exception e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }
    }
}
