package com.devmarco.linearmind;

import com.devmarco.linearmind.domain.Clock;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.ProgressIndicator;
import javafx.util.Duration;

public class HelloController {

    private Clock clock = new Clock();

    @FXML
    private ProgressIndicator progressBar;

    @FXML
    private Button startButton;

    @FXML
    private Button stopButton;

    @FXML
    private Button resumeButton;

    @FXML
    private Label title;

    @FXML
    private Label timer;

    @FXML
    private Label cicles;

    private Timeline timeline;

    @FXML
    protected void onStartButtonClick() {
        startLabelUpdate();
        clock.runTimer();
        displayButton(startButton, stopButton);
    }

    @FXML
    protected void onPauseButtonClick() {
        clock.pauseTimer();
        stopLabelUpdate();
        displayButton(stopButton, resumeButton);
    }

    @FXML
    protected void onResumeButtonClick() {
        clock.runTimer();
        startLabelUpdate();
        displayButton(resumeButton, stopButton);
    }

    private void displayButton(Button currentButton, Button nextButton) {
        currentButton.setVisible(false);
        nextButton.setVisible(true);
    }

    private void updateLabels() {
        cicles.setText("Cicles: " + clock.getTimerParameters().getCicles());
        if (clock.isInterval()) {
            title.setText("Interval");
        } else {
            title.setText("Timer");
        }
    }

    private void startLabelUpdate() {
        if (timeline == null) {
            timeline = new Timeline(new KeyFrame(Duration.millis(1000), e -> {
                timer.setText(clock.getTimerParameters().getCounter() + "s");
                if (clock.getTimerParameters().getCounter() == 0) {
                    displayButton(stopButton, startButton);
                    updateLabels();
                }
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