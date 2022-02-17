import java.util.*;

public interface EventCatalog {
    boolean addCatalogEntry(Event e, Set<Time> tSet);
    boolean addTimeToEvent(Event e, Time t);
    boolean deleteTime(Event e, Time t);
    Set<Time> deleteEvent(Event e);
    Map<Event,Set<Time>> filterByEventCategory(EventCategory category);
    Set<Time> getTimesOfEvent(Event e);
    Set<Event> getAllEvents();
}
