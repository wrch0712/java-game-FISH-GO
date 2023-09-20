package edu.uchicago.gerber._08final.myGame_fishGo.model;

import lombok.Data;

@Data
public class Timer {
    private long startTime;
    private long endTime;
    private long time;

    public void begin() {
        startTime = System.currentTimeMillis();
    }

    public void computeTime() {
        endTime = System.currentTimeMillis();
        time = (endTime - startTime) / 1000;
    }
}
