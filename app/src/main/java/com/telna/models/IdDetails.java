package com.telna.models;

public class IdDetails {
    private int timestamp;
    private int machine;
    private int pid;
    private int increment;
    private String  creationTime;

    public IdDetails(int timestamp, int machine, int pid, int increment, String creationTime) {
        this.timestamp = timestamp;
        this.machine = machine;
        this.pid = pid;
        this.increment = increment;
        this.creationTime = creationTime;
    }
}
