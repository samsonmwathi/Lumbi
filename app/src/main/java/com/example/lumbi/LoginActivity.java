package com.example.lumbi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import static android.content.ContentValues.TAG;

public class LoginActivity extends AppCompatActivity {

    EditText emailAddress,password;
    Button loginButton,signupButton,googleSigninButton;
    String emailPattern ="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;
    TextView forgotPassword;


    FirebaseAuth mAuth;
    FirebaseUser mUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //hooks
        emailAddress=findViewById(R.id.emailAddressEditText);
        password=findViewById(R.id.passwordEditText);
        loginButton=findViewById(R.id.loginButton);
        signupButton=findViewById(R.id.signUpButton);
        googleSigninButton=findViewById(R.id.googleSignInButton);
        forgotPassword= findViewById(R.id.forgotPasswordText);
        //firebase and dialogue
        progressDialog = new ProgressDialog(this);
        mAuth= FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
        //onclicks
        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                PerformAuth();
            }
        });
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,SignupActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        googleSigninButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,GoogleSignInActivity.class);
                startActivity(intent);
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

            mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        checkEmail(pass);
                        progressDialog.dismiss();
//                        SendUserToNextActivity();
                        Toast.makeText(LoginActivity.this,"Login Successful",Toast.LENGTH_SHORT).show();
                    }else{
                        progressDialog.dismiss();
                        emailAddress.setError("invalid login");
//                        Toast.makeText(LoginActivity.this,""+task.getException(),Toast.LENGTH_LONG).show();
                        Toast.makeText(LoginActivity.this,"Please try Again",Toast.LENGTH_LONG).show();


                    }
                }
            });


        }
    }
    //Check the user email in th realtime db
    //key is the password
    private void checkEmail(String key) {
        EditText emailAddress = findViewById(R.id.emailAddressEditText);
        String mail = emailAddress.getText().toString();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUsername = reference.orderByChild("email").equalTo(mail);

        checkUsername.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //snapshot created when user exists
                if (snapshot.exists()) {
                    String firstName = snapshot.child(key).child("fName").getValue(String.class);
                    String lastName = snapshot.child(key).child("sName").getValue(String.class);
                    String email = snapshot.child(key).child("email").getValue(String.class);
//                      String childName = snapshot.child(key).child("name").getValue(String.class);

                    Intent loginIntent = new Intent(getApplicationContext(), HomeActivity.class);
//                    loginIntent.putExtra("fName", firstName);
//                    loginIntent.putExtra("lName", lastName);
//                    loginIntent.putExtra("email", email);
                    startActivity(loginIntent);
                } else {
                    password.setError("wrong password");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    private void SendUserToNextActivity() {
        Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);

        startActivity(intent);
    }

    public void forgotPassword(View view) {
        Intent intent = new Intent(LoginActivity.this,ResetActivity.class);
        startActivity(intent);
    }
}