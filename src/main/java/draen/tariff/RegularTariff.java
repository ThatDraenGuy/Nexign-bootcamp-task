package draen.tariff;

import draen.data.domain.call.CallInfo;
import draen.data.domain.call.CallType;
import draen.data.domain.subscriber.Subscriber;
import draen.utils.DurationUtils;

import java.time.Duration;

public class RegularTariff implements Tariff {
    private final SimpleTariff fullPriceTariff = new MinuteTariff();
    private final Duration discountTime = Duration.ofMinutes(100);
    private final double minuteCost = 0.5;
    @Override
    public double getCallCost(Subscriber subscriber, CallInfo callInfo) {
        if (callInfo.getCallType().equals(CallType.INCOMING)) return 0;

        Duration currentDuration = subscriber.getCallsDuration();
        Duration newDuration = currentDuration.plus(callInfo.getDuration());
        subscriber.setCallsDuration(newDuration);

        Duration difference = newDuration.minus(discountTime);
        Duration discountDuration;
        Duration fullPriceDuration;

        if (difference.isNegative() || difference.isZero()) {
            discountDuration = callInfo.getDuration();
            fullPriceDuration = Duration.ZERO;
        } else if (difference.minus(callInfo.getDuration()).isNegative()) {
            discountDuration = callInfo.getDuration().minus(difference);
            fullPriceDuration = difference;
        } else {
            discountDuration = Duration.ZERO;
            fullPriceDuration = callInfo.getDuration();
        }

        return minuteCost * DurationUtils.getMinutes(discountDuration) +
                fullPriceTariff.getCostFromDuration(fullPriceDuration);
    }

    @Override
    public double getTariffCost() {
        return 0;
    }
}
