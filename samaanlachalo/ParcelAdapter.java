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

public class ParcelAdapter extends RecyclerView.Adapter<ParcelAdapter.ViewHolder> {

    private ArrayList<Parcels> parcelsArrayList;
    private Context context;

    public ParcelAdapter(ArrayList<Parcels>parcelsArrayList, Context context) {
        this.parcelsArrayList = parcelsArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ParcelAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.cardviewparcels, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ParcelAdapter.ViewHolder holder, int position) {
        Parcels parcels = parcelsArrayList.get(position);
        holder.tvPName.setText(parcels.getName());
        holder.tvPStartingLocation.setText(parcels.getStartingLocation());
        holder.tvPEndingLocation.setText(parcels.getEndingLocation());
        holder.tvPMaxDate.setText(parcels.getMaxDate());
        holder.tvPSize.setText(parcels.getSize());
        holder.tvPNotes.setText(parcels.getNotes());
    }

    @Override
    public int getItemCount() {
        return parcelsArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView tvPName, tvPStartingLocation, tvPEndingLocation, tvPMaxDate, tvPSize, tvPNotes;
        Button btnPSelect;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvPName = itemView.findViewById(R.id.tvPName);
            tvPStartingLocation = itemView.findViewById(R.id.tvPStartingLocation);
            tvPEndingLocation = itemView.findViewById(R.id.tvPEndingLocation);
            tvPMaxDate = itemView.findViewById(R.id.tvPMaxDate);
            tvPSize = itemView.findViewById(R.id.tvPSize);
            tvPNotes = itemView.findViewById(R.id.tvPNotes);
            btnPSelect = itemView.findViewById(R.id.btnPSelect);

            btnPSelect.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(view.getContext(), SelectActivity.class);
            view.getContext().startActivity(intent);
        }
    }
}
