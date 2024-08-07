package com.example.food_deliver_mobileapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AdminProfileActivity extends AppCompatActivity {

    private TextView nameTextView, emailTextView;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_profile);

        nameTextView = findViewById(R.id.admin_profile_name);
        emailTextView = findViewById(R.id.admin_profile_email);

        dbHandler = new DBHandler(this);

        Intent intent = getIntent();
        String email = intent.getStringExtra("email");

        if (email != null) {
            Cursor cursor = dbHandler.getAdminByEmail(email);
            if (cursor != null && cursor.moveToFirst()) {
                nameTextView.setText(cursor.getString(cursor.getColumnIndexOrThrow("name")));
                emailTextView.setText(cursor.getString(cursor.getColumnIndexOrThrow("email")));
                cursor.close();
            }
        }
    }

}
