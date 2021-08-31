package com.example.lumbi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddChild extends AppCompatActivity {

    String fName, sName,bDay,gender ;
    int age;
    EditText fNameText, sNameText,bDayText, genderText,ageText;
    ChildHelperClass child;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_child);
        fNameText = findViewById(R.id.firstName);
        sNameText = findViewById(R.id.surName);
        ageText = findViewById(R.id.age);
        bDayText = findViewById(R.id.birthday);
        genderText = findViewById(R.id.gender);

        fName=fNameText.getText().toString();
        sName=sNameText.getText().toString();
        age= Integer.parseInt(ageText.getText().toString());
        bDay=bDayText.getText().toString();
        child =new ChildHelperClass(fName,sName,gender,bDay,age);
        addChild(child);
    }


    public void addChild(ChildHelperClass child){
        String key=FirebaseAuth.getInstance().getUid();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("users").child(key);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //snapshot created when user exists
                if (snapshot.exists()) {
                    String firstName = snapshot.child(key).child("fName").getValue(String.class);
                    String lastName = snapshot.child(key).child("sName").getValue(String.class);
                    String email = snapshot.child(key).child("email").getValue(String.class);
                    String childName = snapshot.child(key).child("name").getValue(String.class);

                    Intent loginIntent = new Intent(getApplicationContext(), HomeActivity.class);
//                    loginIntent.putExtra("fName", firstName);
//                    loginIntent.putExtra("lName", lastName);
//                    loginIntent.putExtra("email", email);
                    startActivity(loginIntent);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });
    }
}