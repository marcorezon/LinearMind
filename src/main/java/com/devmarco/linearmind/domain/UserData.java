package com.devmarco.linearmind.domain;


public class UserData {
    private String activeTime;
    private String intervalTime;
    private String interruptionTime;

    public String getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(String activeTime) {
        this.activeTime = activeTime;
    }

    public String getIntervalTime() {
        return intervalTime;
    }

    public void setIntervalTime(String intervalTime) {
        this.intervalTime = intervalTime;
    }

    public String getInterruptionTime() {
        return interruptionTime;
    }

    public void setInterruptionTime(String interruptionTime) {
        this.interruptionTime = interruptionTime;
    }
}
