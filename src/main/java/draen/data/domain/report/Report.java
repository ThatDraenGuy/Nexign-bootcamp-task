package draen.data.domain.report;

import draen.data.domain.call.CallInfo;

public class Report {
    private final CallInfo callInfo;
    private final double cost;

    public Report(CallInfo callInfo, double cost) {
        this.callInfo = callInfo;
        this.cost = cost;
    }

    public CallInfo getCallInfo() {
        return callInfo;
    }

    public double getCost() {
        return cost;
    }
}
