import java.util.*;

public class Index {
    private Map<String, List<Resource>> index;

    public Index(){
        index = new HashMap<>();
    }

    public void add(Resource res){
        if(res == null){
            throw new NullPointerException("Resource should not be null.");
        }
        //  represents a mapping of keywords to files (for each keyword a list of files)
        Set<String> toInsertKeyWords = res.getType().getCollector().getKeywords(res);

        for(String toInsert : toInsertKeyWords){
            // key not included
            if (!index.containsKey(toInsert)) {
                index.put(toInsert, new ArrayList<>());
            }
            // element not included
            if (!index.get(toInsert).contains(res)) {
                index.get(toInsert).add(res);
            }
        }
    }

    public List<Resource> getResources(String keyword){
        if(keyword.isEmpty()){
            throw new IllegalArgumentException("Request should not be null.");
        }
        return index.getOrDefault(keyword, new ArrayList<>());
    }
}