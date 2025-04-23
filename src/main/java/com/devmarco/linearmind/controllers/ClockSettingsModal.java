package com.devmarco.linearmind.controllers;

import com.devmarco.linearmind.domain.TimerParameters;
import com.devmarco.linearmind.domain.UserData;
import com.devmarco.linearmind.util.FileManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

public class ClockSettingsModal {

    private Boolean hasParameterAlteration = false;

    private Stage modalStage;

    private final TimerParameters timerParameters = TimerParameters.getInstance();

    @FXML
    private Label timer;

    @FXML
    private Label interval;

    @FXML
    private Label interruption;

    @FXML
    private Slider timerSlider;

    @FXML
    private Slider intervalSlider;

    @FXML
    private Slider interruptionSlider;

    public void setStage(Stage modalStage) {
        this.modalStage = modalStage;
    }

    @FXML
    private void closeModal() {
        if (hasParameterAlteration) {
            FileManager fileManager = FileManager.getInstance();
            UserData userData = new UserData();

            userData.setActiveTime("" + timerParameters.getActiveTime());
            userData.setIntervalTime("" + timerParameters.getIntervalTime());
            userData.setInterruptionTime("" + timerParameters.getInterruptionTime());

            fileManager.writeUserInfo(userData);
        }

        if (modalStage != null) {
            modalStage.close();
        }
    }

    public void initialize() {
        timer.setText(timerParameters.getActiveTime() + " minutes");
        interval.setText(timerParameters.getIntervalTime() + " minutes");
        interruption.setText(timerParameters.getInterruptionTime() + " minutes");

        timerSlider.setValue(timerParameters.getActiveTime());
        timerSlider.setMax(60);
        timerSlider.setMin(10);
        timerSlider.setBlockIncrement(5);

        intervalSlider.setValue(timerParameters.getIntervalTime());
        intervalSlider.setMax(10);
        intervalSlider.setMin(1);

        interruptionSlider.setValue(timerParameters.getInterruptionTime());
        interruptionSlider.setMax(120);
        interruptionSlider.setMin(0);
        interruptionSlider.setBlockIncrement(10);

        timerSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            timerParameters.setActiveTime(newValue.intValue());
            timer.setText(newValue.intValue() + " minutes");
            hasParameterAlteration = true;
        });

        intervalSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            timerParameters.setIntervalTime(newValue.intValue());
            interval.setText(newValue.intValue() + " minutes");
            hasParameterAlteration = true;
        });

        interruptionSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            timerParameters.setInterruptionTime(newValue.intValue());
            interruption.setText(newValue.intValue() + " minutes");
            hasParameterAlteration = true;
        });
    }
}