package com.nphilip9.passwordmanager;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.nphilip9.passwordmanager.Manager.UserManager;

public class HomeActivity extends AppCompatActivity {

    UserManager userManager = new UserManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        userManager.deleteUser(getCacheDir().toString());
    }
}
