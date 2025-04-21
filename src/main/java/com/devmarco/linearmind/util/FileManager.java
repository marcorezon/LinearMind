package com.devmarco.linearmind.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    private String userInfoDirName = "LinearMind";
    private String userInfoFileName = "userInfo.json";

    private String userInfoDir;

    public FileManager() {
        this.userInfoDir = System.getProperty("user.home") + userInfoDirName;
        checkForUserDataExistence();
    }

    private void checkForUserDataExistence() {
        File directory = new File(userInfoDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        File userInfoFile = new File(userInfoDir + File.separator + userInfoFileName);
        try {
            if (!userInfoFile.exists()) {
                userInfoFile.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeUserInfo(Object data) {
        String filePath = userInfoDir + File.separator + userInfoFileName;
        Gson userData = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(filePath)) {
            userData.toJson(data, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFilePath(String fileName) {
        return userInfoDir + fileName;
    }
}
