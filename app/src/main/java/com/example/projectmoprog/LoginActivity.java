package com.example.projectmoprog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.projectmoprog.models.User;
import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;
    private Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Login");
        setTheme(R.style.Theme_ProjectMoprog);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);

        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    Intent i = new Intent(LoginActivity.this, MainActivity.class );
                   // User.setCurrUser(new User(etUsername.getText().toString(), "temporer email"));
                    startActivity(i);
                }
                else{

                        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "User Not Registered!!", Snackbar.LENGTH_LONG);
                        snackbar.show();
                        //Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Input Credential First!!!", Snackbar.LENGTH_LONG);
                        //snackbar.show();

                }
            }
        });
        btnRegister = findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class );
                startActivity(i);
            }
        });
    }

    //private boolean validate(){
     //   if(etUsername.getText().toString().equals("")) return false;
     //   if(etPassword.getText().toString().equals("")) return false;
   //     else return true;
   // }
    private boolean validate(){
        if(User.getCurrUser() == null) return false;
      if(!etUsername.getText().toString().equals(User.getCurrUser().getName().toString())) return false;
     if(etPassword.getText().toString().equals("")) return false;
    else return true;
   }


}