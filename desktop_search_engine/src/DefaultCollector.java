import java.util.*;

public class DefaultCollector implements KeywordCollector {
    @Override
    public Set<String> getKeywords(Resource res){
        Set<String> outputSet = new TreeSet<String>();
        if(res == null){
            throw new NullPointerException("Resource should not be null.");
        }
        outputSet.add(res.getName());
        return outputSet;

    }
}