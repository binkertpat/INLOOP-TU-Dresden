import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Surface extends RenovationObject{
    private double length;
    private double width;
    private Material material;

    public Surface(double length, double width){
        if(length <= 0){
            throw new IllegalArgumentException("Length should greater than 0.");
        }
        if(width <= 0){
            throw new IllegalArgumentException("Width should greater than 0.");
        }
        this.length = length;
        this.width = width;
    }

    public void setMaterial(Material material){
        if(material == null){
            throw new NullPointerException("Material should not be null.");
        }
        this.material = material;
    }

    public double getArea(){
        return this.getLength() * this.getWidth();
    }

    public double getLength(){
        return this.length;
    }

    public double getWidth(){
        return this.width;
    }

    public double getPrice(){
        return this.material.getPriceOfASurface(this);
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

        Map<String,Integer> copyOfMaterialMap = new TreeMap<>(materials);

        int materialRequirements = this.material.getMaterialRequirements(this);

        String materialName = this.material.getName();

        if(copyOfMaterialMap.containsKey(materialName)){
            copyOfMaterialMap.replace(materialName, materialRequirements + materials.get(materialName));
        } else {
            copyOfMaterialMap.put(materialName, materialRequirements);
        }


        return copyOfMaterialMap;
    }
}
