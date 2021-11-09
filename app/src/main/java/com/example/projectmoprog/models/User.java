package com.example.projectmoprog.models;

import java.util.ArrayList;

public class User {

    private String name;
    private String email;
    private ArrayList<Team> teamArrayList;
    private static User currUser;

    public User(String name, String email, ArrayList<Team> teamArrayList) {
        this.name = name;
        this.email = email;
        this.teamArrayList = teamArrayList;
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public static User getCurrUser(){
        return currUser;
    }
    public static void setCurrUser(User currUser){
        User.currUser=currUser;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Team> getTeamArrayList() {
        return teamArrayList;
    }

    public void setTeamArrayList(ArrayList<Team> teamArrayList) {
        this.teamArrayList = teamArrayList;
    }




}
