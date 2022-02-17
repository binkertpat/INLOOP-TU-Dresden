import java.util.*;

abstract class ComplexPricing implements ISalePricing{
    private List<ISalePricing> pricingList;
    public ComplexPricing(ISalePricing pricing){
        if(pricing == null){
            throw new NullPointerException("Pricing should not be null.");
        }
        pricingList = new ArrayList<>();
        pricingList.add(pricing);

    }
    public void add(ISalePricing pricing){
        if(pricing == null){
            throw new NullPointerException("Pricing should not be null.");
        }
        pricingList.add(pricing);
    }
    public List<ISalePricing> getPricings(){
        return pricingList;
    }

    @Override
    public long getTotal(Sale sale) {
        return 0;
    }
}
