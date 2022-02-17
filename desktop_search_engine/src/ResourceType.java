public class ResourceType{
    private String description;
    private KeywordCollector collector;

    public ResourceType(String desc, KeywordCollector collector){
        if(desc.isEmpty()){
            throw new IllegalArgumentException("Description should not be empty or null.");
        }
        if(collector == null){
            throw new NullPointerException("Collector should not be null.");
        }
        this.description = desc;
        this.collector = collector;
    }
    public String getDescription(){
        return this.description;
    }

    public KeywordCollector getCollector() {
        return this.collector;
    }
}