package com.example.lumbi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    BottomNavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navbar);
        getSupportFragmentManager().beginTransaction().replace(R.id.body_container, new homeFragment()).commit();
        navigationView.setSelectedItemId(R.id.bottom_navbar);

                navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;


                switch (item.getItemId()) {
                    case R.id.nav_home:
                        fragment = new homeFragment();
                        break;
                    case R.id.nav_settings:
                        fragment = new settingsFragment();
                        break;
                    case R.id.nav_account:
                        fragment = new searchFragment();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.body_container, fragment).commit();
                return true;
            }
        });

    }



            }






