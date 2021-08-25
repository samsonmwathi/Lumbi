package com.example.lumbi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ResetActivity extends AppCompatActivity {
    EditText emailAddress;
    Button resetButton;
    String emailPattern ="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;
    TextView loginText;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);

        emailAddress =findViewById(R.id.emailAddress);
        resetButton=findViewById(R.id.resetButton);
        loginText=findViewById(R.id.loginText);
        progressDialog = new ProgressDialog(this);
        mAuth= FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();

        resetButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                resetPassword();
            }
        });



    }


    private void resetPassword() {
        String email= emailAddress.getText().toString();
        if(!email.matches(emailPattern)){
            emailAddress.setError("enter valid email");
        }else if(email.isEmpty()){
            emailAddress.setError("enter email address");
        }else{
            mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    progressDialog.setTitle("Forgot password");
                    progressDialog.setMessage("sending reset email...");
                    progressDialog.setCanceledOnTouchOutside(false);
                    progressDialog.show();
                    if(task.isSuccessful()){
                        progressDialog.dismiss();
                        Toast.makeText(ResetActivity.this,"Please Check your email",Toast.LENGTH_SHORT);
                        Intent resetEmailIntent = new Intent(Intent.ACTION_VIEW);
                        String title = getResources().getString(R.string.reset_chooser_title);
                        Intent chooser = Intent.createChooser(resetEmailIntent,title);
                        if(resetEmailIntent.resolveActivity(getPackageManager())!= null){
                            startActivity(chooser);
                        }else{
                            Toast.makeText(ResetActivity.this,"Please Check your email",Toast.LENGTH_SHORT);
                        }
                    }else{
                        progressDialog.dismiss();
                        emailAddress.setError("This email is not registered");
                        Toast.makeText(ResetActivity.this,"Please Check your email",Toast.LENGTH_SHORT);
                    }
                }

            });
        };
    }

    public void backToLogin(View view) {
            Intent intent = new Intent(ResetActivity.this, LoginActivity.class);
            startActivity(intent);
    }
}