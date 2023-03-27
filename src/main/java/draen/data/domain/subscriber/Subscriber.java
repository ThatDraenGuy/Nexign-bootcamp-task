package draen.data.domain.subscriber;

import draen.data.domain.cdr.CdrFile;
import draen.data.domain.call.CallReport;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Subscriber {
    private final String phoneNumber;
    private final String tariffCode;
    private double cost;
    private Duration callsDuration = Duration.ZERO;
    private final List<CallReport> callReports = new ArrayList<>();

    public Subscriber(String phoneNumber, String tariffCode, double cost) {
        this.phoneNumber = phoneNumber;
        this.tariffCode = tariffCode;
        this.cost = cost;
    }

    public Subscriber(CdrFile cdrFile, double initialCost) {
        this(cdrFile.getPhoneNumber(), cdrFile.getTariffCode(), initialCost);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getTariffCode() {
        return tariffCode;
    }

    public double getCost() {
        return cost;
    }

    public Duration getCallsDuration() {
        return callsDuration;
    }

    public void setCallsDuration(Duration callsDuration) {
        this.callsDuration = callsDuration;
    }

    public List<CallReport> getReports() {
        return callReports;
    }

    public void addReport(CallReport report) {
        callReports.add(report);
        cost += report.getCost();
    }
}
