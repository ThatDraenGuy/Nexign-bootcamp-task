package draen.data.domain.call;


import draen.data.domain.cdr.CdrFile;

import java.time.Duration;
import java.time.LocalDateTime;

public class CallInfo {
    private final CallType callType;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;
    private final Duration duration;

    public CallInfo(CallType callType, LocalDateTime startTime, LocalDateTime endTime, Duration duration) {
        this.callType = callType;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;
    }

    public CallInfo(CdrFile cdrFile) {
        this(cdrFile.getCallType(), cdrFile.getStartTime(), cdrFile.getEndTime(),
                Duration.between(cdrFile.getStartTime(), cdrFile.getEndTime()));
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

    public Duration getDuration() {
        return duration;
    }
}
