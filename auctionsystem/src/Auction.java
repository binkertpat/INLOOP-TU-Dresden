import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class Auction {
    private boolean closed;
    private List<Item> allItems;
    private List<Person> allBidders;

    public Auction(){
        allBidders = new ArrayList<>();
        allItems = new ArrayList<>();
        this.closed = false;
    }

    public void addBid(Item bidItem, String nameOfBidder, long price){
        if(this.closed) throw new IllegalStateException();
        if(bidItem == null) throw new NullPointerException();
        if(nameOfBidder.isEmpty()) throw new IllegalArgumentException();
        if(price <= 0) throw new IllegalArgumentException();

        Person bidder = null;
        boolean FoundPerson = false;
        for(Person person : allBidders){
            if(person.getName().equals(nameOfBidder)){
                bidder = person;
                FoundPerson = true;
            }
        }
        if(!FoundPerson){
            bidder = new Person(nameOfBidder);
        }

        if(allBidders.contains(bidder)){
            allBidders.add(bidder);
        }
        Item FoundItem = null;
        for(Item item : allItems){
            if(item.getName().equals(bidItem.getName())){
                FoundItem = item;
            }
        }
        if(FoundItem == null){
            throw new NoSuchElementException();
        }
        FoundItem.addBid(bidder, price);

    }

    public String closeAuction(){
        if(this.closed) {
            throw new IllegalStateException();
        }
        this.closed = true;
        return this.generateItemListString();
    }

    public String generateAllBidsString(Item item){
        String output = "All bids:";
        for(Bid bid : item.getAllBids()){
            output = output + "\n" + bid.getPrice() + " EUR by " + bid.getBidder();
        }
        return output;
    }

    public String generateItemListString(){
        String output = "";
        for(Item item : allItems){
            output = output + generateItemString(item) + "\n";
        }
        return output;
    }

    public void registerItem(Item item){
        if(this.closed){
            throw new IllegalStateException();
        }

        if(item == null){
            throw new NullPointerException();
        }

        for(Item itemForLoop : allItems){
            String name1 = itemForLoop.getName();
            String description1 = itemForLoop.getDescription();
            String name2 = item.getName();
            String description2 = item.getDescription();

            if(name1.equals(name2) || description1.equals(description2)){
                throw new IllegalArgumentException();
            }
        }
        allItems.add(item);


    }

    public abstract String generateItemString(Item item);

    public List<Item> getAllItems(){
        return allItems;
    }


}
