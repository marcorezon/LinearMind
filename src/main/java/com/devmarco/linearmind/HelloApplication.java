package com.devmarco.linearmind;

import com.devmarco.linearmind.util.FileManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    FileManager fileManager = new FileManager();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/devmarco/linearmind/fxml/core.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 350, 350);
        stage.setTitle("LinearMind");
        stage.setScene(scene);
        stage.show();
        fileManager.getFilePath();
    }

    public static void main(String[] args) {
        launch();
    }
}