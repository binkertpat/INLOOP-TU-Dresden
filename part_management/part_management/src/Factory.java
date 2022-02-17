public class Factory {
    Purchasing purchasing;
    ReceivingStock reiceivingstock;

    public Factory(Purchasing purchasing, ReceivingStock reiceivingstock){
        if(purchasing == null){
            throw new NullPointerException("Purchasing shopuld not be null.");
        }
        if(reiceivingstock == null){
            throw new NullPointerException("reiceivingstock shopuld not be null.");
        }
        this.purchasing = purchasing;
        this.reiceivingstock = reiceivingstock;
    }

    public Purchasing getPurchasing() {
        return purchasing;
    }

    public ReceivingStock getReceivingStock() {
        return reiceivingstock;
    }

    public static Part createPart(PartType partType, String id, String name){
        if(id.isEmpty()){
            throw new IllegalArgumentException("ID should not be empty.");
        }
        if(name.isEmpty()){
            throw new IllegalArgumentException("Name should not be empty.");
        }
        return switch (partType) {
            case COMPONENTS -> new Components(id, name);
            case SINGLE_COMPONENT -> new SingleComponent(id, name);
            case RESOURCE -> new Resource(id, name);
        };
    }
}