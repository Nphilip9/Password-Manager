package com.nphilip9.passwordmanager.Manager;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UserManager {

    public void logUser(String cacheDir, String username) throws IOException {
        boolean currentUser = new File(cacheDir + "/currentUser.txt").createNewFile();
        if (currentUser) {
            FileWriter fileWriter = new FileWriter(cacheDir + "/currentUser.txt", true);
            fileWriter.append(username);
            fileWriter.close();
        }
    }

    public boolean deleteUser(String cacheDir) {
        return new File(cacheDir + "/currentUser.txt").delete();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getCurrentUser(String cacheDir) throws IOException {
        return Files.readAllLines(Paths.get(cacheDir + "/currentUser.txt")).get(0);
    }
}
