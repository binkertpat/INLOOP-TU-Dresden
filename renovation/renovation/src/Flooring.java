public class Flooring extends Material{

    private double limit = 0.02;
    private double widthOfFlooring;

    public Flooring(String name, double price, double width) {
        super(name, price);
        if(width <= 0){
            throw new IllegalArgumentException("Width should greater than 0.");
        }
        this.widthOfFlooring = width;
    }

    public double getLimit() {
        return this.limit;
    }

    public double getWidthOfFlooring(){
        return this.widthOfFlooring;
    }

    public double getWidth(){
        return widthOfFlooring;
    }
    @Override
    int getMaterialRequirements(Surface surface) {
        if(surface == null){
            throw new NullPointerException("Surface should not be null.");
        }
        if(surface.getArea() % this.getWidthOfFlooring() <= this.getLimit()){
            return (int) Math.round(surface.getArea() / this.getWidthOfFlooring());
        } else {
            return (int) Math.round(surface.getArea() / this.getWidthOfFlooring()) + 1;
        }
    }
}
