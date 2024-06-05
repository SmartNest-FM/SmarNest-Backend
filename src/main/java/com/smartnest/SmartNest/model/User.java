package com.smartnest.SmartNest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String uid;
    private String nametutor;
    private String nameuser;
    private String emailuser;
    private int age;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getuId() {
        return uid;
    }

    public void setuId(String uid) {
        this.uid = uid;
    }

    public String getNameTutor() {
        return nametutor;
    }

    public void setNameTutor(String nametutor) {
        this.nametutor = nametutor;
    }

    public String getNameUser() {
        return nameuser;
    }

    public void setNameUser(String nameuser) {
        this.nameuser = nameuser;
    }

    public String getEmailUser() {
        return emailuser;
    }

    public void setEmailUser(String emailuser) {
        this.emailuser = emailuser;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhotoUser() {
        return photouser;
    }

    public void setPhotoUser(String photouser) {
        this.photouser = photouser;
    }

    private String photouser;


}
