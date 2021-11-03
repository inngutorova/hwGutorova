package com.example.demo;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class User {
    public String name;
    public int age;
    public ArrayList<Comment> comments;
    public User(String name, int age){
        this.name=name;
        this.age=age;
    }
    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }
    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }
    @Override
    public String toString() {
        return "User{" + "name=" + name + ", age='" + age + '\'' + '}';
    }
}
