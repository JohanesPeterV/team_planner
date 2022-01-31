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
//        Cart currCart = userCart.getCart(position);
//        LinearLayout cartDesc = holder.itemView.findViewById(R.id.cartDescription);
//        TextView cartName = cartDesc.findViewById(R.id.checkOutName);
//        TextView cartPriceQty = cartDesc.findViewById(R.id.checkOutPrice);
//        Button removeButton = holder.itemView.findViewById(R.id.removeButton);
//        cartName.setText(currCart.getConsumable().getName());
//        String priceQty=currCart.getConsumable().getPrice() + " * " + currCart.getQty()+" = "+(currCart.getQty()*currCart.getConsumable().getPrice());
//        cartPriceQty.setText(priceQty);
//        removeButton.setOnClickListener(view -> {
//            userCart.remove(position);
//            notifyItemRemoved(position);
//            totalPrice.setText(""+userCart.calculateTotalPrice());
//
//        });

    }

    @Override
    public int getItemCount() {
        return toDoList.size();
    }
}
