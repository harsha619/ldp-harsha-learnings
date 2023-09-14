package com.coderetreat.telemetry;

public class DiagnosticImpl implements IDiagnostic{
    private String diagnosticInfo = "";
    @Override
    public void setDiagnosticInfo(String diagnosticInfo) {
        this.diagnosticInfo = diagnosticInfo;

    }

    @Override
    public String getDiagnosticInfo() {
        return diagnosticInfo;
    }
}
