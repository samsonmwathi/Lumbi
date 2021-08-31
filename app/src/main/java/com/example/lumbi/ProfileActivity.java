package com.example.lumbi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileActivity extends AppCompatActivity {
    ImageView profileImage;
    TextView fullName, emailLabel;
    TextInputLayout userNameEdit, emailEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fullName=findViewById(R.id.fullname_label);
        emailLabel=findViewById(R.id.email_label);
        userNameEdit=findViewById(R.id.full_name_profile);
        emailEdit=findViewById(R.id.email_profile);

        setContentView(R.layout.activity_profile);
        showAllData();


    }

    private void showAllData() {
        Intent intent = getIntent();
        String fName = intent.getStringExtra("fName");
        //String lName =intent.getStringExtra("lName");
        String mail =intent.getStringExtra("email");
        //String username =fName+lName;
        fullName=findViewById(R.id.fullname_label);
        emailLabel=findViewById(R.id.email_label);
        userNameEdit=findViewById(R.id.full_name_profile);
        emailEdit=findViewById(R.id.email_profile);
        fullName.setText(fName);
        emailLabel.setText(mail);
        userNameEdit.getEditText().setText(mail);
        emailEdit.getEditText().setText(mail);
    }

    public void signout(View view) {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.signOut();
        if (auth.getCurrentUser() == null) {
            Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }

    }
}