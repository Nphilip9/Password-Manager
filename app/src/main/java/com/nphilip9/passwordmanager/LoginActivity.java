package com.nphilip9.passwordmanager;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nphilip9.passwordmanager.Manager.LoginManager;
import com.nphilip9.passwordmanager.Manager.UserManager;

public class LoginActivity extends AppCompatActivity {

    EditText loginActivity_editText_username, loginActivity_editText_password;
    Button loginActivity_button_login, loginActivity_button_register;

    LoginManager loginManager = new LoginManager();
    UserManager userManager = new UserManager();

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        loginActivity_editText_username = findViewById(R.id.registerActivity_editText_username);
        loginActivity_editText_password = findViewById(R.id.registerActivity_editText_password);
        loginActivity_button_login = findViewById(R.id.loginActivity_button_login);
        loginActivity_button_register = findViewById(R.id.loginActivity_button_register);

        loginActivity_button_register.setOnClickListener(v -> startRegisterActivity());

        loginActivity_button_login.setOnClickListener(v -> {
            String username = loginActivity_editText_username.getText().toString();
            String password = loginActivity_editText_password.getText().toString();
            if (username.length() != 0 && password.length() != 0) {
                try {
                    boolean checkCredentials = loginManager.checkCredentials(getFilesDir() + "/Users.txt", username, password);
                    if (checkCredentials) {
                        userManager.logUser(getCacheDir().toString(), username);
                        Toast.makeText(getApplicationContext(), "Welcome Back " + userManager.getCurrentUser(
                                getCacheDir().toString()), Toast.LENGTH_SHORT).show();
                        startHomeActivity();
                    }
                } catch(Exception e){
                    e.printStackTrace();
                }
            } else {
                Toast.makeText(getApplicationContext(), "Fail", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void startRegisterActivity() {
        Intent registerActivityIntent = new Intent(getApplicationContext(), RegisterActivity.class);
        startActivity(registerActivityIntent);
    }

    private void startHomeActivity() {
        Intent homeActivityIntent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(homeActivityIntent);
    }
}