import java.util.*;

public abstract class AbstractUnit extends AbstractEnterpriseUnit{
    private final Set<AbstractEnterpriseUnit> childNodeList;
    public AbstractUnit(String name) {
        super(name);
        childNodeList = new LinkedHashSet<>();
    }

    public boolean add(AbstractEnterpriseUnit childNode){

        if(childNode == null) throw new NullPointerException();
        if(this.childNodeList.contains(childNode)) return false;
        return this.childNodeList.add(childNode);
    }

    public boolean remove(AbstractEnterpriseUnit childNode){
        if(childNode == null) throw new NullPointerException();
        for(AbstractEnterpriseUnit node : childNodeList){
            if(node.getName().equals(childNode.getName())){
                return childNodeList.remove(childNode);
            }
        }
        return false;
    }

    public Set<AbstractEnterpriseUnit> getChildNodes(){
        return this.childNodeList;
    }
}
