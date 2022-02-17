import java.util.*;
public class Bid {

    private Person bidder;
    private long price;

    public Bid(Person bidder, long price){
        if(bidder == null){
            throw new NullPointerException();
        }
        this.bidder = bidder;
        if(price <= 0){
            throw new IllegalArgumentException();
        }
        this.price = price;
    }

    public Person getBidder() {
        return bidder;
    }

    public long getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return this.getPrice() + " EUR by " + this.getBidder();
    }
}