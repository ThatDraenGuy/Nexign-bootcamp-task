package draen.data.domain.cdr;

import draen.data.domain.call.CallType;

import java.time.LocalDateTime;

public class CdrFile {
    private final String phoneNumber;
    private final CallType callType;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;
    private final String tariffCode;

    public CdrFile(String phoneNumber, CallType callType, LocalDateTime startTime,
                   LocalDateTime endTime, String tariffCode) {
        this.phoneNumber = phoneNumber;
        this.callType = callType;
        this.startTime = startTime;
        this.endTime = endTime;
        this.tariffCode = tariffCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public CallType getCallType() {
        return callType;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public String getTariffCode() {
        return tariffCode;
    }
}
