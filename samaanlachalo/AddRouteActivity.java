package com.example.samaanlachalo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddRouteActivity extends AppCompatActivity {
    EditText etARName, etARContact, etARStartLocation, etAREndLocation, etARDate, etARSpace;
    Button btnARAdd;
    String name, contact, startLocation, endLocation, date, space;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_route);

        etARName = findViewById(R.id.etARName);
        etARContact = findViewById(R.id.etARContact);
        etARStartLocation = findViewById(R.id.etARStartLocation);
        etAREndLocation = findViewById(R.id.etAREndLocation);
        etARDate = findViewById(R.id.etARDate);
        etARSpace = findViewById(R.id.etARSpace);
        btnARAdd = findViewById(R.id.btnARAdd);


        btnARAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty(etARName.getText()) || TextUtils.isEmpty(etARContact.getText()) || TextUtils.isEmpty(etARStartLocation.getText()) || TextUtils.isEmpty(etAREndLocation.getText()) || TextUtils.isEmpty(etARSpace.getText()) || TextUtils.isEmpty(etARDate.getText())){
                    Toast.makeText(AddRouteActivity.this, "Fill all entries", Toast.LENGTH_SHORT).show();
                }
                else {
                    name = etARName.getText().toString();
                    contact = etARContact.getText().toString();
                    startLocation = etARStartLocation.getText().toString();
                    endLocation = etAREndLocation.getText().toString();
                    date = etARDate.getText().toString();
                    space = etARSpace.getText().toString();

                    Database db = new Database();
                    db.addRouteData(name, contact, startLocation, endLocation, date, space);

                    Intent intent = new Intent(AddRouteActivity.this, HomeActivity.class);
                    startActivity(intent);
                }

            }
        });

    }
}