package com.mobile_prog.team_planner.models;

import java.util.ArrayList;
import java.util.Date;

public class Team {

    private String name;
    private String description;
    private Date dateOfCreation;
    private ArrayList<ToDo> toDoArrayList=new ArrayList<ToDo>();
    private String password;
    public void addToDo(ToDo toDo){
        toDoArrayList.add(toDo);
    }
    public void getToDo(int index){
        toDoArrayList.get(index);
    }
    public boolean validatePassword(String password){
        if(this.password.equals(password))return true;
        return false;
    }

    public Team(String name, String description, Date dateOfCreation, String password) {
        this.name = name;
        this.description = description;
        this.dateOfCreation = dateOfCreation;
        this.password=password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public ArrayList<ToDo> getToDoArrayList() {
        return toDoArrayList;
    }



}
