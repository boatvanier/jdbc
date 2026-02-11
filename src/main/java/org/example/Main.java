package org.example;

import org.example.dao.JobDAO;
import org.example.model.Job;
import org.example.model.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        //get person
//        PersonDAO personDAO = new PersonDAO();
//        List<Person> list = personDAO.getPersonByNameAndAge("a", 28);
//        for(Person p : list) {
//            p.sayHello();
//        }


        // create valid person list
//        List<String> csvList =  new ArrayList<>();
//        csvList.add("wang, 50, wang@email.com");
//        csvList.add(", 50, wang1@email.com");
//        csvList.add("test, 51, wang2@email.com");
//
//        List<Person>  personList = new ArrayList<>();
//        for (String line: csvList) {
//            Person.create(line.split(",")[0],
//                    Integer.parseInt(line.split(",")[1].trim()),
//                    line.split(",")[2] ).ifPresent(personList::add);
//        }
//
//        System.out.println(personList);

//        JobDAO jobDAO = new JobDAO();
//        Person p = Person.create("test", 55, "test@email.com").get();
//        Job j = new Job();
//        j.setTitle("dev");
//        j.setSalary(8000.00);
//        jobDAO.addPersonAndJob(p, j);

    }
}