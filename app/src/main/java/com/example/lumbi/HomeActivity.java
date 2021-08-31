package com.example.lumbi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HomeActivity extends AppCompatActivity {
DatabaseReference db = FirebaseDatabase.getInstance().getReference("user");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        FirebaseAuth auth = FirebaseAuth.getInstance();
        Intent intent;
        if (auth.getCurrentUser() == null) {
            intent=new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            finish();
        }

    }

    public void getProfile(View view) {
        Intent intent = new Intent(HomeActivity.this,ProfileActivity.class);
        startActivity(intent);
    }

    public void toNumbers(View view) {
        Intent intent = new Intent(HomeActivity.this,Numbers.class);
        startActivity(intent);
    }

    public void toLetters(View view) {
        Intent intent = new Intent(HomeActivity.this,Alphabets.class);
        startActivity(intent);
    }

    public void toSettings(View view) {
        Intent intent = new Intent(HomeActivity.this,ProfileActivity.class);
        startActivity(intent);
    }

    public void toHygiene(View view) {
        Intent intent = new Intent(HomeActivity.this,HygieneActivity.class);
        startActivity(intent);
    }
}