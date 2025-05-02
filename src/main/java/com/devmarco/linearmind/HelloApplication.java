package com.devmarco.linearmind;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Font.loadFont(Objects.requireNonNull(getClass().getResource("/fonts/Roboto-Bold.ttf")).toExternalForm(), 25);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/devmarco/linearmind/fxml/core.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 350, 350);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/styles/styles.css")).toExternalForm());
        stage.setTitle("LinearMind");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}