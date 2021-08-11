package com.example.lumbi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    EditText emailAddress,password;
    Button loginButton;
    String emailPattern ="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;

    FirebaseAuth mAuth;
    FirebaseUser mUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        emailAddress=findViewById(R.id.emailAddress);
        password=findViewById(R.id.password);
        loginButton=findViewById(R.id.loginButton);
        progressDialog = new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();

        loginButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                PerformAuth();
            }
        });
    }

    private void PerformAuth() {

        String email=emailAddress.getText().toString();

        String pass =password.getText().toString();


        if(!email.matches(emailPattern)){
            emailAddress.setError("enter valid email");
        }
        else if(pass.isEmpty()){
            password.setError("enter password");
        }else{
            progressDialog.setTitle("login");
            progressDialog.setMessage("logging in please wait...");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        progressDialog.dismiss();
                        SendUserToNextActivity();
                        Toast.makeText(LoginActivity.this,"Login Successful",Toast.LENGTH_SHORT);
                    }else{
                        progressDialog.dismiss();
                        Toast.makeText(LoginActivity.this,""+task.getException(),Toast.LENGTH_SHORT);

                    }
                }
            });


        }
    }
    private void SendUserToNextActivity() {
        Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void goToSignUp() {
        setContentView(R.layout.activity_signup);
    }
}