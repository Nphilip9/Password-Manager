package com.nphilip9.passwordmanager;

import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.nphilip9.passwordmanager.Manager.UserManager;

import java.io.FileWriter;
import java.io.IOException;

public class AddActivity extends AppCompatActivity {

    EditText addActivity_editText_username, addActivity_editText_password;
    Button addActivity_button_add;

    UserManager userManager = new UserManager();

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);

        addActivity_editText_username = findViewById(R.id.addActivity_editText_username);
        addActivity_editText_password = findViewById(R.id.addActivity_editText_password);
        addActivity_button_add = findViewById(R.id.addActivity_button_add);

        addActivity_button_add.setOnClickListener(v -> {
            String username = addActivity_editText_username.getText().toString();
            String password = addActivity_editText_password.getText().toString();
            if(username.length() != 0 && password.length() != 0) {
                try {
                    add(username, password);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                Toast.makeText(getApplicationContext(), "Fail", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void add(String username, String password) throws IOException {
        FileWriter fileWriter = new FileWriter(getFilesDir() + "/UserDirs/" +
                userManager.getCurrentUser(getCacheDir().toString()) + "/UsernamePasswords.txt", true);
        fileWriter.append(username).append("#-#").append(password).append("\n");
        fileWriter.close();
    }
}
