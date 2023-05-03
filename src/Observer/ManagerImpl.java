package Observer;

import event.Event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManagerImpl implements Manager {
    private final Map<Event, List<Listener>> eventListenerMap;

    public ManagerImpl() {
        eventListenerMap = new HashMap<>();
    }

    @Override
    public void handleEvent(Event event) {
        if (eventListenerMap.containsKey(event)) {
            List<Listener> listeners = eventListenerMap.get(event);
            listeners.forEach(listener -> listener.handleEvent(event));
        }
    }

    @Override
    public void addListener(Event event, Listener listener) {
        if (!(eventListenerMap.containsKey(event))){
            eventListenerMap.put(event, new ArrayList<>());
        }
        List<Listener> listeners = eventListenerMap.get(event);
        if (!(listeners.contains(listener))){
            listeners.add(listener);
        }
    }

    @Override
    public void removeListener(Event event, Listener listener) {
        if (eventListenerMap.containsKey(event)){
            List<Listener> listeners = eventListenerMap.get(event);
            if (!(listeners.contains(listener))) {
                listeners.remove(listener);
            }
        }
    }
}
