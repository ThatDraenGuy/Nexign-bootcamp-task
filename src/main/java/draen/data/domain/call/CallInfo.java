package draen.data.domain.call;


import java.time.Duration;
import java.util.Date;

public class CallInfo {
    private final CallType callType;
    private final Date startTime;
    private final Date endTime;
    private final Duration duration;

    public CallInfo(draen.data.domain.call.CallType callType, Date startTime, Date endTime, Duration duration) {
        this.callType = callType;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;
    }

    public draen.data.domain.call.CallType getCallType() {
        return callType;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public Duration getDuration() {
        return duration;
    }
}
