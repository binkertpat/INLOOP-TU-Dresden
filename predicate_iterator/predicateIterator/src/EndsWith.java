public class EndsWith implements Predicate<String>{
    private String suffix;

    public EndsWith(String suffix){
        if(suffix == null){
            throw new IllegalArgumentException("Value should not be empty.");
        }
        this.suffix = suffix;
    }

    @Override
    public boolean test(String value) {
        if(value == null){
            return false;
        }
        if(suffix.length() > value.length()){
            return false;
        }

        int suffixPositionCounter = suffix.length() - 1;
        int valuePositionCounter = value.length() - 1;

        while(suffixPositionCounter >= 0){
            if(suffix.charAt(suffixPositionCounter) != value.charAt(valuePositionCounter)){
                return false;
            }
            suffixPositionCounter--;
            valuePositionCounter--;
        }
        return true;
    }
}