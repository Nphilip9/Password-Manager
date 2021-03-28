package com.nphilip9.todo_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText loginActivity_editText_username, loginActivity_editText_password;
    Button loginActivity_button_login, loginActivity_button_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        loginActivity_editText_username = findViewById(R.id.registerActivity_editText_username);
        loginActivity_editText_password = findViewById(R.id.registerActivity_editText_password);
        loginActivity_button_login = findViewById(R.id.loginActivity_button_login);
        loginActivity_button_register = findViewById(R.id.loginActivity_button_register);

        loginActivity_button_register.setOnClickListener(v -> startRegisterActivity());
    }

    private void startRegisterActivity() {
        Intent registerActivityIntent = new Intent(getApplicationContext(), RegisterActivity.class);
        startActivity(registerActivityIntent);
    }
}