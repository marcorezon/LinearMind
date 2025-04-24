package com.devmarco.linearmind.domain;

import com.devmarco.linearmind.util.FileManager;

public class TimerParameters {

    private static TimerParameters instance;

    private int activeTime;
    private int intervalTime;
    private int interruptionTime;

    private long counter = 0;
    private int cicles = 0;

    public TimerParameters() {
        FileManager fileManager = FileManager.getInstance();
        UserData userInfo = fileManager.readUserInfo();

        activeTime = userInfo.getActiveTime();
        intervalTime = userInfo.getIntervalTime();
        interruptionTime = userInfo.getInterruptionTime();
    }

    public static TimerParameters getInstance(){
        if (instance == null) {
            instance = new TimerParameters();
        }
        return instance;

    }

    //Controlling functions

    public void increaseCounter() {
        counter++;
    }

    public void resetCounter() {
        counter = 0;
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

    public long getCounter() {
        return counter;
    }

    public void setCounter(long counter) {
        this.counter = counter;
    }

    public int getCicles() {
        return cicles;
    }

    public void setCicles(int cicles) {
        this.cicles = cicles;
    }
}