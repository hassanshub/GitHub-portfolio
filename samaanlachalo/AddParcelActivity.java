package com.example.samaanlachalo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddParcelActivity extends AppCompatActivity {

    EditText etAPName, etAPContact, etAPStartLocation, etAPEndLocation, etAPDate, etAPSize, etAPNotes;
    Button btnAddParcel;
    String name, contact, startingLocation, endingLocation, maxDate, size, notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_parcel);

        etAPName = findViewById(R.id.etAPName);
        etAPContact = findViewById(R.id.etAPContact);
        etAPStartLocation = findViewById(R.id.etAPStartLocation);
        etAPEndLocation = findViewById(R.id.etAPEndLocation);
        etAPDate = findViewById(R.id.etAPDate);
        etAPSize = findViewById(R.id.etAPSize);
        etAPNotes = findViewById(R.id.etAPNotes);
        btnAddParcel = findViewById(R.id.btnAPAdd);

        btnAddParcel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty(etAPName.getText()) || TextUtils.isEmpty(etAPContact.getText()) || TextUtils.isEmpty(etAPStartLocation.getText()) || TextUtils.isEmpty(etAPEndLocation.getText()) || TextUtils.isEmpty(etAPSize.getText()) || TextUtils.isEmpty(etAPDate.getText())){
                    Toast.makeText(AddParcelActivity.this, "Fill all entries", Toast.LENGTH_SHORT).show();
                }
                else {
                    name = etAPName.getText().toString();
                    contact = etAPContact.getText().toString();
                    startingLocation = etAPStartLocation.getText().toString();
                    endingLocation = etAPEndLocation.getText().toString();
                    maxDate = etAPDate.getText().toString();
                    size = etAPSize.getText().toString();
                    notes = etAPNotes.getText().toString();

                    Database db = new Database();
                    db.addParcelData(name, contact, startingLocation, endingLocation, maxDate, size, notes);

                    Intent intent = new Intent(AddParcelActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
