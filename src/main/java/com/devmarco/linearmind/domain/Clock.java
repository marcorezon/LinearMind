package com.devmarco.linearmind.domain;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Clock {
    private int timeSpan = 10;
    private int clockCicles = 0;
    private int timerCounter = 0;
    private boolean isTimeRunning = false;


    public void runTimer() {
        if (isTimeRunning) return;

        isTimeRunning = true;
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

        scheduler.scheduleAtFixedRate(() -> {
            if (!isTimeRunning) {
                scheduler.shutdown();
                return;
            }

            try {
                if (timerCounter == timeSpan) {
                    isTimeRunning = false;
                    clockCicles++;
                    timerCounter = 0;
                    return;
                }
                timerCounter++;
                System.out.println("Time: " + timerCounter + "s");
            } catch (Exception e) {
                System.out.println("Timer error.");
                scheduler.shutdown();
            }
        }, 0, 1, TimeUnit.SECONDS);
    }

    public void pauseTimer() {
        isTimeRunning = false;
    }

    public int getClockCicles() {
        return clockCicles;
    }

    public int getTimerCounter() {
        return timerCounter;
    }

    public int calculateProgress() {
        return (timerCounter * 100 / timeSpan);
    }

    public void setTimeSpan(int value) {
        timeSpan = value;
    }
}