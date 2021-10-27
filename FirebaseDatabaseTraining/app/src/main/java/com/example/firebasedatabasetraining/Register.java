package com.example.firebasedatabasetraining;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class Register extends AppCompatActivity {

    private Button btnSignUp;
    private EditText txtEmail, txtPassword;
    Boolean passIsgood = true;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        btnSignUp = findViewById(R.id.btnSignUp);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });
    }


    private void signUp(){
        String email = txtEmail.getText().toString().trim();
        String password = txtPassword.getText().toString().trim();
        validatePassword();

        if(email.equals("") || password.equals("")){
            Toast.makeText(Register.this, "Empty credentials!", Toast.LENGTH_SHORT).show();
        }else if(password.length() < 6 || !passIsgood){
            Toast.makeText(Register.this, "Password must contain upper and lower case letters and numbers!", Toast.LENGTH_SHORT).show();
            passIsgood = true;
        }else{
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful() && passIsgood){
                        Toast.makeText(Register.this, "Registered successfully!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Register.this, Home.class));
                    }else{
                        Toast.makeText(Register.this, "User Already Exists or Wrong Email", Toast.LENGTH_SHORT).show();
                        passIsgood = true;
                    }
                }
            });
        }

    }

    public void validatePassword(){
        Pattern upperCase = Pattern.compile("[A-Z]");
        Pattern lowerCase = Pattern.compile("[a-z]");
        Pattern digitCase = Pattern.compile("[0-9]");
        if(!lowerCase.matcher(txtPassword.getText().toString().trim()).find()){
            passIsgood = false;
        }
        if(!upperCase.matcher(txtPassword.getText().toString().trim()).find() ){
            passIsgood = false;
        }
        if(!digitCase.matcher(txtPassword.getText().toString().trim()).find()){
            passIsgood = false;
        }
        System.out.println(txtPassword.getText().toString() + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ "+passIsgood);
    }

}