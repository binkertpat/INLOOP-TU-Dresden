public class AbsoluteDiscountPricing implements ISalePricing{
    private final long discount;
    private final long threshold;

    public AbsoluteDiscountPricing(long discount, long threshold){
        if(threshold < 0){
            throw new IllegalArgumentException("Threshold should be greater than 0.");
        }
        if(discount < 0){
            throw new IllegalArgumentException("Discount should be greater than 0.");
        }
        this.discount = discount;
        this. threshold = threshold;
    }
    public long getTotal(Sale sale){
        if(sale.getPreDiscountTotal() - this.discount > this.threshold){
            return sale.getPreDiscountTotal() - this.discount;
        }

        return Math.min(sale.getPreDiscountTotal(), this.threshold);

    }
}
