package com.example.food_deliver_mobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class AdminHomeActivity extends AppCompatActivity {
    private TextView welcomeTextView;
    private Button profileButton;
    private String adminEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        welcomeTextView = findViewById(R.id.welcome_text_view);
        profileButton = findViewById(R.id.admin_profile_button);

        Intent intent = getIntent();
        adminEmail = intent.getStringExtra("email");  // Get the email from the intent

        if (adminEmail != null) {
            welcomeTextView.setText("Welcome, " + adminEmail);
        } else {
            welcomeTextView.setText("Welcome, Admin");
        }

        profileButton.setOnClickListener(v -> {
            Intent profileIntent = new Intent(AdminHomeActivity.this, AdminProfileActivity.class);
            profileIntent.putExtra("email", adminEmail);
            startActivity(profileIntent);
        });
    }


    public void addNewOnClick(View view){
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }

    public void viewShopsOnClick(View view){
        Intent intent = new Intent(this, ViewActivity.class);
        startActivity(intent);
    }
}
