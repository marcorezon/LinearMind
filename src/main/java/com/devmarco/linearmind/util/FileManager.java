package com.devmarco.linearmind.util;

import com.devmarco.linearmind.domain.UserData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class FileManager {

    private static FileManager instance;

    private String userInfoDirName = "LinearMind";
    private String userInfoFileName = "userInfo.json";
    private String userInfoDir;

    private FileManager() {
        this.userInfoDir = System.getProperty("user.home") + File.separator + userInfoDirName;
        checkForUserDataExistence();
    }

    public static FileManager getInstance() {
        if (instance == null) {
            synchronized (FileManager.class) {
                if (instance == null) {
                    instance = new FileManager();
                }
            }
        }
        return instance;
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
                initializeFile(userInfoFile);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void initializeFile(File filepath) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(filepath)) {
            UserData userData = new UserData();
            userData.setActiveTime("25");
            userData.setIntervalTime("5");
            userData.setInterruptionTime("20");
            gson.toJson(userData, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeUserInfo(UserData data) {
        String filePath = userInfoDir + File.separator + userInfoFileName;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(data, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public UserData readUserInfo() {
        String filePath = userInfoDir + File.separator + userInfoFileName;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, UserData.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getFilePath() {
        return userInfoDir + userInfoFileName;
    }
}
