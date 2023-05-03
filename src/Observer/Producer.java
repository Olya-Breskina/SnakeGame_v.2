package Observer;


import event.Event;

public interface Producer {
     void createEvent(Event event); //обработать событие
}
