public class BestForStorePricing extends ComplexPricing{
    public BestForStorePricing(ISalePricing pricing){
        super(pricing);
    }

    public long getTotal(Sale sale){
        long compareNumber = 0;
        for(ISalePricing price : this.getPricings()){
            if(price.getTotal(sale) > compareNumber){
                compareNumber = price.getTotal(sale);
            }
        }
        return compareNumber;
    }
}
