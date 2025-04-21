package com.devmarco.linearmind.domain;

public class TimerParameters {
    private static long activeTime;
    private static long intervalTime;
    private static long interruptionTime;

    private long counter = 0;
    private int cicles = 0;

    public TimerParameters(long activeTime, long intervalTime, long interruptionTime) {
        TimerParameters.activeTime = activeTime;
        TimerParameters.intervalTime = intervalTime;
        TimerParameters.interruptionTime = interruptionTime;
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

    //Static
    public static long getActiveTime() {
        return activeTime;
    }

    public static void setActiveTime(long activeTime) {
        TimerParameters.activeTime = activeTime;
    }

    public static long getIntervalTime() {
        return intervalTime;
    }

    public static void setIntervalTime(long intervalTime) {
        TimerParameters.intervalTime = intervalTime;
    }

    public static long getInterruptionTime() {
        return interruptionTime;
    }

    public static void setInterruptionTime(long interruptionTime) {
        TimerParameters.interruptionTime = interruptionTime;
    }

    //Non static
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