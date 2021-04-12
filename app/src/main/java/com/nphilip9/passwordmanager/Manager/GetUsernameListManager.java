package com.nphilip9.passwordmanager.Manager;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class GetUsernameListManager {

    @RequiresApi(api = Build.VERSION_CODES.O)
    public ArrayList<String> getUsernameList(String filesPath, String currentUser) throws IOException {
        String fullPath = filesPath + "/UserDirs/" + currentUser + "/UsernamePasswords.txt";
        ArrayList<String> arrayList = new ArrayList<>();
        int lines = 0;
        FileReader fileReader = new FileReader(fullPath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while(bufferedReader.readLine() != null) {
            lines++;
        }

        for(int i = 0; i <= lines - 1; i++) {
            String data = Files.readAllLines(Paths.get(fullPath)).get(i);
            String[] split = data.split("#-#");
            arrayList.add(split[0]);
        }
        return arrayList;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public ArrayList<String> getPasswordList(String filesPath, String currentUser) throws IOException {
        String fullPath = filesPath + "/UserDirs/" + currentUser + "/UsernamePasswords.txt";
        ArrayList<String> arrayList = new ArrayList<>();
        int lines = 0;
        FileReader fileReader = new FileReader(fullPath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while(bufferedReader.readLine() != null) {
            lines++;
        }

        for(int i = 0; i <= lines - 1; i++) {
            String data = Files.readAllLines(Paths.get(fullPath)).get(i);
            String[] split = data.split("#-#");
            arrayList.add(split[1]);
        }
        return arrayList;
    }
}
