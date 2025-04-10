package com.devmarco.linearmind.domain;

public class Clock {
    private int timeSpan = 60;
    private int clockCicle = 0;
    private int timerCounter = 0;
    private boolean isTimeRunning = false;
    private Thread timerThread;

    public void runTimer() {
        if (isTimeRunning) return;

        isTimeRunning = true;
        timerThread = new Thread(() -> {
            while (isTimeRunning) {
                try {
                    if (timerCounter == timeSpan) {
                        pauseTimer();
                        clockCicle++;
                        timerCounter = 0;
                    }
                    Thread.sleep(1000); //Mantém a thread parada durante um segundo.
                    timerCounter++;
                    System.out.println("Time: " + timerCounter + "s");
                } catch (InterruptedException e) {
                    System.out.println("Timer paused.");
                    break;
                }
            }
        });
        timerThread.start();
    }

    public void pauseTimer() {
        isTimeRunning = false;
        if (timerThread != null && timerThread.isAlive()) {
            timerThread.interrupt();
        }
    }

    public int getClockCounter() {
        return clockCicle;
    }

    public int getTimerCounter() {
        return timerCounter;
    }

    public void getClockInformation() {
        System.out.println("Clock Cicle: " + clockCicle);
        System.out.println("Is running: " + isTimeRunning);
        System.out.println("Timer counter: " + timerCounter);
    }

    public void resetTime() {
        timerCounter = 0;
    }

    public void setTimeSpan(int value) {
        timeSpan = value;
    }
}