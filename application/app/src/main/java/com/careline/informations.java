package com.careline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class informations extends AppCompatActivity {
    ImageView leave;
    ImageView calendar;
    ImageView notification;
    ImageView home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informations);
        calendar=(ImageView) findViewById(R.id.cal);
        notification=(ImageView) findViewById(R.id.not);
       leave=(ImageView) findViewById(R.id.shape);
        leave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(informations.this,profil.class);
                startActivity(intent);
            }
        });
        home=(ImageView) findViewById(R.id.hom);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(informations.this,Home.class);
                startActivity(intent);
            }
        });

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(informations.this,notification.class);
                startActivity(intent);
            }
        });
        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(informations.this,rendez_vous.class);
                startActivity(intent);
            }
        });
    }
}