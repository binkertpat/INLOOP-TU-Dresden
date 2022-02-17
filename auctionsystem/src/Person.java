public class Person {
    private final String name;

    public Person(String name){
        if(name.isEmpty()){
            throw new IllegalArgumentException("Name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
