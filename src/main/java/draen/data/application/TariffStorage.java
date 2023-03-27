package draen.data.application;

import draen.tariff.Tariff;

import java.util.HashMap;
import java.util.Map;

public class TariffStorage {
    private final Map<String, Tariff> tariffs = new HashMap<>();

    public Tariff get(String code) {
        return tariffs.get(code);
    }

    public void add(Tariff tariff) {
        tariffs.put(tariff.getTariffCode(), tariff);
    }
}
