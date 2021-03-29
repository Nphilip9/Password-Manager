package com.nphilip9.passwordmanager;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.nphilip9.passwordmanager.Manager.UserManager;

public class HomeActivity extends AppCompatActivity {

    ListView homeActivity_listView_usernamePasswords;

    UserManager userManager = new UserManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        homeActivity_listView_usernamePasswords = findViewById(R.id.homeActivity_listView_usernamePasswords);

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<>(this, R.layout.list_view_text_view,
                R.id.listViewTextView_textView_listViewTextView,
                new String[] {"hello", "Hello"});

        homeActivity_listView_usernamePasswords.setAdapter(listViewAdapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        boolean deleteUser = userManager.deleteUser(getCacheDir().toString());
        if(deleteUser) { finish(); }
    }
}
