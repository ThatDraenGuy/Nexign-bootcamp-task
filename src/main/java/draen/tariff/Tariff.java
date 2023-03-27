package draen.tariff;

import draen.data.domain.call.CallInfo;
import draen.data.domain.subscriber.Subscriber;

public interface Tariff {
    double getCallCost(Subscriber subscriber, CallInfo callInfo);
    double getTariffCost();
}
