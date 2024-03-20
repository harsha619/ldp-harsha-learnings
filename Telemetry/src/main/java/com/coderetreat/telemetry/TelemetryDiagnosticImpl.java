package com.coderetreat.telemetry;

public class TelemetryDiagnosticImpl {
    private final String DiagnosticChannelConnectionString = "*111#";
    private String diagnosticInfo = "";

    private   DataChannel  dataChannel;
    private   StatusProvider statusProvider;
    public  TelemetryDiagnosticImpl(){
        statusProvider= new TelemetryStatusImpl();
        dataChannel= new TelemetryClientDataImpl();
    }

    public void checkTransmission() throws Exception
    {
        diagnosticInfo = "";

        statusProvider.disconnect();

        int retryLeft = 3;
        while (statusProvider.getOnlineStatus() == false && retryLeft > 0)
        {
            statusProvider.connect(DiagnosticChannelConnectionString);
            retryLeft -= 1;
        }

        if(statusProvider.getOnlineStatus() == false)
        {
            throw new Exception("Unable to connect.");
        }

        dataChannel.send(TelemetryClientDataImpl.DIAGNOSTIC_MESSAGE);
        diagnosticInfo = dataChannel.receive();
    }
}
