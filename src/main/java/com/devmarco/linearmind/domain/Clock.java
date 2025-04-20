package com.devmarco.linearmind.domain;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Clock {

    private TimerParameters timerParameters = new TimerParameters(10, 5);

    private boolean isTimeRunning = false;
    private boolean isInterval = false;


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
                if (timerParameters.getCounter() == timerParameters.getActiveTime()) {
                    isInterval = !isInterval;
                    isTimeRunning = false;
                    timerParameters.increaseCicles();
                    timerParameters.resetCounter();
                    return;
                }
                timerParameters.increaseCounter();
                System.out.println("Time: " + timerParameters.getCounter() + "s");
            } catch (Exception e) {
                System.out.println("Timer error.");
                scheduler.shutdown();
            }
        }, 0, 1, TimeUnit.SECONDS);
    }

    public void pauseTimer() {
        isTimeRunning = false;
    }

    public boolean isInterval() {
        return isInterval;
    }

    public TimerParameters getTimerParameters() {
        return timerParameters;
    }

    public void setTimerParameters(TimerParameters timerParameters) {
        this.timerParameters = timerParameters;
    }
}