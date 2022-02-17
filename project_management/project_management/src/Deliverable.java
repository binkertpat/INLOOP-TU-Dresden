import java.time.LocalDate;

public class Deliverable extends ProjectItem{
    private long materialCost;
    private double productionTime;
    private LocalDate date;

    public Deliverable(String name, String details, double rate, long materialCost, double productionTime, LocalDate date){
        super(name, details, rate);
        if(productionTime <= 0){
            throw new IllegalArgumentException("productionTime should be greater than 0.");
        }
        this.productionTime = productionTime;
        if(materialCost < 0){
            throw new IllegalArgumentException("MaterialCost should be greater than 0.");
        }
        this.materialCost = materialCost;
        if(date == null){
            throw new NullPointerException("date should not be null.");
        }
        this.date = date;
    }

    public LocalDate getDate(){
        return this.date;
    }

    @Override
    public double getTimeRequired() {
        return this.productionTime;
    }

    @Override
    public long getMaterialCost() {
        return this.materialCost;
    }
}
