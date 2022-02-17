import java.util.*;

public class Item{
    private String name;
    private String description;
    private long minPrice;
    private Bid maxBid;
    private List<Bid> bidlist;

    public Item(String name, String description, long minPrice){
        if(name.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.name = name;
        if(description.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.description = description;
        if(minPrice <= 0){
            throw new IllegalArgumentException();
        }
        this.minPrice = minPrice;

        bidlist = new ArrayList<>();
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setDescription(String description){
        if(description.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }

    public void setMinPrice(long minPrice){
        if(minPrice < 0){
            throw new IllegalArgumentException();
        }
        this.minPrice = minPrice;
    }

    public long getMinPrice(){
        return this.minPrice;
    }

    public void setMaxBid(Bid bid){
        this.maxBid = bid;
    }

    public void addBid(Person bidder, long price){
        if(price <= 0){
            throw new IllegalArgumentException();
        }
        if(bidder == null){
            throw new NullPointerException();
        }
        if(price < getMinPrice()){return;}
        if(getHighestBid() != null && price <= getHighestBid().getPrice()){return;}

        Bid bid = new Bid(bidder, price);
        if(getHighestBid() == null || price > getHighestBid().getPrice()){
            setMaxBid(bid);
        }

        bidlist.add(bid);
    }

    public List<Bid> getAllBids(){
        return this.bidlist;
    }

    public Bid getHighestBid(){
        return this.maxBid;
    }

    @Override
    public String toString(){
        return this.getName()+": "+ this.getDescription()+" (minimum bidding price: "+this.getMinPrice()+" EUR)";
    }


}