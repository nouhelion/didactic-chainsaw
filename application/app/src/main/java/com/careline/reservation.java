package com.careline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class reservation extends AppCompatActivity implements View.OnClickListener {
    ImageView leave;
    private FirebaseAuth mAuth;
    // creating a variable for our
    // Firebase Database.
    FirebaseDatabase firebaseDatabase;

    // creating a variable for our Database
    // Reference for Firebase.
    DatabaseReference databaseReference;

    // creating a variable for
    // our object class
    Reserv reserv;
    // ...
    // Initialize Firebase Auth
    private Button addReserv;
    private EditText date_pic;
    private EditText hour_pic;
    private EditText why_plai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        leave=(ImageView) findViewById(R.id.shape);
        leave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(reservation.this,rendez_vous.class);
                startActivity(intent);
            }
        });
///firebase stuff

        mAuth = FirebaseAuth.getInstance();


       addReserv=(Button) findViewById(R.id.res);
        addReserv.setOnClickListener(this);

        date_pic=(EditText) findViewById(R.id.datePicker);
        hour_pic=(EditText) findViewById(R.id.timePicker);
        why_plai=(EditText) findViewById(R.id.plai);

        // below line is used to get the
        // instance of our FIrebase database.
        firebaseDatabase = FirebaseDatabase.getInstance();

        // below line is used to get reference for our database.
        databaseReference = firebaseDatabase.getReference("reservation");

        // initializing our object
        // class variable.
        reserv = new Reserv();




    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.res:
                addReservation();
                break;
        }
    }

    private void addReservation() {
        String date=date_pic.getText().toString().trim();
        String hour=hour_pic.getText().toString().trim();
        String why=why_plai.getText().toString().trim();


        // below line is for checking weather the
        // edittext fields are empty or not.
        if (TextUtils.isEmpty(date) && TextUtils.isEmpty(hour) && TextUtils.isEmpty(why)) {
            // if the text fields are empty
            // then show the below message.
            Toast.makeText(reservation.this, "veuillez remplir", Toast.LENGTH_SHORT).show();
        } else {
            // else call the method to add
            // data to our database.
            addDatatoFirebase(date, hour, why);
        }

    }

    private void addDatatoFirebase(String date, String hour, String why) {
        // below 3 lines of code is used to set
        // data in our object class.
        reserv.setDate(date);
        reserv.setHour(hour);
        reserv.setWhy(why);

        // we are use add value event listener method
        // which is called with database reference.
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // inside the method of on Data change we are setting
                // our object class to our database reference.
                // data base reference will sends data to firebase.
                databaseReference.setValue(reserv);

                // after adding this data we are showing toast message.
                Toast.makeText(reservation.this, "data added", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // if the data is not added or it is cancelled then
                // we are displaying a failure toast message.
                Toast.makeText(reservation.this, "Fail to add data " + error, Toast.LENGTH_SHORT).show();
            }
        });

    }

}