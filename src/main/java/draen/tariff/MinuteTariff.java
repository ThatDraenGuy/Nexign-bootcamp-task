package draen.tariff;

import draen.data.domain.call.CallInfo;
import draen.data.domain.subscriber.Subscriber;
import draen.utils.DurationUtils;

import java.time.Duration;


public class MinuteTariff implements SimpleTariff {
    private final double minuteCost = 1.5;
    @Override
    public double getCallCost(Subscriber subscriber, CallInfo callInfo) {
        return getCostFromDuration(callInfo.getDuration());
    }

    @Override
    public double getTariffCost() {
        return 0;
    }

    @Override
    public double getCostFromDuration(Duration duration) {
        return minuteCost * DurationUtils.getMinutes(duration);
    }
}
