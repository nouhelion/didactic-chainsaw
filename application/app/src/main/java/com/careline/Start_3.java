package com.careline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Start_3 extends AppCompatActivity {

    Button dot1,dot2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start3);
        dot1=(Button) findViewById(R.id.dot_1);
        dot2=(Button) findViewById(R.id.dot_2);
        dot1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Start_3.this,MainActivity.class);
                startActivity(intent);
            }
        });
        dot2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Start_3.this,Start_2.class);
                startActivity(intent);
            }
        });
    }
}