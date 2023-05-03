package Observer;

import event.Event;

public interface Listener {
    void handleEvent(Event event); //обработать событие

}
