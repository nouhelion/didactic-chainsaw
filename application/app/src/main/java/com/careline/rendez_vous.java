package com.careline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class rendez_vous extends AppCompatActivity {
    TextView doc1;
    TextView doc2;
    TextView doc3;
    TextView doc4;
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
        doc1=(TextView) findViewById(R.id.d1);
        doc2=(TextView) findViewById(R.id.d2);
        doc3=(TextView) findViewById(R.id.d3);
        doc4=(TextView) findViewById(R.id.d4);
        doc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(rendez_vous.this,reservation.class);
                startActivity(intent);
            }
        });
        doc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(rendez_vous.this,reservation.class);
                startActivity(intent);
            }
        });
        doc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(rendez_vous.this,reservation.class);
                startActivity(intent);
            }
        });
        doc4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(rendez_vous.this,reservation.class);
                startActivity(intent);
            }
        });
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