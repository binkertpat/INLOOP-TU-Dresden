import java.util.List;

public class Adapter extends Project implements IProject{
    private Task task;

    public Adapter(String name, String description, double rate) {
        super(name, description, rate);
    }

    @Override
    public List<Deliverable> getDeliverables() {
        return this.task.allDeliverables();
    }

    @Override
    public void setTask(Task newTask){
        if(newTask == null){
            throw new NullPointerException("NewTask should not be null.");
        }
        this.task = newTask;
    }

    @Override
    public double getDuration(){
        return this.task.getTimeRequired();
    }

    @Override
    public long getTotalCost(){
        return this.task.getCostEstimate();
    }
}
