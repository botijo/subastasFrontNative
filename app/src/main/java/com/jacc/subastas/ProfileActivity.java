package com.jacc.subastas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {

    private Button mButtonSignOut;
    private Button mButtonMostrarVehiculos;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    private TextView mTextViewEmail;
    private TextView mTextViewName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mButtonSignOut = (Button) findViewById(R.id.btnSiginout);
        mButtonMostrarVehiculos = (Button) findViewById(R.id.btnMostrarVehiculos);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mTextViewEmail = (TextView) findViewById(R.id.textViewEmail);
        mTextViewName = (TextView) findViewById(R.id.textViewName);

        mButtonSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                startActivity(new Intent( ProfileActivity.this, MainActivity.class));
                finish();
            }
        });

        mButtonMostrarVehiculos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this, MostrarArticuloCoche.class));
            }
        });

        getUserInfo();
    }

    private void getUserInfo(){
        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("user").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    String nombre = dataSnapshot.child("name").getValue().toString();
                    String email = dataSnapshot.child("mail").getValue().toString();

                    mTextViewName.setText(nombre);
                    mTextViewEmail.setText(email);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}