package com.mobile_prog.team_planner.repositories;

import com.mobile_prog.team_planner.models.Team;
import com.mobile_prog.team_planner.models.ToDo;
import com.mobile_prog.team_planner.models.User;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class UserRepository {
    private static User currentUser=null;
    private static ArrayList<User> userList=new ArrayList<User>();
    public static User getCurrentUser(){
        return currentUser;
    }
    public static void login(User user){
        if(userList.size()==0){
            //init dummy data for first user
            Team team1=TeamRepository.createTeam("SuperTeam","A team consisting of super fast people","super123");
            team1.addToDo(new ToDo("Make api","Make an api for our super fast team",1, null, new GregorianCalendar(2022, Calendar.JANUARY, 11).getTime()));
            team1.addToDo(new ToDo("Make front end","Make front end so that we can use the api via interface",2, null, new GregorianCalendar(2022, Calendar.JANUARY, 18).getTime()));
            Team team2=TeamRepository.createTeam("PowerTeam","A team consisting of powerful people","power123");
            team2.addToDo(new ToDo("Todo 1","Todo description 1",1, null, new GregorianCalendar(2022, Calendar.JANUARY, 1).getTime()));
            team2.addToDo(new ToDo("Todo 2","Todo description 2",2, null, new GregorianCalendar(2022, Calendar.JANUARY, 2).getTime()));
            team2.addToDo(new ToDo("Todo 3","Todo description 3",3, null, new GregorianCalendar(2022, Calendar.JANUARY, 3).getTime()));
            team2.addToDo(new ToDo("Todo 4","Todo description 4",4, null, new GregorianCalendar(2022, Calendar.JANUARY, 4).getTime()));
            team2.addToDo(new ToDo("Todo 5","Todo description 5",5, null, new GregorianCalendar(2022, Calendar.JANUARY, 5).getTime()));
            team2.addToDo(new ToDo("Todo 6","Todo description 6",6, null, new GregorianCalendar(2022, Calendar.JANUARY, 6).getTime()));
            team2.addToDo(new ToDo("Todo 7","Todo description 7",7, null, new GregorianCalendar(2022, Calendar.JANUARY, 7).getTime()));
            team2.addToDo(new ToDo("Todo 8","Todo description 8",8, null, new GregorianCalendar(2022, Calendar.JANUARY, 8).getTime()));
            team2.addToDo(new ToDo("Todo 9","Todo description 9",9, null, new GregorianCalendar(2022, Calendar.JANUARY, 9).getTime()));
            team2.addToDo(new ToDo("Todo 10","Todo description 10",10, null, new GregorianCalendar(2022, Calendar.JANUARY, 10).getTime()));
            team2.addToDo(new ToDo("Todo 11","Todo description 11",11, null, new GregorianCalendar(2022, Calendar.JANUARY, 11).getTime()));
            team2.addToDo(new ToDo("Todo 12","Todo description 12",12, null, new GregorianCalendar(2022, Calendar.JANUARY, 12).getTime()));
            team2.addToDo(new ToDo("Todo 13","Todo description 13",13, null, new GregorianCalendar(2022, Calendar.JANUARY, 13).getTime()));

            user.joinTeam(team1);
            user.joinTeam(team2);
        }

        userList.add(user);
        currentUser=user;

    }
    public static void register(String name, String email){
        userList.add(new User(name,email));
    }
}
