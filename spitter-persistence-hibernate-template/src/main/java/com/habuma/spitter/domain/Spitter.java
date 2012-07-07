package com.habuma.spitter.domain;

import java.util.List;

public class Spitter implements Persistent {
    private Long id;
    private String username;
    private String password;
    private String fullName;
    private String email;
    private boolean updateByEmail;
    private List<Spittle> spittles;


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isUpdateByEmail() {
        return updateByEmail;
    }

    public void setUpdateByEmail(boolean updateByEmail) {
        this.updateByEmail = updateByEmail;
    }

    public List<Spittle> getSpittles() {
        return spittles;
    }

    public void setSpittles(List<Spittle> spittles) {
        this.spittles = spittles;
    }

    @Override
    public String toString() {
        return "Spitter{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", updateByEmail=" + updateByEmail +
                ", spittles=" + spittles +
                '}';
    }
}
