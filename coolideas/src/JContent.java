import java.util.LinkedHashSet;
import java.util.Set;

public abstract class JContent{
    private String title;
    private String description;
    private Set<ContentObserver> observerList;

    public JContent(String title, String description){
        if(title.isEmpty() || description.isEmpty()) throw new IllegalArgumentException();
        this.observerList = new LinkedHashSet<>();
        this.description = description;
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description){
        if(description.isEmpty()) throw new IllegalArgumentException();
        if(description == null) throw new NullPointerException();
        this.description = description;
        for(ContentObserver contobs : observerList){
            contobs.update(this);
        }
    }

    public void setTitle(String title) {
        if(title.isEmpty()) throw new IllegalArgumentException();
        if(title == null) throw new NullPointerException();
        this.title = title;
        for(ContentObserver contobs : observerList){
            contobs.update(this);
        }
    }

    public String getTitle(){
        return this.title;
    }

    public void addObserver(ContentObserver observer) {
        if(observer == null) throw new NullPointerException();
        observerList.add(observer);
    }

    public void removeObserver(ContentObserver observer){
        if(observer == null) throw new NullPointerException();
        observerList.remove(observer);
    }

    public int countObservers() {
        return observerList.size();
    }

    @Override
    public abstract String toString();
}