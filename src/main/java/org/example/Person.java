package org.example;

import java.util.Optional;

public class Person {
    private Integer id;
    private String name;
    private Integer age;
    private String email;

    private Person(Integer id, String name, Integer age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public static Optional<Person> create(String name, Integer age, String email) {
        if (name == null || name.isBlank()) return Optional.empty();
        if (age != null && age < 0) return Optional.empty();

        return Optional.of(new Person(null, name, age, email));
    }

    public static Person fromDb(int id, String name, Integer age, String email) {
        return new Person(id, name, age, email);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void sayHello() {
        System.out.println("Hi, my name is" + name);
    }

    public String toString(){
     return "Person: { id:" + id + ", name: " + name + "}";
    }
}
