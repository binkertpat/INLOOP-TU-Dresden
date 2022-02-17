public abstract class ProjectItem {
    private String name;
    private String details;
    private double rate;

    public ProjectItem(String name, String details, double rate){
        if(name.isEmpty()){
            throw new IllegalArgumentException("Name should not be empty.");
        }
        this.name = name;
        if(details.isEmpty()){
            throw new IllegalArgumentException("Description should not be empty.");
        }
        this.details = details;
        if(rate < 0){
            throw new IllegalArgumentException("Rate should be greater than 0.");
        }
        this.rate = rate;
    }

    public void setDetails(String newDetails){
        if(newDetails.isEmpty()){
            throw new IllegalArgumentException("New Details should not be empty.");
        }
        this.details = newDetails;
    }

    // The estimate costs are calculated by multiplying the required time with the rate
    // and adding that value (rounded to a long) to the material costs.
    public long getCostEstimate(){
        return Math.round((this.rate * this.getTimeRequired()) + this.getMaterialCost());
    }

    public abstract double getTimeRequired();

    public abstract long getMaterialCost();
}

