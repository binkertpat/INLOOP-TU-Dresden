import java.util.LinkedHashSet;
import java.util.Set;

public class JMember implements ContentObserver{
    private Set<JTopic> topicList;

    public JMember(){
        topicList = new LinkedHashSet<>();
    }

    @Override
    public void update(JContent content) {
        if(content == null) throw new NullPointerException();
        if(content instanceof JTopic) System.out.println("The topic " + ((JTopic) content).getId() + " has been updated!");
    }

    public void subscribe(JTopic topic){
        if(topic == null) throw new NullPointerException();
        this.topicList.add(topic);
        topic.addObserver(this);

    }

    public void unsubscribe(JTopic topic){
        if(topic == null) throw new NullPointerException();
        this.topicList.remove(topic);
        topic.removeObserver(this);
    }

    public Set<JTopic> getSubscribedTopics(){
        return this.topicList;
    }
}
