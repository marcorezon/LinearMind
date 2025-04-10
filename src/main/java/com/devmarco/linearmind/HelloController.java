package com.devmarco.linearmind;

import com.devmarco.linearmind.domain.Clock;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class HelloController {

    private Clock clock = new Clock();

    @FXML
    private Button startButton;
    @FXML
    private Button stopButton;
    @FXML
    private Button resumeButton;
    @FXML
    private Label timer;
    @FXML
    private Label welcomeText;

    private Timeline timeline; // Timeline for label updates

    @FXML
    protected void onStartButtonClick() {
        clock.runTimer();
        startLabelUpdate();
        welcomeText.setText("Clock running");

        startButton.setDisable(true);
        stopButton.setDisable(false);
    }

    @FXML
    protected void onPauseButtonClick() {
        clock.pauseTimer();
        stopLabelUpdate();

        stopButton.setDisable(true);
        resumeButton.setDisable(false);
    }

    @FXML
    protected void onResumeButtonClick() {
        clock.runTimer();
        startLabelUpdate();

        resumeButton.setDisable(true);
        stopButton.setDisable(false);
    }

    private void startLabelUpdate() {
        if (timeline == null) {
            timeline = new Timeline(new KeyFrame(Duration.millis(500), e -> {
                timer.setText("" + clock.getTimerCounter());
            }));
            timeline.setCycleCount(Timeline.INDEFINITE);
        }
        timeline.play();
    }

    private void stopLabelUpdate() {
        if (timeline != null) {
            timeline.stop();
        }
    }
}