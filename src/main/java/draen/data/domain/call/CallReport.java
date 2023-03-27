package draen.data.domain.call;


public class CallReport implements Comparable<CallReport> {
    private final CallInfo callInfo;
    private final double cost;

    public CallReport(CallInfo callInfo, double cost) {
        this.callInfo = callInfo;
        this.cost = cost;
    }

    public CallInfo getCallInfo() {
        return callInfo;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public int compareTo(CallReport report) {
        return this.callInfo.getStartTime().compareTo(report.callInfo.getStartTime());
    }
}
