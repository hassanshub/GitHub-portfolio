package com.example.samaanlachalo;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firestore.v1.Value;
import com.google.firestore.v1.WriteResult;

import java.util.HashMap;
import java.util.Map;

public class Database {
    FirebaseFirestore db;

    public Database (){
        this.db = FirebaseFirestore.getInstance();

    }

    public void addUserData(String name, String phone, String accountType, String UID){

        Map<String, Object> user = new HashMap<>();
        user.put("Name", name);
        user.put("Phone", phone);
        user.put("AccountType", accountType);
        user.put("UID", UID);

        String TAG = "Adding Data";

        db.collection("Users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });

    }

    public void addRouteData(String name, String contact, String startingLocation, String endingLocation, String date, String availableSpace)
    {
        Routes routes = new Routes(name, contact, startingLocation, endingLocation, date, availableSpace);

        CollectionReference dbRoutes = db.collection("Routes");

        dbRoutes.add(routes).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
            }
        });
    }


    public void addParcelData(String name, String contact, String startingLocation, String endingLocation, String maxDate, String size, String notes){

        Parcels parcel = new Parcels(name, contact, startingLocation, endingLocation, maxDate, size, notes);

        CollectionReference dbParcels = db.collection("Parcels");

        dbParcels.add(parcel).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
            }
        });
    }

    public void selectData(String name, String contact, String price){

        Select select = new Select(name, contact, price);

        CollectionReference dbSelect = db.collection("Selected");

        dbSelect.add(select).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
            }
        });
    }

}
