package com.example.samaanlachalo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SelectActivity extends AppCompatActivity {

    EditText etSName, etSContact, etSPrice;
    Button btnSOffer;
    String name, contact, price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        etSName = findViewById(R.id.etSName);
        etSContact = findViewById(R.id.etSContact);
        etSPrice = findViewById(R.id.etSPrice);
        btnSOffer = findViewById(R.id.btnSOffer);

        btnSOffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(etSName.getText()) || TextUtils.isEmpty(etSContact.getText()) || TextUtils.isEmpty(etSPrice.getText())){
                    Toast.makeText(SelectActivity.this, "Fill all entries", Toast.LENGTH_SHORT).show();
                }
                else {
                    name = etSName.getText().toString();
                    contact = etSContact.getText().toString();
                    price = etSPrice.getText().toString();


                    Database db = new Database();
                    db.selectData(name, contact, price);

                    Intent intent = new Intent(SelectActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}