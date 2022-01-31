package com.mobile_prog.team_planner.repositories;

import android.util.Log;

import com.mobile_prog.team_planner.models.Team;
import com.mobile_prog.team_planner.models.ToDo;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ToDoRepository {
    public static void addToDo(Team team, ToDo toDo){
        team.addToDo(toDo);
    }
    public static ArrayList<ToDo> getUserToDo(){
        ArrayList<ToDo> toDoContainer=new ArrayList<ToDo>();
        ArrayList<Team> teamList=UserRepository.getCurrentUser().getTeamArrayList();
        for (Team team:teamList
        ) {
            ArrayList<ToDo> toDoList=team.getToDoArrayList();
            toDoContainer.addAll(toDoList);
        }
        return toDoContainer;
    }
}
