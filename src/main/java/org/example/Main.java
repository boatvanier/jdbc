package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=school;"
                + "encrypt=true;"
                + "trustServerCertificate=true";

        String user = "school_user";
        String password = "Password12345";

        String sql = "SELECT id, name, age FROM person";

        try (
                Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
        ) {
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id")
                        + " " + rs.getString("name")
                        + " " + rs.getInt("age")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
  }
}