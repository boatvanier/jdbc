package org.example;

import org.example.lab.UserDao;
import org.example.lab.exception.FileMissingException;
import org.example.lab.FileProcess;
import org.example.lab.exception.UserNotFoundException;

import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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


        //lab exception part 1
        int[] arr = {10, 20, 30};
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter dividend: ");
            int a = sc.nextInt();
            System.out.print("Enter divisor: ");
            int b = sc.nextInt();
            System.out.println("Result: " + (a / b));

            System.out.print("Enter array index to access: ");
            int idx = sc.nextInt();
            System.out.println("Array value: " + arr[idx]);

        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        } finally {
            System.out.println("End of operation");
        }

        //lab exception part 2
        FileProcess fileProcess = new FileProcess();
        try {
            fileProcess.readFile("data.txt");
        } catch (FileMissingException | IOException e) {
            System.out.println(e.getMessage());
        }

        //lab exception part 3
        UserDao userDao = new UserDao();
        int id = 5;
        try {
            String name = userDao.getUserNameById(id);
            if (name != null) {
                System.out.println("User name: " + name);
            } else {
                throw new UserNotFoundException("User ID "+ id +" does not exist.");
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }


    }
}