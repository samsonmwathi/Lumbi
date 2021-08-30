package com.example.lumbi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_SCREEN= 4000;

    Animation topAnimation, bottomAnimation;
    ImageView image;
    TextView logo, slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        //Animations
        topAnimation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.top_animation);
        bottomAnimation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.bottom_animation);
        //hooks
        image=findViewById(R.id.splashLogo);
        logo=findViewById(R.id.logoText);
        slogan=findViewById(R.id.sloganText);

        image.setAnimation(topAnimation);
        logo.setAnimation(bottomAnimation);
        slogan.setAnimation(bottomAnimation);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                FirebaseAuth auth = FirebaseAuth.getInstance();
                Intent intent;
                if (auth.getCurrentUser() == null) {
                    intent=new Intent(MainActivity.this, LoginActivity.class);

                } else {
                    intent=new Intent(MainActivity.this,ProfileActivity.class);
                }
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);

}
}






