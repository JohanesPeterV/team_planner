package com.mobile_prog.team_planner;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile_prog.team_planner.adapters.TeamAdapter;
import com.mobile_prog.team_planner.models.Team;
import com.mobile_prog.team_planner.repositories.TeamRepository;
import com.mobile_prog.team_planner.repositories.UserRepository;

import java.util.ArrayList;

public class TeamFragment extends Fragment {

    private RecyclerView recyclerView;
    private TeamAdapter adapter;
    private ArrayList<Team> teamArrayList;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState);
        View root = inflater.inflate(R.layout.fragment_team, container, false);

        teamArrayList = TeamRepository.getTeams(UserRepository.getCurrentUser());
        recyclerView = (RecyclerView) root.findViewById(R.id.team_recycler_view);

        adapter = new TeamAdapter(teamArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(TeamFragment.this.getContext());

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);



        return root;
    }

}
