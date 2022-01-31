package com.mobile_prog.team_planner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.mobile_prog.team_planner.models.User;
import com.mobile_prog.team_planner.repositories.UserRepository;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etPassword;
    private Button btnLogin;
    private Button btnRegister;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_ProjectMoprog);
        setTitle("Login");
        setContentView(R.layout.activity_login);
        etEmail = findViewById(R.id.et_login_email);
        etPassword = findViewById(R.id.et_password);
        mAuth = FirebaseAuth.getInstance();
        if(mAuth.getCurrentUser()!=null){

            String[] names=etEmail.getText().toString().split("@");

            UserRepository.login(new User(names[0], etEmail.getText().toString()));
            Intent i = new Intent(LoginActivity.this, MainActivity.class );
            startActivity(i);
        }

        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
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

    private void validate(){
        if(etEmail.getText().toString().isEmpty()||etPassword.getText().toString().isEmpty()){
            Toast.makeText(this, "Email and Password cannot be empty",Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.signInWithEmailAndPassword(etEmail.getText().toString(),etPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    String[] names=etEmail.getText().toString().split("@");

                    UserRepository.login(new User(names[0], etEmail.getText().toString()));
                    Toast.makeText(LoginActivity.this, "User logged in successfully", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(LoginActivity.this, MainActivity.class );
                    startActivity(i);
                }else{
                    Toast.makeText(LoginActivity.this, "Log in Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
};