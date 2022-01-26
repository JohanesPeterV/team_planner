package com.example.projectmoprog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.projectmoprog.models.User;
import com.google.android.material.snackbar.Snackbar;

public class RegisterActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etEmail;
    private EditText etPassword;
    private EditText etConfirmPassword;
    private Button btnRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Register");
        setTheme(R.style.Theme_ProjectMoprog);
        setContentView(R.layout.activity_register);

        etUsername = findViewById(R.id.et_username);
        etEmail= findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        etConfirmPassword= findViewById(R.id.et_confirmPassword);

        btnRegister = findViewById(R.id.btn_register);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    Intent i = new Intent(RegisterActivity.this, LoginActivity.class );
                    startActivity(i);
                }
                else{
                    Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Your Input Is Wrong!!!", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            }
        });
    }

    private boolean validate() {
        if(etUsername.getText().toString().equals("")) return false;
        if(etPassword.getText().toString().equals("")) return false;
        if(!etEmail.getText().toString().contains("@")) return false;
        if(etConfirmPassword.getText().toString().equals(""))return false;
        if (!etPassword.getText().toString().contentEquals(etConfirmPassword.getText().toString())) return false;
        else{
            User.setCurrUser(new User(etUsername.getText().toString(), etEmail.getText().toString()));
            return true;
        }
    }


}