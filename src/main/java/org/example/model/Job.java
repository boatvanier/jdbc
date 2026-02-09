package org.example.model;

public class Job {
    private Integer id;
    private int personId;
    private String title;
    private Double salary;

    public Job(){}
    public Job(Integer id, int personId, String title, Double salary) {
        this.id = id;
        this.personId = personId;
        this.title = title;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
