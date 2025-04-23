package com.devmarco.linearmind.domain;

import com.devmarco.linearmind.util.FileManager;

public class TimerParameters {

    private static TimerParameters instance;

    private long activeTime;
    private long intervalTime;
    private long interruptionTime;

    private long counter = 0;
    private int cicles = 0;

    public TimerParameters() {
        FileManager fileManager = FileManager.getInstance();
        UserData userInfo = fileManager.readUserInfo();

        activeTime = Long.parseLong(userInfo.getActiveTime());
        intervalTime = Long.parseLong(userInfo.getIntervalTime());
        interruptionTime = Long.parseLong(userInfo.getInterruptionTime());
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

    public long getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(long activeTime) {
        this.activeTime = activeTime;
    }

    public long getIntervalTime() {
        return intervalTime;
    }

    public void setIntervalTime(long intervalTime) {
        this.intervalTime = intervalTime;
    }

    public long getInterruptionTime() {
        return interruptionTime;
    }

    public void setInterruptionTime(long interruptionTime) {
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