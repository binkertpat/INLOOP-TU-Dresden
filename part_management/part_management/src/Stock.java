import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public abstract class Stock {
    private Map<Part, Integer> parts;
    private List<StockObserver> savedStockObserver;

    public Stock(){
        parts = new HashMap<Part, Integer>();
        savedStockObserver = new ArrayList<StockObserver>();
    }
    public int getCount(Part part){
        if(part == null){
            throw new NullPointerException("Part should not be null.");
        }
        // java.lang.NullPointerException: Cannot invoke "java.lang.Integer.intValue()" because the return value of "java.util.Map.get(Object)" is null
        // using getOrDefault(part, -1) instead of get(part)
        return parts.getOrDefault(part, -1);
    }

    public boolean insert(Part part, int amount){
        if(part == null){
            throw new NullPointerException("Part should not be null.");
        }
        if(amount < 1){
            throw new IllegalArgumentException("You can't insert less then one part.");
        }
        if(parts.containsKey(part)){
            parts.replace(part, parts.get(part), parts.get(part) + amount);
        } else {
            parts.put(part, amount);
        }
        return true;
    }

    public boolean remove(Part part, int count){
        if(part == null){
            throw new NullPointerException("Part should not be null.");
        }
        if(count < 1){
            throw new IllegalArgumentException("You can't remove less then one part.");
        }
        boolean checkIfPartsIncludedPart = parts.containsKey(part);
        // java.lang.NullPointerException: Cannot invoke "java.lang.Integer.intValue()" because the return value of "java.util.Map.get(Object)" is null
        // using getOrDefault(part, -1) instead of get(part)
        boolean checkIfAmountGreaterCount = (parts.getOrDefault(part, -1) > count);

        if(checkIfAmountGreaterCount && checkIfPartsIncludedPart){
            parts.replace(part, parts.get(part), parts.get(part) - count);
            this.notifyPartCountChanged(part);
            return true;
        } else {
            return false;
        }
    }

    public void addObserver(StockObserver observer){
        if(observer == null){
            throw new NullPointerException("Observer should not be null.");
        }
        savedStockObserver.add(observer);
    }

    public void notifyPartCountChanged(Part part){
        if(part == null){
            throw new NullPointerException("Part should not be null.");
        }
        for(StockObserver so : savedStockObserver){
            so.onPartCountChanged(part, parts.get(part));
        }
    }
}
