public class Sale {
    private long preDiscountTotal;
    private ISalePricing pricing;

    public Sale(long preDiscountTotal, ISalePricing pricing){
        if(preDiscountTotal < 0){
            throw new IllegalArgumentException("preDiscountTotal should be greater or equal 0.");
        }
        if(pricing == null){
            throw new NullPointerException("pricing should not be null.");
        }
        this.preDiscountTotal = preDiscountTotal;
        this.pricing = pricing;

    }
    public long getPreDiscountTotal(){
        return preDiscountTotal;
    }

    public void setPricing(ISalePricing pricing){
        if(pricing == null){
            throw new NullPointerException("pricing should not be null.");
        }
        this.pricing = pricing;

    }

    public long getTotal(){
        return pricing.getTotal(this);
    }

    public static ISalePricing createPricing(DiscountType discountType, double percentage, long discount, long threshold){
        switch(discountType){
            case ABSOLUTEDISCOUNT: return new AbsoluteDiscountPricing(discount, threshold);
            case PERCENTAGEDISCOUNT: return new PercentageDiscountPricing(percentage);
            default: return null;
        }
    }
}
