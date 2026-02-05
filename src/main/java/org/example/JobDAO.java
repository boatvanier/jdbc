package org.example;

import java.sql.*;

public class JobDAO {
    private static final String INSERT_PERSON_SQL =
            "insert into person(name, age, email) values (?, ? ,?)";
    private static final String INSERT_JOB_SQL =
            "insert into job(person_id, title, salary) values (?, ? ,?)";

    public Job addJob(Job job) throws SQLException {
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement ps =
                    connection.prepareStatement(INSERT_JOB_SQL, Statement.RETURN_GENERATED_KEYS)
        ){
            ps.setInt(1, job.getPersonId());
            ps.setString(2, job.getTitle());
            ps.setDouble(3, job.getSalary());

            ps.executeUpdate();

            try(ResultSet rs = ps.getGeneratedKeys()) {
                if(rs.next()) {
                    job.setId(rs.getInt(1));
                    return job;
                } else {
                    throw new SQLException("Failed to get the job ID");
                }
            }
        }
    }

    public void addPersonAndJob(Person person, Job job) {
        try(Connection connection = DBUtil.getConnection();
        PreparedStatement psPerson = connection.prepareStatement(INSERT_PERSON_SQL, Statement.RETURN_GENERATED_KEYS);
        PreparedStatement psJob = connection.prepareStatement(INSERT_JOB_SQL)){

            connection.setAutoCommit(false);

            // insert person
            psPerson.setString(1, person.getName());
            psPerson.setInt(2, person.getAge());
            psPerson.setString(3, person.getEmail());

            psPerson.executeUpdate();

            int personId;
            try(ResultSet rs = psPerson.getGeneratedKeys()) {
                if(rs.next()) {
                    personId = rs.getInt(1);
                } else {
                    throw new SQLException("Failed to get the person ID");
                }
            }

            // insert job
            psJob.setInt(1, personId);
            psJob.setString(2, job.getTitle());
            psJob.setDouble(3, job.getSalary());
            psJob.executeUpdate();

            connection.commit();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
