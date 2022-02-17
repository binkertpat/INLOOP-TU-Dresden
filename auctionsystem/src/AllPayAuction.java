public class AllPayAuction extends Auction{
    @Override
    public String generateItemString(Item item) {
        String output = item.toString() + "\n";
        if(!item.getAllBids().isEmpty()){
            output = output + "Highest bid: " + item.getHighestBid().toString() + "\n" + generateAllBidsString(item);
        } else {
            output = output + "No bids placed";
        }
        return output;
    }
}
