package com.careline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class informations extends AppCompatActivity {
    ImageView leave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informations);
       leave=(ImageView) findViewById(R.id.shape);
        leave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(informations.this,profil.class);
                startActivity(intent);
            }
        });
    }
}