package com.nphilip9.passwordmanager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.nphilip9.passwordmanager.Manager.GetUsernameListManager;
import com.nphilip9.passwordmanager.Manager.UserManager;

import java.io.IOException;
import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ListView homeActivity_listView_usernamePasswords;
    FloatingActionButton homeActivity_fab_add;

    UserManager userManager = new UserManager();
    GetUsernameListManager usernameListManager = new GetUsernameListManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        homeActivity_listView_usernamePasswords = findViewById(R.id.homeActivity_listView_usernamePasswords);
        homeActivity_fab_add = findViewById(R.id.homeActivity_fab_add);

        homeActivity_fab_add.setOnClickListener(v -> startAddActivity());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        boolean deleteUser = userManager.deleteUser(getCacheDir().toString());
        if(deleteUser) { finish(); }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onResume() {
        super.onResume();
        displayUsernamePassword();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void displayUsernamePassword() {
        try {
            ArrayList<String> usernameList = usernameListManager.getUsernameList(getFilesDir().toString(), userManager.getCurrentUser(getCacheDir().toString()));
            ArrayList<String> passwordList = usernameListManager.getPasswordList(getFilesDir().toString(), userManager.getCurrentUser(getCacheDir().toString()));
            ArrayAdapter<String> listViewAdapter = new ArrayAdapter<>(this, R.layout.list_view_text_view,
                    R.id.listViewTextView_textView_listViewTextView, usernameList);
            homeActivity_listView_usernamePasswords.setAdapter(listViewAdapter);

            homeActivity_listView_usernamePasswords.setOnItemClickListener((parent, view, position, id) -> {
                Toast.makeText(getApplicationContext(), passwordList.get(position), Toast.LENGTH_SHORT).show();
            });

            homeActivity_listView_usernamePasswords.setOnItemLongClickListener((parent, view, position, id) -> {
                Toast.makeText(getApplicationContext(), usernameList.get(position), Toast.LENGTH_SHORT).show();
                return true;
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void startAddActivity() {
        Intent addActivityIntent = new Intent(getApplicationContext(), AddActivity.class);
        startActivity(addActivityIntent);
    }
}
