import java.util.*;

public class Team extends AbstractEnterpriseUnit{
    private final StaffMember teamLeader;

    public Team(String name, StaffMember teamLeader){
        super(name);
        if(teamLeader == null) throw new NullPointerException();
        this.teamLeader = teamLeader;
    }

    public StaffMember getTeamLeader(){
        return this.teamLeader;
    }

    public SortedSet<StaffMember> getTeamMembers(){
        SortedSet<StaffMember> memb = new TreeSet<>();
        memb.add(this.teamLeader);
        StaffMemberIterator membIt = new StaffMemberIterator(this.teamLeader.getDirectSubordinates());
        while(membIt.hasNext()){
            memb.add(membIt.next());
        }
        return memb;
    }
}
