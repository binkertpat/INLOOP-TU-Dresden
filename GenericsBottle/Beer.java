public class Beer extends Drink {
    private String brewery;
    public Beer(String brew) {
        this.brewery = brew;
    }
    public String getBrewery() {
        return brewery;
    }
    public String toString() {
        return brewery;
    }
}