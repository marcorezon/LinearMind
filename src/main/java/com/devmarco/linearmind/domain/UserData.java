package com.devmarco.linearmind.domain;


public class UserData {
    private int activeTime;
    private int intervalTime;
    private int interruptionTime;

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
}
