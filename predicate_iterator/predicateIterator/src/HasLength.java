public class HasLength implements Predicate<String>{
    private int length;

    public HasLength(int length){
        if(length < 0){
            throw new IllegalArgumentException("Value should not be empty.");
        }
        this.length = length;
    }

    @Override
    public boolean test(String value) {
        if(value == null){
            return false;
        }

        if(value.isEmpty()){
            return true;
        }

        return value.length() == length;
    }
}