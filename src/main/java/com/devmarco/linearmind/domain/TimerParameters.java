package com.devmarco.linearmind.domain;

import com.devmarco.linearmind.util.FileManager;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;

import java.time.Duration;

public class TimerParameters {

    private static TimerParameters instance;

    private final SimpleStringProperty formattedCounter = new SimpleStringProperty("00:00");

    private int activeTime;
    private int intervalTime;
    private int interruptionTime;

    private Duration counter = Duration.ZERO;

    private int cicles = 0;

    public TimerParameters() {
        FileManager fileManager = FileManager.getInstance();
        UserData userInfo = fileManager.readUserInfo();

        activeTime = userInfo.getActiveTime();
        intervalTime = userInfo.getIntervalTime();
        interruptionTime = userInfo.getInterruptionTime();
    }

    //Controlling functions
    public void increaseCounter() {
        counter = counter.plusSeconds(1);
        formatCounter();
    }

    public void increaseCicles() {
        cicles++;
    }

    public void resetCounter() {
        counter = Duration.ZERO;
    }

    public void formatCounter() {
        Platform.runLater(() -> {
            formattedCounter.set(String.format("%02d:%02d", counter.toMinutes() % 60, counter.getSeconds() % 60));
        });
    }

    //Getters and setters

    public static TimerParameters getInstance() {
        if (instance == null) {
            instance = new TimerParameters();
        }
        return instance;

    }

    public static void setInstance(TimerParameters instance) {
        TimerParameters.instance = instance;
    }

    public String getFormattedCounter() {
        return formattedCounter.get();
    }

    public SimpleStringProperty formattedCounterProperty() {
        return formattedCounter;
    }

    public int getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(int activeTime) {
        this.activeTime = activeTime;
    }

    public int getIntervalTime() {
        return intervalTime;
    }

    public void setIntervalTime(int intervalTime) {
        this.intervalTime = intervalTime;
    }

    public int getInterruptionTime() {
        return interruptionTime;
    }

    public void setInterruptionTime(int interruptionTime) {
        this.interruptionTime = interruptionTime;
    }

    public Duration getCounter() {
        return counter;
    }

    public void setCounter(Duration counter) {
        this.counter = counter;
    }

    public int getCicles() {
        return cicles;
    }

    public void setCicles(int cicles) {
        this.cicles = cicles;
    }
}