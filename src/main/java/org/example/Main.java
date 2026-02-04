package org.example;

import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        PersonDAO personDAO = new PersonDAO();
        List<Person> list = personDAO.getPersonByNameAndAge("a", 28);
        for(Person p : list) {
            p.sayHello();
        }

  }
}