import java.util.Set;
import java.util.TreeSet;

public class StaffMember implements EnterpriseNode, Comparable<StaffMember>{
    private final String name;
    private final String job;
    private final Set<StaffMember> subordinatesList;

    public StaffMember(String name, String job){
        if(name.isEmpty() || job.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.job = job;
        subordinatesList = new TreeSet<>();
    }

    public String getJob(){
        return this.job;
    }

    public boolean addDirectSubordinate(StaffMember subordinate){
        if(subordinate == null) throw new NullPointerException();
        if(subordinatesList.contains(subordinate)){
            return false;
        } else {
            return this.subordinatesList.add(subordinate);
        }
    }

    public boolean removeDirectSubordinate(StaffMember member) {
        if(member == null) throw new NullPointerException();
        return this.subordinatesList.remove(member);
    }

    public Set<StaffMember> getDirectSubordinates() {
        return this.subordinatesList;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(StaffMember o) {
        if(o == null) throw new NullPointerException();
        return this.name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return this.name;
    }
}
