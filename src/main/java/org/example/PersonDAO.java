package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {

    public void addPerson(Person person){

    }

    public List<Person> getAllPerson() {
        String sql = "SELECT id, name, age FROM person";
        List<Person> list = new ArrayList<>();


        return list;
    }

    public List<Person> getPersonByNameAndAge(String name, int age) {
        String sql = "SELECT id, name, age FROM person where name like ? and age = ?";
        List<Person> list = new ArrayList<>();
        // try-with-resources
        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setString(1, "%" + name + "%");
            ps.setInt(2, age);

            try(
                    ResultSet rs = ps.executeQuery();
            ){
                while (rs.next()) {
//                    System.out.println(
//                            rs.getInt("id")
//                                    + " " + rs.getString("name")
//                                    + " " + rs.getInt("age")
//                    );
                    Person person = new Person(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("age"),
                            rs.getString("email"));
                    list.add(person);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
