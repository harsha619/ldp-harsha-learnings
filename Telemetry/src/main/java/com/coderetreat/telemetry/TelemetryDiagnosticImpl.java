package com.coderetreat.telemetry;

public class TelemetryDiagnosticImpl {
    private final String DiagnosticChannelConnectionString = "*111#";
    private String diagnosticInfo = "";

    public  DataSender  dataSender;
    public  StatusProvider statusProvider;


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

        dataSender.send(TelemetryClientDataImpl.DIAGNOSTIC_MESSAGE);
        diagnosticInfo = dataSender.receive();
    }
}
