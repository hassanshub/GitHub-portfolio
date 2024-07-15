package com.example.samaanlachalo;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ParcelsFragment extends Fragment {

    Button btnAddParcel;
    RecyclerView RVParcels;
    FirebaseFirestore db;
    ArrayList<Parcels> parcelsArrayList;
    private ParcelAdapter parcelAdapter;
    String TAG = "Parcel Fragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_parcels, container, false);

        db = FirebaseFirestore.getInstance();

        RVParcels = view.findViewById(R.id.RVParcels);
        btnAddParcel = view.findViewById(R.id.btnAddParcel);

        parcelsArrayList = new ArrayList<>();
        RVParcels.setLayoutManager(new LinearLayoutManager(getContext()));

        parcelAdapter = new ParcelAdapter(parcelsArrayList, getContext());
        RVParcels.setAdapter(parcelAdapter);

        db.collection("Parcels").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (!queryDocumentSnapshots.isEmpty()) {
                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for (DocumentSnapshot d : list) {
                                Parcels p = d.toObject(Parcels.class);
                                parcelsArrayList.add(p);
                            }

                            parcelAdapter.notifyDataSetChanged();
                        } else {
                            Toast.makeText(getActivity(), "No data found in Database", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(), "Fail to get the data.", Toast.LENGTH_SHORT).show();
            }
        });


        btnAddParcel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddParcelActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}