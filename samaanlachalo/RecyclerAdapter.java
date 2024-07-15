package com.example.samaanlachalo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private ArrayList<Routes> routesArrayList;
    private Context context;

    public RecyclerAdapter(ArrayList<Routes>routesArrayList, Context context) {
        this.routesArrayList = routesArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.cardviewroutes, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Routes routes = routesArrayList.get(position);
        holder.tvRName.setText(routes.getName());
        holder.tvRStartingLocation.setText(routes.getStartingLocation());
        holder.tvREndingLocation.setText(routes.getEndingLocation());
        holder.tvRDate.setText(routes.getDate());
        holder.tvRSpace.setText(routes.getAvailableSpace());


    }

    @Override
    public int getItemCount() {
        return routesArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvRName, tvRStartingLocation, tvREndingLocation, tvRDate, tvRSpace;
        Button btnSelect;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvRName = itemView.findViewById(R.id.tvRName);
            tvRStartingLocation = itemView.findViewById(R.id.tvRStartingLocation);
            tvREndingLocation = itemView.findViewById(R.id.tvREndingLocation);
            tvRDate = itemView.findViewById(R.id.tvRDate);
            tvRSpace = itemView.findViewById(R.id.tvRSpace);
            btnSelect = itemView.findViewById(R.id.btnSelect);

            btnSelect.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            Intent intent = new Intent(view.getContext(), SelectActivity.class);
            view.getContext().startActivity(intent);
        }
    }
}
