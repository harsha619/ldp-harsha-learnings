package com.coderetreat.telemetry;

public interface StatusProvider {
    boolean getOnlineStatus();
    void connect(String telemetryServerConnectionString);
    void disconnect();
}
