package com.mobile_prog.team_planner.models;

import java.util.ArrayList;

public class User {

    private String name;
    private String email;
    private ArrayList<Team> teamArrayList;

    public User(String name, String email, ArrayList<Team> teamArrayList) {
        this.name = name;
        this.email = email;
        this.teamArrayList = teamArrayList;
    }
    public void joinTeam(Team team){
        if(!teamArrayList.contains(team)) teamArrayList.add(team);
    }
    public User(String name, String email) {
        this.name = name;
        this.email = email;

        this.teamArrayList = new ArrayList<Team>();
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
