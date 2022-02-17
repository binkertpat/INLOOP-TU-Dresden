public abstract class Part {
    private String id;
    private String name;

    public Part(String id, String name){
        if(id.isEmpty()){
            throw new IllegalArgumentException("Id should not be empty.");
        }
        if(name.isEmpty()){
            throw new IllegalArgumentException("Name should not be empty.");
        }
        this.id = id;
        this.name = name;
    }

    public String getId(){
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
