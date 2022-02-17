public class BestForCustomerPricing extends ComplexPricing{
    public BestForCustomerPricing(ISalePricing pricing){
        super(pricing);
    }

    public long getTotal(Sale sale){
        long compareNumber = sale.getPreDiscountTotal();
        for(ISalePricing price : this.getPricings()){
            if(price.getTotal(sale) < compareNumber){
                compareNumber = price.getTotal(sale);
            }
        }
        return compareNumber;
    }
}
