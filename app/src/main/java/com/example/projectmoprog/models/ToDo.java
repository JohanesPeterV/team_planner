package com.example.projectmoprog.models;

import java.util.Date;

public class ToDo {
    private String title;
    private String description;
    private int priority;
    private String occupier;
    private Date startTime;
    private Date endTime;

    public ToDo(String title, String description, int priority, String occupier, Date startTime, Date endTime) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.occupier = occupier;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getOccupier() {
        return occupier;
    }

    public void setOccupier(String occupier) {
        this.occupier = occupier;
    }


}
