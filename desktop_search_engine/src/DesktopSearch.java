import java.util.*;
public class DesktopSearch {
    private Map<String, ResourceType> types;
    private Index idx;

    public DesktopSearch(){
        types = new HashMap<>();
        idx = new Index();
    }

    public void registerType(String extension, ResourceType type){
        if(extension.isEmpty()){
            throw new IllegalArgumentException("Extension should not be null.");
        }
        if(type == null){
            throw new NullPointerException("ResourceType should not be null.");
        }
        types.put(extension, type);
    }

    public ResourceType getType(String extension){
        return types.get(extension);
    }

    public void unregisterType(String extension){
        if(extension.isEmpty()){
            throw new IllegalArgumentException("Extension should not be null.");
        }
        types.remove(extension);
    }

    public void registerResource(Resource res){
        if(res == null){
            throw new NullPointerException("Resource should not be null.");
        }
        idx.add(res);
    }

    public List<Resource> processRequest(String request){
        if(request.isEmpty()){
            throw new IllegalArgumentException("Request should not be null.");
        }
        return idx.getResources(request);
    }
}