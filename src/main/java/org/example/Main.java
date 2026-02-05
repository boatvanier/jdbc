package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        PersonDAO personDAO = new PersonDAO();
//        List<Person> list = personDAO.getPersonByNameAndAge("a", 28);
//        for(Person p : list) {
//            p.sayHello();
//        }


        List<String> csvList =  new ArrayList<>();
        csvList.add("wang, 50, wang@email.com");
        csvList.add(", 50, wang1@email.com");
        csvList.add("test, 51, wang2@email.com");

        List<Person>  personList = new ArrayList<>();
        for (String line: csvList) {
            Person.create(line.split(",")[0],
                    Integer.parseInt(line.split(",")[1].trim()),
                    line.split(",")[2] ).ifPresent(personList::add);
        }

        System.out.println(personList);
  }
}