import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class EventCatalogImpl extends TreeMap<Event, Set<Time>> implements EventCatalog {
    static final long serialVersionUID = 42L;
    private final Map<Event, Set<Time>> catalogEntrys;
    
    public EventCatalogImpl(){
        catalogEntrys = new TreeMap<>();
    }
    
    @Override
    public boolean addCatalogEntry(Event e, Set<Time> tSet) {
        if(e == null || tSet == null) throw new NullPointerException();
        for(Time t : tSet){
            if(t == null) throw new NullPointerException();
        }

        if(catalogEntrys.containsKey(e)) return false;
        catalogEntrys.put(e, tSet);
        return true;
    }

    @Override
    public boolean addTimeToEvent(Event e, Time t) {
        if(e == null || t == null) throw new NullPointerException();
        Set<Time> savedTimesToEvent = catalogEntrys.get(e);
        if(savedTimesToEvent == null || savedTimesToEvent.contains(t)) return false;
        savedTimesToEvent.add(t);
        catalogEntrys.put(e, savedTimesToEvent);
        return true;
    }

    @Override
    public boolean deleteTime(Event e, Time t) {
        if(e == null || t == null) throw new NullPointerException();
        if(!catalogEntrys.containsKey(e)) return false;

        Set<Time> savedTimes = catalogEntrys.get(e);
        if(!savedTimes.contains(t)) return false;
        savedTimes.remove(t);
        catalogEntrys.put(e,savedTimes);
        return true;
    }

    @Override
    public Set<Time> deleteEvent(Event e) {
        return catalogEntrys.remove(e);
    }

    @Override
    public Map<Event, Set<Time>> filterByEventCategory(EventCategory category) {
        Map<Event, Set<Time>> filteredCatalogEntrys = new TreeMap<>();
        if(category == null) throw new NullPointerException();

        for (Map.Entry<Event, Set<Time>> entry : catalogEntrys.entrySet()) {
            if(!(entry.getKey().getCategory() == category)) continue;
            filteredCatalogEntrys.put(entry.getKey(), entry.getValue());
        }

        return filteredCatalogEntrys;
    }

    @Override
    public Set<Time> getTimesOfEvent(Event e) {
        return catalogEntrys.getOrDefault(e, null);
    }

    @Override
    public Set<Event> getAllEvents() {
        return catalogEntrys.keySet();
    }
}
