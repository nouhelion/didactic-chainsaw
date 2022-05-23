package com.careline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity implements View.OnClickListener{

    private TextView register;
    private EditText editTextemail,editTextpassword;
    private Button login;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        register=(TextView) findViewById(R.id.insc);
        login=(Button)findViewById(R.id.login);
        login.setOnClickListener(this);

        editTextemail=(EditText) findViewById(R.id.input_1);
        editTextpassword=(EditText) findViewById(R.id.input_2);

        mAuth = FirebaseAuth.getInstance();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Login.this,Register.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.login:
                userLogin();
                break;
        }
    }

    private void userLogin() {
        String email=editTextemail.getText().toString().trim();
        String password=editTextpassword.getText().toString().trim();
        if(email.isEmpty()){
            editTextemail.setError("l'email est obligatoire");
            editTextemail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextemail.setError("entrez un email valid");
            editTextemail.requestFocus();
            return;
        }
        if(password.isEmpty()){
            editTextpassword.setError("le mot de passe est obligatoire");
            editTextpassword.requestFocus();
            return;
        }
        if(password.length()<6){
            editTextpassword.setError("le mot de passe est invalide");
            editTextpassword.requestFocus();
            return;
        }
       mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
           @Override
           public void onComplete(@NonNull Task<AuthResult> task) {
               if(task.isSuccessful()){
                   //redirect to welcome
                   Intent intent=new Intent(Login.this,Welcome.class);
                   startActivity(intent);
                }
               else{
                   Toast.makeText(Login.this,"failed to connect! try again!",Toast.LENGTH_LONG).show();
               }
           }
       });
    }
}