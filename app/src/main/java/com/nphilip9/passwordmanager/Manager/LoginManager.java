package com.nphilip9.passwordmanager.Manager;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LoginManager {

    @RequiresApi(api = Build.VERSION_CODES.O)
    public boolean checkCredentials(String filesPath,
                                    String username, String password) throws Exception {
        ArrayList<String> arrayList = new ArrayList<>();
        int lines = 0;
        FileReader fileReader = new FileReader(filesPath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while(bufferedReader.readLine() != null) {
            lines++;
        }

        for(int i = 0; i <= lines - 1; i++) {
            String data = Files.readAllLines(Paths.get(filesPath)).get(i);
            arrayList.add(data);
        }

        for(int i = 0; i <= lines - 1; i++) {
            String[] splitData = arrayList.get(i).split("#-#");
            if(splitData[0].equals(username) && splitData[1].equals(password)) {
                return true;
            }
        }
        return false;
    }
}
