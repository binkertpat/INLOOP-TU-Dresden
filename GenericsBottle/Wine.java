public abstract class Wine extends Drink {
    private String region;
    
    public Wine(String reg) {
        this.region = reg;
    }
    public String getRegion() {
        return region;
    }
    public String toString() {
        return region;
    }
}