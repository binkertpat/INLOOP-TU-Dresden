public class StartsWith implements Predicate<String>{
    private String prefix;

    public StartsWith(String prefix){
        if(prefix == null){
            throw new IllegalArgumentException("Value should not be empty.");
        }
        this.prefix = prefix;
    }

    @Override
    public boolean test(String value) {
        if(value == null){
            return false;
        }
        if(prefix.length() > value.length()){
            return false;
        }
        for(int i = 0; i < prefix.length(); i++){
            if(value.charAt(i) != prefix.charAt(i)){
                return false;
            }
        }
        return true;
    }
}