package com.careline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Start_2 extends AppCompatActivity {

    Button suivant;
    Button dot1,dot3;
    TextView ignore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start2);
        suivant=(Button) findViewById(R.id.btn_suivant);
        ignore=(TextView) findViewById(R.id.ignorer);
        dot1=(Button) findViewById(R.id.dot_1);
        dot3=(Button) findViewById(R.id.dot_3);
        suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Start_2.this,Start_3.class);
                startActivity(intent);
            }
        });
        dot1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Start_2.this,MainActivity.class);
                startActivity(intent);
            }
        });
        ignore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Start_2.this,Login.class);
                startActivity(intent);
            }
        });
        dot3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Start_2.this,Start_3.class);
                startActivity(intent);
            }
        });

    }
}