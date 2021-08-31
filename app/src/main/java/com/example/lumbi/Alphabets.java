package com.example.lumbi;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Alphabets extends AppCompatActivity implements View.OnClickListener {
    ImageButton a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z;
    MediaPlayer ourSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabets);

        ImageButton a = findViewById(R.id.a);
        ImageButton b = findViewById(R.id.b);
        ImageButton c = findViewById(R.id.c);
        ImageButton d = findViewById(R.id.d);
        ImageButton e = findViewById(R.id.e);
        ImageButton f = findViewById(R.id.f);
        ImageButton g = findViewById(R.id.g);
        ImageButton h = findViewById(R.id.h);
        ImageButton i = findViewById(R.id.i);
        ImageButton j = findViewById(R.id.j);
        ImageButton k = findViewById(R.id.k);
        ImageButton l = findViewById(R.id.l);
        ImageButton m = findViewById(R.id.m);
        ImageButton n = findViewById(R.id.n);
        ImageButton o = findViewById(R.id.o);
        ImageButton p = findViewById(R.id.p);
        ImageButton q = findViewById(R.id.q);
        ImageButton r = findViewById(R.id.r);
        ImageButton s = findViewById(R.id.s);
        ImageButton t = findViewById(R.id.t);
        ImageButton u = findViewById(R.id.u);
        ImageButton v = findViewById(R.id.v);
        ImageButton w = findViewById(R.id.w);
        ImageButton x = findViewById(R.id.x);
        ImageButton y = findViewById(R.id.y);
        ImageButton z = findViewById(R.id.z);


        a.setOnClickListener(this);
        b.setOnClickListener(this);
        c.setOnClickListener(this);
        d.setOnClickListener(this);
        e.setOnClickListener(this);
        f.setOnClickListener(this);
        g.setOnClickListener(this);
        h.setOnClickListener(this);
        i.setOnClickListener(this);
        j.setOnClickListener(this);
        k.setOnClickListener(this);
        l.setOnClickListener(this);
        m.setOnClickListener(this);
        n.setOnClickListener(this);
        o.setOnClickListener(this);
        p.setOnClickListener(this);
        q.setOnClickListener(this);
        r.setOnClickListener(this);
        s.setOnClickListener(this);
        t.setOnClickListener(this);
        u.setOnClickListener(this);
        v.setOnClickListener(this);
        w.setOnClickListener(this);
        x.setOnClickListener(this);
        y.setOnClickListener(this);
        z.setOnClickListener(this);


            }

    @Override
    public void onClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater factory;
        View view;
        ImageView image;
        switch(v.getId()){

            case R.id.a:
                ourSong= MediaPlayer.create(this,R.raw.a);
                ourSong.start();
                builder.setTitle("A");
                factory=LayoutInflater.from(Alphabets.this);
                view=factory.inflate(R.layout.display, null);
                image= (ImageButton) view.findViewById(R.id.a);
                image.setImageResource(R.drawable.letter_a);
                builder.setView(view);
                builder.setNeutralButton("BACK",null);
                builder.show();
                break;
            case R.id.b:
                ourSong= MediaPlayer.create(this,R.raw.b);
                ourSong.start();
                builder.setTitle("B");
                factory=LayoutInflater.from(Alphabets.this);
                view=factory.inflate(R.layout.display, null);
                image= (ImageView) view.findViewById(R.id.b);
                image.setImageResource(R.drawable.letter_b);
                builder.setView(view);
                builder.setNeutralButton("BACK",null);
                builder.show();
                break;
            case R.id.c:
                ourSong= MediaPlayer.create(this,R.raw.c);
                ourSong.start();
                builder.setTitle("C");
                factory=LayoutInflater.from(Alphabets.this);
                view=factory.inflate(R.layout.display, null);
                image= (ImageView) view.findViewById(R.id.c);
                image.setImageResource(R.drawable.letter_c);
                builder.setView(view);
                builder.setNeutralButton("BACK",null);
                builder.show();
                break;
            case R.id.d:
                ourSong= MediaPlayer.create(this,R.raw.d);
                ourSong.start();
                builder.setTitle("D");
                factory=LayoutInflater.from(Alphabets.this);
                view=factory.inflate(R.layout.display, null);
                image= (ImageView) view.findViewById(R.id.d);
                image.setImageResource(R.drawable.letter_d);
                builder.setView(view);
                builder.setNeutralButton("BACK",null);
                builder.show();
                break;
            case R.id.e:
                ourSong= MediaPlayer.create(this,R.raw.e);
                ourSong.start();
                builder.setTitle("E");
                factory=LayoutInflater.from(Alphabets.this);
                view=factory.inflate(R.layout.display, null);
                image= (ImageView) view.findViewById(R.id.e);
                image.setImageResource(R.drawable.letter_e);
                builder.setView(view);
                builder.setNeutralButton("BACK",null);
                builder.show();
                break;
            case R.id.f:
                ourSong= MediaPlayer.create(this,R.raw.f);
                ourSong.start();
                builder.setTitle("F");
                factory=LayoutInflater.from(Alphabets.this);
                view=factory.inflate(R.layout.display, null);
                image= (ImageView) view.findViewById(R.id.f);
                image.setImageResource(R.drawable.letter_f);
                builder.setView(view);
                builder.setNeutralButton("BACK",null);
                builder.show();
                break;
            case R.id.g:
                ourSong= MediaPlayer.create(this,R.raw.g);
                ourSong.start();
                builder.setTitle("G");
                factory=LayoutInflater.from(Alphabets.this);
                view=factory.inflate(R.layout.display, null);
                image= (ImageView) view.findViewById(R.id.g);
                image.setImageResource(R.drawable.letter_g);
                builder.setView(view);
                builder.setNeutralButton("BACK",null);
                builder.show();
                break;
            case R.id.h:
                ourSong= MediaPlayer.create(this,R.raw.h);
                ourSong.start();
                builder.setTitle("H");
                factory=LayoutInflater.from(Alphabets.this);
                view=factory.inflate(R.layout.display, null);
                image= (ImageView) view.findViewById(R.id.h);
                image.setImageResource(R.drawable.letter_h);
                builder.setView(view);
                builder.setNeutralButton("BACK",null);
                builder.show();
                break;
            case R.id.i:
                ourSong= MediaPlayer.create(this,R.raw.i);
                ourSong.start();
                builder.setTitle("I");
                factory=LayoutInflater.from(Alphabets.this);
                view=factory.inflate(R.layout.display, null);
                image= (ImageView) view.findViewById(R.id.i);
                image.setImageResource(R.drawable.letter_i);
                builder.setView(view);
                builder.setNeutralButton("BACK",null);
                builder.show();
                break;
            case R.id.j:
                ourSong= MediaPlayer.create(this,R.raw.j);
                ourSong.start();
                builder.setTitle("J");
                factory=LayoutInflater.from(Alphabets.this);
                view=factory.inflate(R.layout.display, null);
                image= (ImageView) view.findViewById(R.id.j);
                image.setImageResource(R.drawable.letter_j);
                builder.setView(view);
                builder.setNeutralButton("BACK",null);
                builder.show();
                break;
            case R.id.k:
                ourSong= MediaPlayer.create(this,R.raw.k);
                ourSong.start();
                builder.setTitle("K");
                factory=LayoutInflater.from(Alphabets.this);
                view=factory.inflate(R.layout.display, null);
                image= (ImageView) view.findViewById(R.id.k);
                image.setImageResource(R.drawable.letter_k);
                builder.setView(view);
                builder.setNeutralButton("BACK",null);
                builder.show();
                break;
            case R.id.l:
                ourSong= MediaPlayer.create(this,R.raw.l);
                ourSong.start();
                builder.setTitle("L");
                factory=LayoutInflater.from(Alphabets.this);
                view=factory.inflate(R.layout.display, null);
                image= (ImageView) view.findViewById(R.id.l);
                image.setImageResource(R.drawable.letter_b);
                builder.setView(view);
                builder.setNeutralButton("BACK",null);
                builder.show();
                break;
            case R.id.m:
                ourSong= MediaPlayer.create(this,R.raw.m);
                ourSong.start();
                builder.setTitle("M");
                factory=LayoutInflater.from(Alphabets.this);
                view=factory.inflate(R.layout.display, null);
                image= (ImageView) view.findViewById(R.id.m);
                image.setImageResource(R.drawable.letter_m);
                builder.setView(view);
                builder.setNeutralButton("BACK",null);
                builder.show();
                break;
            case R.id.n:
                ourSong= MediaPlayer.create(this,R.raw.n);
                ourSong.start();
                builder.setTitle("N");
                factory=LayoutInflater.from(Alphabets.this);
                view=factory.inflate(R.layout.display, null);
                image= (ImageView) view.findViewById(R.id.a);
                image.setImageResource(R.drawable.letter_n);
                builder.setView(view);
                builder.setNeutralButton("BACK",null);
                builder.show();
                break;case R.id.o:
                ourSong= MediaPlayer.create(this,R.raw.o);
                ourSong.start();
                builder.setTitle("O");
                factory=LayoutInflater.from(Alphabets.this);
                view=factory.inflate(R.layout.display, null);
                image= (ImageView) view.findViewById(R.id.o);
                image.setImageResource(R.drawable.letter_o);
                builder.setView(view);
                builder.setNeutralButton("BACK",null);
                builder.show();
                break;
            case R.id.p:
                ourSong= MediaPlayer.create(this,R.raw.p);
                ourSong.start();
                builder.setTitle("P");
                factory=LayoutInflater.from(Alphabets.this);
                view=factory.inflate(R.layout.display, null);
                image= (ImageView) view.findViewById(R.id.p);
                image.setImageResource(R.drawable.letter_p);
                builder.setView(view);
                builder.setNeutralButton("BACK",null);
                builder.show();
                break;
            case R.id.q:
                ourSong= MediaPlayer.create(this,R.raw.q);
                ourSong.start();
                builder.setTitle("Q");
                factory=LayoutInflater.from(Alphabets.this);
                view=factory.inflate(R.layout.display, null);
                image= (ImageView) view.findViewById(R.id.q);
                image.setImageResource(R.drawable.letter_q);
                builder.setView(view);
                builder.setNeutralButton("BACK",null);
                builder.show();
                break;
            case R.id.r:
                ourSong= MediaPlayer.create(this,R.raw.r);
                ourSong.start();
                builder.setTitle("R");
                factory=LayoutInflater.from(Alphabets.this);
                view=factory.inflate(R.layout.display, null);
                image= (ImageView) view.findViewById(R.id.r);
                image.setImageResource(R.drawable.letter_r);
                builder.setView(view);
                builder.setNeutralButton("BACK",null);
                builder.show();
                break;
            case R.id.s:
                ourSong= MediaPlayer.create(this,R.raw.s);
                ourSong.start();
                builder.setTitle("S");
                factory=LayoutInflater.from(Alphabets.this);
                view=factory.inflate(R.layout.display, null);
                image= (ImageView) view.findViewById(R.id.s);
                image.setImageResource(R.drawable.letter_s);
                builder.setView(view);
                builder.setNeutralButton("BACK",null);
                builder.show();
                break;
            case R.id.t:
                ourSong= MediaPlayer.create(this,R.raw.t);
                ourSong.start();
                builder.setTitle("T");
                factory=LayoutInflater.from(Alphabets.this);
                view=factory.inflate(R.layout.display, null);
                image= (ImageView) view.findViewById(R.id.t);
                image.setImageResource(R.drawable.letter_t);
                builder.setView(view);
                builder.setNeutralButton("BACK",null);
                builder.show();
                break;


            case R.id.u:
                ourSong= MediaPlayer.create(this,R.raw.u);
                ourSong.start();
                builder.setTitle("U");
                factory=LayoutInflater.from(Alphabets.this);
                view=factory.inflate(R.layout.display, null);
                image= (ImageView) view.findViewById(R.id.u);
                image.setImageResource(R.drawable.letter_u);
                builder.setView(view);
                builder.setNeutralButton("BACK",null);
                builder.show();
                break;
            case R.id.v:
                ourSong= MediaPlayer.create(this,R.raw.v);
                ourSong.start();
                builder.setTitle("V");
                factory=LayoutInflater.from(Alphabets.this);
                view=factory.inflate(R.layout.display, null);
                image= (ImageView) view.findViewById(R.id.v);
                image.setImageResource(R.drawable.letter_v);
                builder.setView(view);
                builder.setNeutralButton("BACK",null);
                builder.show();
                break;
            case R.id.w:
                ourSong= MediaPlayer.create(this,R.raw.w);
                ourSong.start();
                builder.setTitle("W");
                factory=LayoutInflater.from(Alphabets.this);
                view=factory.inflate(R.layout.display, null);
                image= (ImageView) view.findViewById(R.id.w);
                image.setImageResource(R.drawable.letter_w);
                builder.setView(view);
                builder.setNeutralButton("BACK",null);
                builder.show();
                break;
            case R.id.x:
                ourSong= MediaPlayer.create(this,R.raw.x);
                ourSong.start();
                builder.setTitle("X");
                factory=LayoutInflater.from(Alphabets.this);
                view=factory.inflate(R.layout.display, null);
                image= (ImageView) view.findViewById(R.id.x);
                image.setImageResource(R.drawable.letter_x);
                builder.setView(view);
                builder.setNeutralButton("BACK",null);
                builder.show();
                break;
            case R.id.y:
                ourSong= MediaPlayer.create(this,R.raw.x);
                ourSong.start();
                builder.setTitle("X");
                factory=LayoutInflater.from(Alphabets.this);
                view=factory.inflate(R.layout.display, null);
                image= (ImageView) view.findViewById(R.id.y);
                image.setImageResource(R.drawable.letter_y);
                builder.setView(view);
                builder.setNeutralButton("BACK",null);
                builder.show();
                break;


            case R.id.z:
                ourSong= MediaPlayer.create(this,R.raw.z);
                ourSong.start();
                builder.setTitle("Z");
                factory=LayoutInflater.from(Alphabets.this);
                view=factory.inflate(R.layout.display, null);
                image= (ImageView) view.findViewById(R.id.z);
                image.setImageResource(R.drawable.letter_z);
                builder.setView(view);
                builder.setNeutralButton("BACK",null);
                builder.show();
                break;



    }
};
    }
