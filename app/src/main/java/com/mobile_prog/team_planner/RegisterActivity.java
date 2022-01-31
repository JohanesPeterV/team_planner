package com.mobile_prog.team_planner;

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
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etEmail;
    private EditText etPassword;
    private EditText etConfirmPassword;
    private Button btnRegister;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Register");
        setTheme(R.style.Theme_ProjectMoprog);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        etUsername = findViewById(R.id.et_name);
        etEmail= findViewById(R.id.et_login_email);
        etPassword = findViewById(R.id.et_password);
        etConfirmPassword= findViewById(R.id.et_confirmPassword);

        btnRegister = findViewById(R.id.btn_register);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });
    }

    private void validate() {
        if(etUsername.getText().toString().equals("")) {


            Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Username cannot be empty.", Snackbar.LENGTH_LONG);
            snackbar.show();
        }
        else if(etPassword.getText().toString().equals("")) {
            Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Password cannot be empty.", Snackbar.LENGTH_LONG);
            snackbar.show();

        }
        else if(!etEmail.getText().toString().contains("@")) {

            Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Email should containt @.", Snackbar.LENGTH_LONG);
            snackbar.show();

        }
        else if(etConfirmPassword.getText().toString().equals("")) {

            Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Confirm password should not be empty.", Snackbar.LENGTH_LONG);
            snackbar.show();

        }
        else if (!etPassword.getText().toString().contentEquals(etConfirmPassword.getText().toString())) {

            Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Password and confirm password should match.", Snackbar.LENGTH_LONG);
            snackbar.show();

        }
        else{

            // test something, pls do remove this line on next commit

            mAuth.createUserWithEmailAndPassword(etEmail.getText().toString(),etPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(RegisterActivity.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    }else{
                        Toast.makeText(RegisterActivity.this, "Registration Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }


}