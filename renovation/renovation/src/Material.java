public abstract class Material {
    private String name;
    private double price;

    public Material(String name, double price){
        if(price < 0){
            throw new IllegalArgumentException("Price should greater than 0.");
        }
        if(name.isEmpty()){
            throw new IllegalArgumentException("Name should not be empty.");
        }
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return this.name;
    }

    public double getPricePerUnit(){
        return this.price;
    }

    abstract int getMaterialRequirements(Surface surface);

    public double getPriceOfASurface(Surface surface){
        if(surface == null){
            throw new NullPointerException("Surface should not be null.");
        }
        return this.price * this.getMaterialRequirements(surface);
    }
}
