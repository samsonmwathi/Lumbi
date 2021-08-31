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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class SignupActivity extends AppCompatActivity {
    EditText firstName,surName,emailAddress,birthday,password,confirmPassword;
    Button signUpButton, loginButton;
    String emailPattern ="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;

    FirebaseAuth mAuth;
    FirebaseUser mUser;
    FirebaseDatabase rootNode = FirebaseDatabase.getInstance();
    DatabaseReference reference = rootNode.getReference("users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        //hooks
        firstName=findViewById(R.id.firstName);
        surName=findViewById(R.id.surName);
        emailAddress=findViewById(R.id.emailAddress);
        birthday=findViewById(R.id.birthday);
        password=findViewById(R.id.password);
        confirmPassword=findViewById(R.id.confirmPassword);
        signUpButton=findViewById(R.id.signUpButton);
        loginButton=findViewById(R.id.loginButton);

        progressDialog = new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
        //onClicks
        signUpButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                PerformAuth();
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    //to verify input
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
            //to Signup
            progressDialog.setTitle("Registration");
            progressDialog.setMessage("Please wait while Registering...");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                   if(task.isSuccessful()){
                       signData();
                       progressDialog.dismiss();
                       SendUserToNextActivity();
                       Toast.makeText(SignupActivity.this,"Sign up Successful",Toast.LENGTH_SHORT).show();
                   }else{
                       progressDialog.dismiss();
                       Toast.makeText(SignupActivity.this,""+task.getException(),Toast.LENGTH_SHORT).show();

                   }
                }
            });


        }
    }
    public void signData(){
        String fName=firstName.getText().toString();
        String sName=surName.getText().toString();
        String email=emailAddress.getText().toString();
        String bDay =birthday.getText().toString();
        String pass =password.getText().toString();
        String cPass=confirmPassword.getText().toString();
        SignupHelper helper = new SignupHelper(fName,sName,email,bDay,pass,cPass);
        reference.child(fName).setValue(helper);
    }

    public void goToLogin(){
        Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
        startActivity(intent);
    }
    private void SendUserToNextActivity() {
        Intent intent = new Intent(SignupActivity.this, GetStartedActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}