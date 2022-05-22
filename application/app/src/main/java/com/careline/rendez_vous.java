package com.careline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class rendez_vous extends AppCompatActivity {

    ImageView notification;
    ImageView home;
    ImageView profil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rendez_vous);
        notification=(ImageView) findViewById(R.id.not);
        home=(ImageView) findViewById(R.id.hom);
        profil=(ImageView) findViewById(R.id.per);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(rendez_vous.this,Home.class);
                startActivity(intent);
            }
        });
        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(rendez_vous.this,profil.class);
                startActivity(intent);
            }
        });
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(rendez_vous.this,notification.class);
                startActivity(intent);
            }
        });
    }
}