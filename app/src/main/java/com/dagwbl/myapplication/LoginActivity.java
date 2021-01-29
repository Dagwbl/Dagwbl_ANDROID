package com.dagwbl.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private Button btnLogin;
    private EditText etUser;
    private EditText etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btnLogin);
        etPassword = findViewById(R.id.etPassword);
        etUser = findViewById(R.id.etUser);

        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
           public void onClick(View view){
               Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
           }
        });


    }
}