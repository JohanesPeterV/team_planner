package com.mobile_prog.team_planner;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile_prog.team_planner.adapters.ToDoAdapter;
import com.mobile_prog.team_planner.repositories.ToDoRepository;

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home,container,false);
        RecyclerView recyclerView=rootView.findViewById(R.id.toDoRecyclerView);
        ToDoAdapter toDoAdapter=new ToDoAdapter(ToDoRepository.getUserToDo());
        recyclerView.setAdapter(toDoAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        return rootView;
    }
}
