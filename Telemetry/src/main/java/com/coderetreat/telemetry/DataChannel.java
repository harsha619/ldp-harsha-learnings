package com.coderetreat.telemetry;

public interface DataChannel {
    void send(String message);
    String receive();
}
