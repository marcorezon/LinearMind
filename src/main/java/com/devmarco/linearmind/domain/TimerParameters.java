package com.devmarco.linearmind.domain;

public class TimerParameters {
    private long activeTime;
    private long intervalTime;

    private long counter = 0;
    private int cicles = 0;

    public TimerParameters(long activeTime, long intervalTime) {
        this.activeTime = activeTime;
        this.intervalTime = intervalTime;
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