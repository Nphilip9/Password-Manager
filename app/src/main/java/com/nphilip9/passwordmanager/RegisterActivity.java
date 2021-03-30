package com.nphilip9.passwordmanager;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.nphilip9.passwordmanager.Manager.RegistrationManager;

public class RegisterActivity extends AppCompatActivity {

    EditText registerActivity_editText_username, registerActivity_editText_password;
    Button registerActivity_button_register;

    RegistrationManager registrationManager = new RegistrationManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        registerActivity_editText_username = findViewById(R.id.registerActivity_editText_username);
        registerActivity_editText_password = findViewById(R.id.registerActivity_editText_password);
        registerActivity_button_register = findViewById(R.id.registerActivity_button_register);

        registerActivity_button_register.setOnClickListener(v -> {
            String username = registerActivity_editText_username.getText().toString();
            String password = registerActivity_editText_password.getText().toString();
            if (username.length() != 0 && password.length() != 0) {
                try {
                    boolean registration = registrationManager.createUser(getFilesDir().toString(), username, password);
                    if (registration) {
                        Toast.makeText(getApplicationContext(), "Success!", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Toast.makeText(getApplicationContext(), "Fail", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}