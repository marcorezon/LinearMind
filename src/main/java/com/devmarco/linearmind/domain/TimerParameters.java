package com.devmarco.linearmind.domain;

import com.devmarco.linearmind.util.FileManager;

import java.time.Duration;

public class TimerParameters {

    private static TimerParameters instance;

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

    public static TimerParameters getInstance() {
        if (instance == null) {
            instance = new TimerParameters();
        }
        return instance;

    }

    //Controlling functions

    public void increaseCounter() {
        counter = counter.plusSeconds(1);
    }

    public void resetCounter() {
        counter = Duration.ZERO;
    }

    public String getFormattedCounter() {
        return String.format("%02d:%02d",
                counter.toMinutes() % 60,
                counter.getSeconds() % 60);
    }

    public void increaseCicles() {
        cicles++;
    }

    //Getters and setters

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

    public void setCounter(Duration newCounter) {
        this.counter = newCounter;
    }

    public int getCicles() {
        return cicles;
    }

    public void setCicles(int cicles) {
        this.cicles = cicles;
    }
}