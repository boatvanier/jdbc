package org.example.lab;

import org.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public String getUserNameById(int id) throws SQLException {
        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement("select name from person where id=?")
        ) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("name");
                } else {
                    return null;
                }
            }
        }
    }
}
