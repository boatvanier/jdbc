package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {
    private static final String GET_ALL_SQL = "SELECT id, name, age, email FROM person";
    private static final String INSERT_PERSON_SQL =
            "insert into person(name, age, email) values (?, ? ,?)";

    public Person addPerson(Person person) throws SQLException {
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement ps =
                    connection.prepareStatement(INSERT_PERSON_SQL, Statement.RETURN_GENERATED_KEYS)
                ){
            ps.setString(1, person.getName());
            ps.setInt(2, person.getAge());
            ps.setString(3, person.getEmail());

            ps.executeUpdate();

            try(ResultSet rs = ps.getGeneratedKeys()) {
                if(rs.next()) {
                    person.setId(rs.getInt(1));
                    return person;
                } else {
                    throw new SQLException("Failed to get the person ID");
                }
            }
        }
    }

    public void batchInsertPerson(List<Person> personList) throws SQLException {
        try(Connection connection = DBUtil.getConnection();
         PreparedStatement ps = connection.prepareStatement(INSERT_PERSON_SQL)){
            connection.setAutoCommit(false);

            for (Person p : personList) {
                ps.setString(1, p.getName());
                ps.setInt(2, p.getAge());
                ps.setString(3, p.getEmail());
                ps.addBatch();
            }

            ps.executeBatch();
            connection.commit();
        }
    }

    public List<Person> getAllPerson() {
        List<Person> list = new ArrayList<>();

        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(GET_ALL_SQL);
                    ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                Person person = Person.fromDb(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("email"));
                list.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Person> getPersonByNameAndAge(String name, int age) {
        String sql = "SELECT id, name, age FROM person where name like ? and age = ?";
        List<Person> list = new ArrayList<>();
        // try-with-resources
        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, "%" + name + "%");
            ps.setInt(2, age);

            try(
                    ResultSet rs = ps.executeQuery()
            ){
                while (rs.next()) {
//                    System.out.println(
//                            rs.getInt("id")
//                                    + " " + rs.getString("name")
//                                    + " " + rs.getInt("age")
//                    );
                    Person person = Person.fromDb(rs.getInt("id"),
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
