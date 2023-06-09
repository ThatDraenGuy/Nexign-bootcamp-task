package draen.data.application;

import draen.data.domain.subscriber.Subscriber;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SubscriberStorage {
    private final Map<String, Subscriber> subscribers = new HashMap<>();

    public Subscriber get(String phoneNumber) {
        return subscribers.get(phoneNumber);
    }

    public void add(Subscriber subscriber) {
        subscribers.put(subscriber.getPhoneNumber(), subscriber);
    }

    public boolean contains(String phoneNumber) {
        return subscribers.containsKey(phoneNumber);
    }

    public Iterator<Subscriber> getAll() {
        return  subscribers.values().iterator();
    }
}
