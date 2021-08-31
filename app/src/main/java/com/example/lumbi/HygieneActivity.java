package com.example.lumbi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HygieneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hygiene);
    }

    public void home(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}