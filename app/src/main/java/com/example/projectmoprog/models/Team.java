package com.example.projectmoprog.models;

import java.util.ArrayList;
import java.util.Date;

public class Team {

    private String name;
    private String description;
    private Date dateOfCreation;
    private ArrayList<ToDo> toDoArrayList;

    public Team(String name, String description, Date dateOfCreation, ArrayList<ToDo> toDoArrayList) {
        this.name = name;
        this.description = description;
        this.dateOfCreation = dateOfCreation;
        this.toDoArrayList = toDoArrayList;
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

    public void setToDoArrayList(ArrayList<ToDo> toDoArrayList) {
        this.toDoArrayList = toDoArrayList;
    }


}
