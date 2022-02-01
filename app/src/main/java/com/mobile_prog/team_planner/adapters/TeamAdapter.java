package com.mobile_prog.team_planner.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile_prog.team_planner.R;
import com.mobile_prog.team_planner.models.Team;

import java.util.ArrayList;

public class TeamAdapter extends RecyclerView.Adapter {

    private ArrayList<Team> dataList;

    public TeamAdapter(ArrayList<Team> dataList) {
        this.dataList = dataList;
    }

    @Override
//    public TeamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
//        View view = layoutInflater.inflate(R.layout.team_row, parent, false);
//        return new TeamViewHolder(view);
//    }

    //
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_row,parent, false);
        return new RecyclerView.ViewHolder(view) {

        };
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        TextView name=holder.itemView.findViewById(R.id.team_name);
        TextView desc=holder.itemView.findViewById(R.id.team_desc);
        TextView dateOfCreation=holder.itemView.findViewById(R.id.team_dateOfCreation);

        name.setText(dataList.get(position).getName());
        desc.setText(dataList.get(position).getDescription());
        dateOfCreation.setText(dataList.get(position).getDateOfCreation().toString());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class TeamViewHolder extends RecyclerView.ViewHolder{
        private TextView name, desc, dateOfCreation;

        public TeamViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.team_name);
            desc = (TextView) itemView.findViewById(R.id.team_desc);
            dateOfCreation = (TextView) itemView.findViewById(R.id.team_dateOfCreation);
        }
    }
}
