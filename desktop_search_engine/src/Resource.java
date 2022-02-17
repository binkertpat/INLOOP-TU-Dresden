public class Resource{
    private String name;
    private String path;
    private ResourceType rt;

    public Resource(String name, String path, ResourceType rt){
        if(name.isEmpty()){
            throw new IllegalArgumentException("Name should not be empty or null.");
        }
        if(path.isEmpty()){
            throw new IllegalArgumentException("Path should not be empty or null.");
        }
        if(rt == null){
            throw new NullPointerException("Ressource Type should not be null.");
        }

        this.rt = rt;
        this.name = name;
        this.path = path;
    }

    public String getName(){
        return this.name;
    }

    public String getPath(){
        return this.path;
    }

    public ResourceType getType(){
        return this.rt;
    }


}