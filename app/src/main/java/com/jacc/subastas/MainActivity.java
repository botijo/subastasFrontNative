package com.jacc.subastas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText mEditTextEmail;
    private EditText mEditTextPass;
    private Button mButtonLogin;

    FirebaseAuth mAuth;
    DatabaseReference mDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditTextEmail = (EditText) findViewById(R.id.editTextEmail);
        mEditTextPass = (EditText) findViewById(R.id.editTextPass);
        mButtonLogin = (Button) findViewById(R.id.button_login);

        mAuth = FirebaseAuth.getInstance();
        mDataBase = FirebaseDatabase.getInstance().getReference();

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }


    private void loginUser(){
        mAuth.signInWithCredential()
    }
}