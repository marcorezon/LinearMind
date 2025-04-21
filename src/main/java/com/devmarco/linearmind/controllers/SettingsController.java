package com.devmarco.linearmind.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class SettingsController {
    @FXML
    private MenuItem clockSettings;

    @FXML
    private MenuItem blockWebsite;

    @FXML
    private MenuItem blockApplication;

    public void displayClockSettingsModal() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/devmarco/linearmind/fxml/modal/clockSettingsModal.fxml"));
            Parent root = fxmlLoader.load();

            Stage modalStage = new Stage();
            modalStage.initStyle(StageStyle.UNDECORATED);
            modalStage.initModality(Modality.APPLICATION_MODAL);
            modalStage.setTitle("Clock Settings");

            Scene scene = new Scene(root);
            modalStage.setScene(scene);

            // Pass the Stage to the controller
            ClockSettingsModal controller = fxmlLoader.getController();
            controller.setStage(modalStage);

            modalStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao carregar o modal: " + e.getMessage());
        }
    }
}

