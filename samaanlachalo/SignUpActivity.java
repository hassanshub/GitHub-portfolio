package com.example.samaanlachalo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SignUpActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner spinnerAccountType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        spinnerAccountType = findViewById(R.id.spinnerAccountType);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.AccountType, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAccountType.setAdapter(adapter);
        spinnerAccountType.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String User = adapterView.getItemAtPosition(i).toString();
        String Driver = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}