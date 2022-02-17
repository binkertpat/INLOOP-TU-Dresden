import java.util.ArrayList;
import java.util.List;

public class Task extends ProjectItem{
    private long sumMaterialCosts;
    private double sumRequiredTime;

    private List<ProjectItem> projectItems;

    public Task(String name, String details, double rate){
        super(name, details, rate);
        projectItems = new ArrayList<>();
    }

    @Override
    public double getTimeRequired() {
        sumRequiredTime = 0;
        for(ProjectItem pi : projectItems){
            sumRequiredTime = sumRequiredTime + pi.getTimeRequired();
        }
        return sumRequiredTime;
    }

    @Override
    public long getMaterialCost() {
        sumMaterialCosts = 0;
        for(ProjectItem pi : projectItems){
            sumMaterialCosts = sumMaterialCosts + pi.getMaterialCost();
        }
        return sumMaterialCosts;
    }

    public void addProjectItem(ProjectItem pi){
        if(pi == null){
            throw new NullPointerException("ProjectItem should not be null.");
        }
        projectItems.add(pi);
    }

    public void removeProjectItem(ProjectItem pi){
        if(pi == null){
            throw new NullPointerException("ProjectItem should not be null.");
        }
        projectItems.remove(pi);
    }

    public List<Deliverable> allDeliverables(){
        List<Deliverable> deliverableList = new ArrayList<>();
        for(ProjectItem pi : projectItems){
            if(pi instanceof Deliverable){
                deliverableList.add((Deliverable) pi);
            }
            if(pi instanceof Task){
                deliverableList.addAll(((Task) pi).allDeliverables());
            }

        }
        return deliverableList;
    }
}
