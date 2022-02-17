import java.util.*;

public class JIdeaPool {
    private Map<JTopic, Set<JIdea>> pool;

    public JIdeaPool(){
        pool = new HashMap<>();
    }

    public void add(JTopic topic){
        if(topic == null) throw new NullPointerException();
        Set<JIdea> emptySet = new LinkedHashSet<>();
        if(!pool.containsKey(topic)) pool.put(topic, emptySet);
    }

    public void add(JIdea idea, JTopic topic){
        if(topic == null || idea == null) throw new NullPointerException();
        boolean containsKey = this.pool.containsKey(topic);
        Set<JIdea> emptyIdeasSet = new HashSet<>();
        boolean isIdeaAlreadyFound = false;

        if(containsKey) {
            for (JIdea jideas : this.pool.get(topic)) {
                if (jideas.getTitle().equals(idea.getTitle())){isIdeaAlreadyFound = true; break;}
            }
            if (!isIdeaAlreadyFound) this.pool.get(topic).add(idea);
        }

        if(!containsKey){
            for (Set<JIdea> setOfIdeas : pool.values()){
                for (JIdea jidea : setOfIdeas){
                    if(idea.getTitle().equals(jidea.getTitle()) && idea != jidea){isIdeaAlreadyFound = true; break;}
                }
            }

            if (!isIdeaAlreadyFound) {
                emptyIdeasSet.add(idea);
                this.pool.put(topic, emptyIdeasSet);
            }
        }

    }

    public boolean remove(JTopic topic){
        if(topic == null) throw new NullPointerException();
        if(pool.containsKey(topic)){
            pool.remove(topic);
            return true;
        }
        return false;
    }

    public boolean remove(JIdea idea){
        boolean isSomeThingRemoved = false;
        if(idea == null) throw new NullPointerException();
        for (Map.Entry<JTopic, Set<JIdea>> entry : pool.entrySet()) {
            if(entry.getValue().contains(idea)) {
                Set<JIdea> savedSet = entry.getValue();
                savedSet.remove(idea);
                pool.put(entry.getKey(), savedSet);
                isSomeThingRemoved = true;
            }
        }
        return isSomeThingRemoved;
    }

    public JIdea getIdea(String title){
        if(title.isEmpty()) throw new IllegalArgumentException();
        if(title == null) throw new NullPointerException();
        for (Map.Entry<JTopic, Set<JIdea>> entry : pool.entrySet()) {
            Set<JIdea> savedSet = entry.getValue();
            for (JIdea idea : savedSet) {
                if(idea.getTitle().equals(title)){
                    return idea;
                }
            }
        }
        return null;
    }

    public int numberOfTopics(){
        return pool.size();
    }

    public int numberOfIdeas(){
        List<String> savedUniqueIdeas = new ArrayList<>();
        for (Map.Entry<JTopic, Set<JIdea>> entry : pool.entrySet()) {
            for(JIdea idea : entry.getValue()){
                if(!savedUniqueIdeas.contains(idea.getTitle())) savedUniqueIdeas.add(idea.getTitle());
            }
        }
        return savedUniqueIdeas.size();
    }

    public void removeDeclined(){
        for (Map.Entry<JTopic, Set<JIdea>> entry : pool.entrySet()) {
            Set<JIdea> savedSet = entry.getValue();
            savedSet.removeIf(JIdea::isDeclined);
            pool.put(entry.getKey(), savedSet);
        }
    }

    public void removeReleased(){
        for (Map.Entry<JTopic, Set<JIdea>> entry : pool.entrySet()) {
            Set<JIdea> savedSet = entry.getValue();
            savedSet.removeIf(JIdea::isReleased);
            pool.put(entry.getKey(), savedSet);
        }
    }
}
