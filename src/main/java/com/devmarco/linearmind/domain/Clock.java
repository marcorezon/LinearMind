package com.devmarco.linearmind.domain;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Clock {

    private TimerParameters timerParameters = new TimerParameters();

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
                if (shouldStop()) {
                    isTimeRunning = false;
                    timerParameters.resetCounter();
                    if (!isInterval) {
                        timerParameters.increaseCicles();
                    }
                    isInterval = !isInterval;
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

    private boolean shouldStop() {
        if (isInterval) {
            return timerParameters.getCounter() == TimerParameters.getInstance().getIntervalTime();
        }
        return timerParameters.getCounter() == TimerParameters.getInstance().getActiveTime();
    }

    public TimerParameters getTimerParameters() {
        return timerParameters;
    }

    public void setTimerParameters(TimerParameters timerParameters) {
        this.timerParameters = timerParameters;
    }
}