package com.careline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Home extends AppCompatActivity {

    ImageView psyim;
    ImageView gynim;
    ImageView dermim;
    ImageView neurim;
    ImageView cardim;
    ImageView dentim;
    ImageView pediim;
    ImageView notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        psyim=(ImageView) findViewById(R.id.psyim);
       gynim=(ImageView) findViewById(R.id.gynim);
        dermim=(ImageView) findViewById(R.id.dermim);
        neurim=(ImageView) findViewById(R.id.neurim);
        cardim=(ImageView) findViewById(R.id.cardim);
        dentim=(ImageView) findViewById(R.id.dentim);
        pediim=(ImageView) findViewById(R.id.pediim);
        notification=(ImageView) findViewById(R.id.not);
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Home.this,notification.class);
                startActivity(intent);
            }
        });
        psyim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Home.this,rendez_vous.class);
                startActivity(intent);
            }
        });
        gynim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Home.this,rendez_vous.class);
                startActivity(intent);
            }
        });
        dermim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Home.this,rendez_vous.class);
                startActivity(intent);
            }
        });
        neurim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Home.this,rendez_vous.class);
                startActivity(intent);
            }
        });
        cardim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Home.this,rendez_vous.class);
                startActivity(intent);
            }
        });
        dentim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Home.this,rendez_vous.class);
                startActivity(intent);
            }
        });
        pediim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Home.this,rendez_vous.class);
                startActivity(intent);
            }
        });
    }
}