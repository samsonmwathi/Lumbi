package com.example.lumbi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class ChildMenu extends AppCompatActivity {
    String fName, sName,gender,bDay ;
    int age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_menu);
    }

    public void toLesson(View view) {
        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);

    }

    public void addChild(View view) {
        Intent intent = new Intent(this,AddChild.class);
        startActivity(intent);
    }
}