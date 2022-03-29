package com.careline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button suivant;
    Button dot2,dot3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       suivant=(Button) findViewById(R.id.btn_suivant);
        dot2=(Button) findViewById(R.id.dot_2);
        dot3=(Button) findViewById(R.id.dot_3);
       suivant.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(MainActivity.this,Start_2.class);
               startActivity(intent);
           }
       });
        dot2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Start_2.class);
                startActivity(intent);
            }
        });
        dot3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Start_3.class);
                startActivity(intent);
            }
        });
    }
}