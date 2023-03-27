package draen.data.domain.cdr;

import draen.data.domain.call.CallType;

import java.util.Date;

public class CdrFile {
    private final String phoneNumber;
    private final CallType callType;
    private final Date startTime;
    private final Date endTime;
    private final int tariffNumber;

    public CdrFile(String phoneNumber, CallType callType, Date startTime, Date endTime, int tariffNumber) {
        this.phoneNumber = phoneNumber;
        this.callType = callType;
        this.startTime = startTime;
        this.endTime = endTime;
        this.tariffNumber = tariffNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public CallType getCallType() {
        return callType;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public int getTariffNumber() {
        return tariffNumber;
    }
}
