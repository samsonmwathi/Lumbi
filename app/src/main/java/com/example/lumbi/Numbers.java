package com.example.lumbi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

public class Numbers extends AppCompatActivity implements View.OnClickListener{
    private CardView one, two, three, four, five, six, seven, eight, nine, ten;
    MediaPlayer ourSong;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        CardView one= findViewById(R.id.one);
        CardView two= findViewById(R.id.two);
        CardView three= findViewById(R.id.three);
        CardView four= findViewById(R.id.four);
        CardView five= findViewById(R.id.five);
        CardView six= findViewById(R.id.six);
        CardView seven= findViewById(R.id.seven);
        CardView eight= findViewById(R.id.eight);
        CardView nine= findViewById(R.id.nine);
        CardView ten= findViewById(R.id.ten);

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        ten.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater factory;
        View view;
        CardView cardView;
        ImageView image;
        switch (v.getId()) {

            case R.id.one:
                ourSong= MediaPlayer.create(this,R.raw.moja);
                ourSong.start();
                builder.setTitle("1");
                factory=LayoutInflater.from(Numbers.this);
                view=factory.inflate(R.layout.display, null);
                image= (ImageView) view.findViewById(R.id.display);
                image.setImageResource(R.drawable.count_one);
                builder.setView(view);
                builder.setNeutralButton("BACK",null);
                builder.show();
                break;
            case R.id.two:
                ourSong= MediaPlayer.create(this,R.raw.mbili);
                ourSong.start();
                builder.setTitle("2");
                factory=LayoutInflater.from(Numbers.this);
                view=factory.inflate(R.layout.display, null);
                image= (ImageView) view.findViewById(R.id.display);
                image.setImageResource(R.drawable.count_two);
                builder.setView(view);
                builder.setNeutralButton("BACK",null);
                builder.show();
                break;
            case R.id.three:
                ourSong= MediaPlayer.create(this,R.raw.tatu);
                ourSong.start();
                builder.setTitle("3");
                factory=LayoutInflater.from(Numbers.this);
                view=factory.inflate(R.layout.display, null);
                image= (ImageView) view.findViewById(R.id.display);
                image.setImageResource(R.drawable.count_three);
                builder.setView(view);
                builder.setNeutralButton("BACK",null);
                builder.show();
                break;
            case R.id.four:
                ourSong= MediaPlayer.create(this,R.raw.nne);
                ourSong.start();
                builder.setTitle("4");
                factory=LayoutInflater.from(Numbers.this);
                view=factory.inflate(R.layout.display, null);
                image= (ImageView) view.findViewById(R.id.display);
                image.setImageResource(R.drawable.count_four);
                builder.setView(view);
                builder.setNeutralButton("BACK",null);
                builder.show();
                break;
            case R.id.five:
                ourSong= MediaPlayer.create(this,R.raw.tano);
                ourSong.start();
                builder.setTitle("5");
                factory=LayoutInflater.from(Numbers.this);
                view=factory.inflate(R.layout.display, null);
                image= (ImageView) view.findViewById(R.id.display);
                image.setImageResource(R.drawable.count_five);
                builder.setView(view);
                builder.setNeutralButton("BACK",null);
                builder.show();
                break;
            case R.id.six:
                ourSong= MediaPlayer.create(this,R.raw.sita);
                ourSong.start();
                builder.setTitle("6");
                factory=LayoutInflater.from(Numbers.this);
                view=factory.inflate(R.layout.display, null);
                image= (ImageView) view.findViewById(R.id.display);
                image.setImageResource(R.drawable.count_six);
                builder.setView(view);
                builder.setNeutralButton("BACK",null);
                builder.show();
                break;
            case R.id.seven:
                ourSong= MediaPlayer.create(this,R.raw.saba);
                ourSong.start();
                builder.setTitle("7");
                factory=LayoutInflater.from(Numbers.this);
                view=factory.inflate(R.layout.display, null);
                image= (ImageView) view.findViewById(R.id.display);
                image.setImageResource(R.drawable.count_seven);
                builder.setView(view);
                builder.setNeutralButton("BACK",null);
                builder.show();
                break;
            case R.id.eight:
                ourSong= MediaPlayer.create(this,R.raw.nane);
                ourSong.start();
                builder.setTitle("8");
                factory=LayoutInflater.from(Numbers.this);
                view=factory.inflate(R.layout.display, null);
                image= (ImageView) view.findViewById(R.id.display);
                image.setImageResource(R.drawable.count_eight);
                builder.setView(view);
                builder.setNeutralButton("BACK",null);
                builder.show();
                break;
            case R.id.nine:
                ourSong= MediaPlayer.create(this,R.raw.tisa);
                ourSong.start();
                builder.setTitle("9");
                factory=LayoutInflater.from(Numbers.this);
                view=factory.inflate(R.layout.display, null);
                image= (ImageView) view.findViewById(R.id.display);
                image.setImageResource(R.drawable.count_nine);
                builder.setView(view);
                builder.setNeutralButton("BACK",null);
                builder.show();
                break;
            case R.id.ten:
                ourSong= MediaPlayer.create(this,R.raw.kumi);
                ourSong.start();
                builder.setTitle("10");
                factory=LayoutInflater.from(Numbers.this);
                view=factory.inflate(R.layout.display, null);
                image= (ImageView) view.findViewById(R.id.display);
                image.setImageResource(R.drawable.count_nine);
                builder.setView(view);
                builder.setNeutralButton("BACK",null);
                builder.show();
                break;


        }

    }
}