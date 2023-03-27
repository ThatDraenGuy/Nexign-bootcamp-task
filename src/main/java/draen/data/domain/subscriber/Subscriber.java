package draen.data.domain.subscriber;

import draen.data.domain.report.Report;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Subscriber {
    private final String phoneNumber;
    private final int tariffNumber;
    private Duration callsDuration = Duration.ZERO;
    private final List<Report> reports = new ArrayList<>();

    public Subscriber(String phoneNumber, int tariffNumber) {
        this.phoneNumber = phoneNumber;
        this.tariffNumber = tariffNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getTariffNumber() {
        return tariffNumber;
    }

    public Duration getCallsDuration() {
        return callsDuration;
    }

    public void setCallsDuration(Duration callsDuration) {
        this.callsDuration = callsDuration;
    }

    public List<Report> getReports() {
        return reports;
    }
}
