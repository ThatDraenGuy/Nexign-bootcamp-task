package draen.tariff;

import draen.data.domain.call.CallInfo;
import draen.data.domain.subscriber.Subscriber;

public interface Tariff {
    String getTariffCode();
    double getCallCost(Subscriber subscriber, CallInfo callInfo);
    double getTariffCost();
}
