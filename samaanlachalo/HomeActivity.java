package com.example.samaanlachalo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class HomeActivity extends AppCompatActivity {
    Button btnHPRoutes, btnHPParcels, btnHPProfile;
    LinearLayout homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnHPRoutes = findViewById(R.id.btnHPRoutes);
        btnHPParcels = findViewById(R.id.btnHPParcels);
        btnHPProfile = findViewById(R.id.btnHPProfile);
        homeFragment = findViewById(R.id.homeFragment);

        btnHPRoutes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RoutesFragment routesFrag = new RoutesFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.homeFragment, routesFrag);
                transaction.commit();
            }
        });

        btnHPParcels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParcelsFragment parcelFrag = new ParcelsFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.homeFragment, parcelFrag);
                transaction.commit();
            }
        });

        btnHPProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProfileFragment profileFrag = new ProfileFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.homeFragment, profileFrag);
                transaction.commit();
            }
        });
    }

}