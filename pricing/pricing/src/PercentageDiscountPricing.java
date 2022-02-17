public class PercentageDiscountPricing implements ISalePricing{
    double percentage;

    PercentageDiscountPricing(double percentage){
        if(percentage < 0 || percentage > 100){
            throw new IllegalArgumentException("Percentage should be between 0 and 100");
        }
        this.percentage = percentage;
    }
    public long getTotal(Sale sale){
        return sale.getPreDiscountTotal() - (long)(sale.getPreDiscountTotal() * (this.percentage / 100.0));
    }
}
