package draen.tariff;

import draen.data.domain.call.CallInfo;
import draen.data.domain.subscriber.Subscriber;
import draen.utils.DurationUtils;

import java.time.Duration;

public class UnlimitedTariff implements Tariff {
    private final Duration freeTime = Duration.ofMinutes(300);
    private final double pricedCost = 1;
    @Override
    public double getCallCost(Subscriber subscriber, CallInfo callInfo) {

        Duration currentDuration = subscriber.getCallsDuration();
        Duration newDuration = currentDuration.plus(callInfo.getDuration());
        subscriber.setCallsDuration(newDuration);

        Duration difference = newDuration.minus(freeTime);
        Duration pricedDuration;

        if (difference.isNegative() || difference.isZero()) {
            pricedDuration = Duration.ZERO;
        } else if (difference.minus(callInfo.getDuration()).isNegative()) {
            pricedDuration = difference;
        } else {
            pricedDuration = callInfo.getDuration();
        }

        return pricedCost * DurationUtils.getMinutes(pricedDuration);
    }

    @Override
    public double getTariffCost() {
        return 100;
    }
}
