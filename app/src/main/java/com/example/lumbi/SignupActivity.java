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

public class SignupActivity extends AppCompatActivity {
    EditText firstName,surName,emailAddress,birthday,password,confirmPassword;
    Button signUpButton;
    String emailPattern ="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;

    FirebaseAuth mAuth;
    FirebaseUser mUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        firstName=findViewById(R.id.firstName);
        surName=findViewById(R.id.surName);
        emailAddress=findViewById(R.id.emailAddress);
        birthday=findViewById(R.id.birthday);
        password=findViewById(R.id.password);
        confirmPassword=findViewById(R.id.confirmPassword);
        signUpButton=findViewById(R.id.signUpButton);
        progressDialog = new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();

        signUpButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                PerformAuth();
            }
        });
    }

    private void PerformAuth() {
        String fName=firstName.getText().toString();
        String sName=surName.getText().toString();
        String email=emailAddress.getText().toString();
        String bDay =birthday.getText().toString();
        String pass =password.getText().toString();
        String cPass=confirmPassword.getText().toString();

        if(fName.isEmpty()){
            firstName.setError("enter your first name");
        }else if(sName.isEmpty()){
            surName.setError("enter your Second Name");
        }
        else if(!email.matches(emailPattern)){
            emailAddress.setError("enter valid email");
        }
        else if(bDay.isEmpty()){
            birthday.setError("enter birthday");
        }
        else if(pass.isEmpty()){
            password.setError("enter password");
        }
        else if(!cPass.equals(pass) ||cPass.isEmpty()){
            confirmPassword.setError("enter matching password");
        }
        else{
            progressDialog.setTitle("Registration");
            progressDialog.setMessage("Please wait while Registering...");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                   if(task.isSuccessful()){
                       progressDialog.dismiss();
                       SendUserToNextActivity();
                       Toast.makeText(SignupActivity.this,"Signup Successful",Toast.LENGTH_SHORT);
                   }else{
                       progressDialog.dismiss();
                       Toast.makeText(SignupActivity.this,""+task.getException(),Toast.LENGTH_SHORT);

                   }
                }
            });


        }
    }

    public void goToLogin(){
        setContentView(R.layout.activity_login);
    }
    private void SendUserToNextActivity() {
        Intent intent = new Intent(SignupActivity.this, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}