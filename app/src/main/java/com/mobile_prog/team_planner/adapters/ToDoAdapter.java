package com.mobile_prog.team_planner.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile_prog.team_planner.R;
import com.mobile_prog.team_planner.models.ToDo;
import com.mobile_prog.team_planner.repositories.UserRepository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ToDoAdapter extends RecyclerView.Adapter{


    private ArrayList<ToDo> toDoList;

    public ToDoAdapter(ArrayList<ToDo> toDoList ){
            this.toDoList=toDoList;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_card_item,parent, false);
        return new RecyclerView.ViewHolder(view) {

        };
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ToDo currToDo = toDoList.get(position);

        TextView title=holder.itemView.findViewById(R.id.toDoTitle);
        TextView startDate=holder.itemView.findViewById(R.id.toDoStartDate);
        TextView description=holder.itemView.findViewById(R.id.toDoDescription);
        TextView priority=holder.itemView.findViewById(R.id.toDoPriority);
        TextView status=holder.itemView.findViewById(R.id.toDoStatus);
        title.setText(currToDo.getTitle());
        startDate.setText(new SimpleDateFormat("yyyy-mm-dd").format(currToDo.getStartTime()));
        description.setText(currToDo.getDescription());
        priority.setText(""+currToDo.getPriority());
        status.setText(currToDo.getStatus());

        Button doButton=holder.itemView.findViewById(R.id.doButton);
        if(currToDo.getStatus().equals(ToDo.notStarted)){
            doButton.setText("Start");
        }else if(currToDo.getStatus().equals(ToDo.ongoing)&&currToDo.getOccupier().equals(UserRepository.getCurrentUser().getName())){
            doButton.setText("Done");
        }
        else{
            doButton.setVisibility(View.INVISIBLE);
        }
        doButton.setOnClickListener((view)->{
            if(currToDo.getStatus().equals(ToDo.notStarted)){
                currToDo.setStatus(ToDo.ongoing);
                currToDo.setOccupier(UserRepository.getCurrentUser().getName());
            }else if(currToDo.getStatus().equals(ToDo.ongoing)&&currToDo.getOccupier().equals(UserRepository.getCurrentUser().getName())){
                currToDo.setStatus(ToDo.done);
            }
            else{
                doButton.setVisibility(View.INVISIBLE);
            }
            notifyItemChanged(position);
        });

    }

    @Override
    public int getItemCount() {
        return toDoList.size();
    }
}
