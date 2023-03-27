package draen.tariff;

import java.time.Duration;

public interface SimpleTariff extends Tariff {
    double getCostFromDuration(Duration duration);
}
