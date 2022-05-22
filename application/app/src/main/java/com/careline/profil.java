package com.careline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class profil extends AppCompatActivity {
    ImageView calendar;
    ImageView notification;
    ImageView home;
    ImageView disconnect;
    ImageView infos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        calendar=(ImageView) findViewById(R.id.cal);
        notification=(ImageView) findViewById(R.id.not);
        infos=(ImageView) findViewById(R.id.pro);
        infos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(profil.this,informations.class);
                startActivity(intent);
            }
        });
        disconnect=(ImageView) findViewById(R.id.di);
        disconnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(profil.this,Login.class);
                startActivity(intent);
            }
        });
        home=(ImageView) findViewById(R.id.hom);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(profil.this,Home.class);
                startActivity(intent);
            }
        });
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(profil.this,notification.class);
                startActivity(intent);
            }
        });
        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(profil.this,rendez_vous.class);
                startActivity(intent);
            }
        });
    }
}