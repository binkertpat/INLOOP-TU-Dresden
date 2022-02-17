import java.util.*;
public class PlainTextCollector implements KeywordCollector {

    @Override
    public Set<String> getKeywords(Resource res){
        Set<String> outputSet = new TreeSet<String>();
        if(res == null){
            throw new NullPointerException("Resource should not be null.");
        }
        TextFileIterator iter = new TextFileIterator(res);

        while(iter.hasNext()){
            outputSet.add(iter.next());
        }

        return outputSet;
    }
}