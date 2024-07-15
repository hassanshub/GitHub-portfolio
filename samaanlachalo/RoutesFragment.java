package com.example.samaanlachalo;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;



public class RoutesFragment extends Fragment {

    Button btnAddRoutes;
    RecyclerView RVRoutes;
    FirebaseFirestore db;
    ArrayList<Routes> routesArrayList;
    private RecyclerAdapter recyclerAdapter;
    String TAG = "Routes Fragment";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_routes, container, false);

        db = FirebaseFirestore.getInstance();

        RVRoutes = view.findViewById(R.id.RVRoutes);
        btnAddRoutes = view.findViewById(R.id.btnAddRoute);

        routesArrayList = new ArrayList<>();
        RVRoutes.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerAdapter = new RecyclerAdapter(routesArrayList, getContext());
        RVRoutes.setAdapter(recyclerAdapter);

        db.collection("Routes").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (!queryDocumentSnapshots.isEmpty()) {
                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for (DocumentSnapshot d : list) {
                                Routes r = d.toObject(Routes.class);
                                routesArrayList.add(r);
                            }

                            recyclerAdapter.notifyDataSetChanged();
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


        btnAddRoutes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddRouteActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}