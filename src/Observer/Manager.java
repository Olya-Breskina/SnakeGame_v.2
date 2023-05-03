package Observer;

import event.Event;

public interface Manager {
    void handleEvent(Event event);
    void addListener(Event event, Listener listener);//добавить наблюдателя

    void removeListener(Event event, Listener listener);//удалить наблюдателя (подписчика)
}
