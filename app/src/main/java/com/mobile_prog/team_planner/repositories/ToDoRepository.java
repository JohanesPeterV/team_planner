package com.mobile_prog.team_planner.repositories;

import com.mobile_prog.team_planner.models.Team;
import com.mobile_prog.team_planner.models.ToDo;

public class ToDoRepository {
    public static void addToDo(Team team, ToDo toDo){
        team.addToDo(toDo);
    }
}
