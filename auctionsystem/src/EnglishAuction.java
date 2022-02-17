public class EnglishAuction extends Auction{

    @Override
    public String generateItemString(Item item) {
        if(item == null){
            throw new NullPointerException();
        }
        String output = output = item.toString();
        if(item.getAllBids().isEmpty()){
            output = output  + "\nNo bids placed";
        } else {
            output = output + "\nHighest bid: " + item.getHighestBid().toString();
        }
        return output;
    }
}
