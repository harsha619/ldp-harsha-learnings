package com.coderetreat.telemetry;

public class DiagnosticControllerImpl extends  DiagnosticImpl{
    public  DataSender  dataSender;
    public  StatusProvider statusProvider;
    private final String DiagnosticChannelConnectionString = "*111#";
    private String diagnosticInfo = "";
    public void checkTransmission() throws Exception
    {
        setDiagnosticInfo("");

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
