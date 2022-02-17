public class Purchasing implements StockObserver{
    private ReceivingStock receivingStock;

    public Purchasing(ReceivingStock receivingStock){
        if(receivingStock == null){
            throw new NullPointerException("Receiving Stock should not be null.");
        }
        this.receivingStock = receivingStock;
    }
    public void buy(Part part, int count){
        if(part == null){
            throw new NullPointerException("Part should not be null.");
        }
        if(count < 1){
            throw new IllegalArgumentException("You can't buy less then one part.");
        }
        receivingStock.insert(part, count);
    }

    public ReceivingStock getStock(){
        return this.receivingStock;
    }

    public void onPartCountChanged(Part part, int count){
        if(part == null){
            throw new NullPointerException("Part should not be null.");
        }
        if(count < 1){
            throw new IllegalArgumentException("You can't change less then one part.");
        }
        this.buy(part, this.receivingStock.getMaxStockItems() - count);
    }
}
