import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Project{
    private String name;
    private String description;
    private double rate;
    private Task task;

    public Project(String name, String description, double rate){
        if(name.isEmpty()){
            throw new IllegalArgumentException("Name should not be empty.");
        }
        this.name = name;
        if(description.isEmpty()){
            throw new IllegalArgumentException("Description should not be empty.");
        }
        this.description = description;
        if(rate < 0){
            throw new IllegalArgumentException("Rate should be greater than 0.");
        }
        this.rate = rate;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public void setTask(Task newTask){
        if(newTask == null){
            throw new NullPointerException("newTask should not be null.");
        }
        this.task = newTask;
    }

    public double getDuration(){
        return this.task.getTimeRequired();
    }

    public long getTotalCost(){
        return this.task.getCostEstimate();
    }

    public Map<LocalDate, List<Deliverable>> allDeliverables(){
        List<Deliverable> allDeliverablesList = this.task.allDeliverables();
        Map<LocalDate, List<Deliverable>> allDeliverablesMap = new HashMap<>();

        for(Deliverable deli : allDeliverablesList){
            LocalDate date = deli.getDate();
            List<Deliverable> DeliverablesList = new ArrayList<>();
            if(allDeliverablesMap.containsKey(deli.getDate())){
                DeliverablesList = allDeliverablesMap.get(deli.getDate());
                DeliverablesList.add(deli);
                allDeliverablesMap.replace(deli.getDate(), DeliverablesList);
            } else {
                DeliverablesList.add(deli);
                allDeliverablesMap.put(deli.getDate(), DeliverablesList);
            }

        }

        return allDeliverablesMap;
    }
}
