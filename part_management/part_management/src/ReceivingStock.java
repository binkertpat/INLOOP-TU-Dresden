public class ReceivingStock extends Stock{
    private int minStockItems;
    private int maxStockItems;

    public ReceivingStock(int minStockItems, int maxStockItems){
        if(minStockItems < 0){
            throw new IllegalArgumentException("You can't create Stock with minStockItems less then 0.");
        }
        if(maxStockItems < 0){
            throw new IllegalArgumentException("You can't create Stock with maxStockItems less then 0.");
        }
        if(maxStockItems <= minStockItems){
            throw new IllegalArgumentException("Minimum can't be greater or equal than Maximum.");
        }

        this.maxStockItems = maxStockItems;
        this.minStockItems = minStockItems;
    }

    public int getMinStockItems(){
        return this.minStockItems;
    }

    public int getMaxStockItems(){
        return this.maxStockItems;
    }

    public boolean insert(Part part, int amount){
        if(part == null){
            throw new NullPointerException("Part should not be null.");
        }
        if(amount < 1){
            throw new IllegalArgumentException("You can't insert less then one part.");
        }
        if(amount > this.maxStockItems){
            return false;
        }
        return super.insert(part, amount);
    }

    public boolean remove(Part part, int amount){
        if(part == null){
            throw new NullPointerException("Part should not be null.");
        }
        if(amount < 1){
            throw new IllegalArgumentException("You can't remove less then one part.");
        }
        return super.remove(part, amount);
    }
}
