package com.example.kd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.viewHolder> {

    List<SeeAllTasks> tasksList;
    Context con;

    public RVAdapter(List<SeeAllTasks> tasksList, Context context) {
        this.tasksList = tasksList;
        this.con=context;
    }

    @NonNull
    @Override
    public RVAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(con);
        View view =layoutInflater.inflate(R.layout.row_layout, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVAdapter.viewHolder holder, int position) {
        SeeAllTasks task = tasksList.get(position);
        if (task!= null) {
            holder.tv_name.setText(String.valueOf(task.getName()));
            holder.tv_description.setText(String.valueOf(task.getDescription()));
            holder.tv_karmaPoints.setText(String.valueOf(task.getKarmaPoints()));
        }
    }

    @Override
    public int getItemCount() {
        return tasksList.size();
    }


    public static class viewHolder extends RecyclerView.ViewHolder{
        TextView tv_name,tv_description,tv_karmaPoints;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name=itemView.findViewById(R.id.name);
            tv_description=itemView.findViewById(R.id.description);
            tv_karmaPoints=itemView.findViewById(R.id.karmaPoints);
            if (tv_name == null || tv_description == null || tv_karmaPoints == null) {
                throw new RuntimeException("Failed to initialize views");
            }

        }
    }
}
