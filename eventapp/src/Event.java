public class Event implements Comparable<Event>{
    private final String title;
    private final EventCategory category;

    public Event(String title, EventCategory category){
        if(title.isEmpty()) throw new IllegalArgumentException();
        this.title = title;
        if(category == null) throw new NullPointerException();
        this.category = category;
    }

    public String getTitle(){
        return this.title;
    }

    public EventCategory getCategory() {
        return this.category;
    }

    @Override
    public int compareTo(Event o) {
        int compareTitle = this.title.compareTo(o.getTitle());
        int compareCategory = this.category.compareTo(o.getCategory());

        if(compareTitle != 0) return compareTitle;
        else return compareCategory;

    }
}
