public class Paint extends Material{
    private double squareMetersPerLiter;
    private int numberOfCoats;
    private double bucketLiters = 0.5000000;
    private double limit = 0.02;

    public Paint(String name, double price, int numberOfCoats, double squareMetersPerLiter ) {
        super(name, price);
        if(numberOfCoats <= 0){
            throw new IllegalArgumentException("numberOfCoats should greater than 0.");
        }
        if(squareMetersPerLiter <= 0){
            throw new IllegalArgumentException("squareMetersPerLiter should greater than 0.");
        }
        this.numberOfCoats = numberOfCoats;
        this.squareMetersPerLiter = squareMetersPerLiter;
    }

    public int getNumberOfCoats() {
        return this.numberOfCoats;
    }

    public double getBucketLiters(){
        return this.bucketLiters;
    }

    public double getLimit(){
        return this.limit;
    }

    public double getSquareMetersPerLiter() {
        return this.squareMetersPerLiter;
    }

    @Override
    int getMaterialRequirements(Surface surface) {
        if(surface == null){
            throw new NullPointerException("Surface should not be null.");
        }
        double requiredVolumeOfPaint = (surface.getArea() * this.getNumberOfCoats()) / this.getSquareMetersPerLiter();

        if(requiredVolumeOfPaint % this.getBucketLiters() <= this.getLimit()){
            return (int) Math.floor(requiredVolumeOfPaint / this.getBucketLiters());
        } else {
            return (int) Math.floor(requiredVolumeOfPaint / this.getBucketLiters()) + 1;
        }
    }
}
