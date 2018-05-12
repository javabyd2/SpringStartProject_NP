package com.sda.spring.demo.model;

import java.util.List;

public class Person {

    private String name;
    private String lastName;
    private int age;
    private boolean isAlive;
    private List<String> children;

    public Person(String name, String lastName, int age, boolean isAlive, List<String> children) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.isAlive = isAlive;
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public List<String> getChildren() {
        return children;
    }

    public void setChildren(List<String> children) {
        this.children = children;
    }
}
