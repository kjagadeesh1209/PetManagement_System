package com.pet.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.JSONArray;
import org.json.JSONObject;   //  <<< Required for JSON

public class ViewPetsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("application/json");  // returning JSON
        PrintWriter out = resp.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/petdb", "root", "jagath"
            );

            PreparedStatement ps = con.prepareStatement("SELECT * FROM pets");
            ResultSet rs = ps.executeQuery();

            JSONArray arr = new JSONArray();  // JSON array

            while (rs.next()) {
                JSONObject obj = new JSONObject();
                obj.put("id", rs.getInt("id"));
                obj.put("name", rs.getString("name"));
                obj.put("type", rs.getString("type"));
                obj.put("age", rs.getInt("age"));

                arr.put(obj);   // add to array
            }

            out.print(arr.toString());  // send JSON to frontend
        }
        catch (Exception e) {
            out.print("{\"error\":\""+e.getMessage()+"\"}");
        }
    }
}
