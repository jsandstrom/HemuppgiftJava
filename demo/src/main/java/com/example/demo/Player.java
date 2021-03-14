package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String namn;
    private int age;
    private int jersey;
    private String born;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNamn() {
        return namn;
    }
    public void setNamn(String namn) {
        this.namn = namn;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getJersey() {
        return jersey;
    }
    public void setJersey(int jersey) {
        this.jersey = jersey;
    }
    public String getBorn() {
        return born;
    }
    public void setBorn(String born) {
        this.born = born;
    }    
}