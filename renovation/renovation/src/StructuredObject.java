import java.util.*;

public class StructuredObject extends RenovationObject{
    //private Set<RenovationObject> setOfRenovationObjects;
    private Set<RenovationObject> parts; //jUnit-Test are require the naming parts
    public StructuredObject(){
        parts = new HashSet<RenovationObject>();
    }

    public void add(RenovationObject renovationObject){
        if(renovationObject == null){
            throw new NullPointerException("RenovationObject should not be null.");
        }
        this.parts.add(renovationObject);
    }

    public double getPrice(){
        double output = 0.00;

        for(RenovationObject ro : parts){
            output = output + ro.getPrice();
        }
        return output;
    }

    @Override
    public Map<String,Integer> addMaterialRequirements(Map<String,Integer> materials){
        if(materials == null){
            throw new NullPointerException("Materials Map should not be null.");
        }

        materials.forEach((k,v) -> {
            if(k == null){
                throw new NullPointerException("Key should not be null.");
            }
            if(v == null){
                throw new NullPointerException("Value should not be null.");
            }
        });

        for(RenovationObject ro : parts){
            materials = ro.addMaterialRequirements(materials);
        }

        return materials;
    }
}
