package com.example.mystudyplanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity implements View.OnClickListener {
    Button btnLogin, btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnLogin.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);
    }
    Intent intent;
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogin:
                intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.btnSignUp:
                intent = new Intent(Login.this, Register.class);
                startActivity(intent);
                break;
        }
    }
}
