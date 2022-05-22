package com.careline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth mAuth;
   // ...
  // Initialize Firebase Auth
   private Button registerUser;
   private EditText editTextfullname,editTextemail,editTextphone,editTextpassword;


    TextView login;
    Button welcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        login=(TextView) findViewById(R.id.log);
        welcome=(Button) findViewById(R.id.insc);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Register.this,Login.class);
                startActivity(intent);
            }
        });



        ///firebase stuff

        mAuth = FirebaseAuth.getInstance();


        registerUser=(Button) findViewById(R.id.insc);
        registerUser.setOnClickListener(this);

        editTextfullname=(EditText) findViewById(R.id.input_1);
        editTextemail=(EditText) findViewById(R.id.input_2);
        editTextphone=(EditText) findViewById(R.id.input_3);
        editTextpassword=(EditText) findViewById(R.id.input_4);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.insc:
                registerUser();
                break;
        }
    }

    private void registerUser() {
        String email=editTextemail.getText().toString().trim();
        String password=editTextpassword.getText().toString().trim();
        String name=editTextfullname.getText().toString().trim();
        String phone=editTextphone.getText().toString().trim();

        if(name.isEmpty()){
            editTextfullname.setError("le nom complet est obligatoire");
            editTextfullname.requestFocus();
            return;
        }
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
        if(phone.isEmpty()){
            editTextphone.setError("le telephone est obligatoire");
            editTextphone.requestFocus();
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

        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            User user= new User(name,email,phone);
                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if(task.isSuccessful()){
                                                Toast.makeText(Register.this,"User has been added successfully",Toast.LENGTH_LONG).show();
                                            //redirect to login
                                                Intent intent=new Intent(Register.this,Login.class);
                                                startActivity(intent);
                                            }else{
                                                Toast.makeText(Register.this,"failed to register! try again!",Toast.LENGTH_LONG).show();
                                            }
                                        }
                                    });
                        }else{
                            Toast.makeText(Register.this,"failed to register! try again!",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}