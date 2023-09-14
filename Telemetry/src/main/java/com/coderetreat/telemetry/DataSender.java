package com.coderetreat.telemetry;

public interface DataSender {
    void send(String message);
    String receive();
}
