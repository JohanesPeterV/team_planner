package com.mobile_prog.team_planner.repositories;

import com.mobile_prog.team_planner.models.Team;
import com.mobile_prog.team_planner.models.ToDo;
import com.mobile_prog.team_planner.models.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class TeamRepository {
    private static ArrayList<Team> teamArrayList=new ArrayList<Team>();
    public static ArrayList<Team> getTeams(User user){
        ArrayList<Team> temp=new ArrayList<Team>();
        for (Team team: teamArrayList) {
            if(user.getTeamArrayList().contains(team)){
                temp.add(team);
            }
        }
        return temp;
    }

    public static Team createTeam(String name, String description, String password){
        Team team=new Team(name, description, new Date(), password);
        teamArrayList.add(team);
        return team;
    }

    public static boolean joinTeam(User user, String name, String password){
        for (Team team: teamArrayList) {
            if(team.getName().equals(name)&&team.validatePassword(password)){
                user.joinTeam(team);
                return true;
            }
        }
        return false;
    }


}
