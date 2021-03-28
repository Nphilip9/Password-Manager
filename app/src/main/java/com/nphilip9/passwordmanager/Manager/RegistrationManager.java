package com.nphilip9.passwordmanager.Manager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RegistrationManager {

    public boolean createUser(String filesDir, String username, String password) throws IOException {
        boolean usersDir = createUsersDir(filesDir + "/UserDirs");
        boolean userPrivateDir = createUserPrivateDir(filesDir + "/UserDirs", username);
        boolean privateUserFile = createPrivateUserFile(filesDir + "/UserDirs", username);
        boolean userListFile = createUserListFile(filesDir, username, password);
        return usersDir && userPrivateDir && privateUserFile && userListFile;
    }

    private boolean createUsersDir(String path) {
        if(new File(path).exists()) {
            return true;
        } else {
            return new File(path).mkdir();
        }
    }

    private boolean createUserPrivateDir(String path, String username) {
        if(new File(path + "/" + username).exists()) {
            return true;
        } else {
            return new File(path + "/" + username).mkdir();
        }
    }

    private boolean createPrivateUserFile(String path, String username) throws IOException {
        if(new File(path + "/" + username + "UsernamePasswords.txt").exists()) {
            return true;
        } else {
            return new File(path + "/" + username + "/UsernamePasswords.txt").createNewFile();
        }
    }

    private boolean createUserListFile(String path, String username, String password) throws IOException {
        if(new File(path + "/Users.txt").exists()) {
            FileWriter fileWriter = new FileWriter(path + "/Users.txt", true);
            fileWriter.append(username).append("#-#").append(password).append("\n");
            fileWriter.close();
        } else {
            boolean createUserListFile = new File(path + "/Users.txt").createNewFile();
            if(createUserListFile) {
                FileWriter fileWriter = new FileWriter(path + "/Users.txt", true);
                fileWriter.append(username).append("#-#").append(password).append("\n");
                fileWriter.close();
            }
        }
        return true;
    }
}
