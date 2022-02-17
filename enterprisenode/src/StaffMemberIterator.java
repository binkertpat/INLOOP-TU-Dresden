import java.util.*;

public class StaffMemberIterator implements EnterpriseNodeIterator<StaffMember> {
    private Set<StaffMember> membersList;
    private Iterator<StaffMember> StaffMemberIterator;

    public StaffMemberIterator(Set<StaffMember> subordinates){
        if(subordinates == null) throw new NullPointerException();
        for(StaffMember memb : subordinates){
            if(memb == null) throw new NullPointerException();
        }
        membersList = new TreeSet<>();
        for(StaffMember memb : subordinates){
            findSubordinatesRecursively(memb);
        }
        this.StaffMemberIterator = membersList.iterator();
    }

    private void findSubordinatesRecursively(StaffMember memb){
        if(memb == null) throw new NullPointerException();
        membersList.add(memb);
        if(memb.getDirectSubordinates().size() != 0) {
            Set<StaffMember> subMembers = memb.getDirectSubordinates();
            for(StaffMember submemb : subMembers){
                findSubordinatesRecursively(submemb);
            }
        }
    }

    @Override
    public boolean hasNext() {
        return StaffMemberIterator.hasNext();
    }

    @Override
    public StaffMember next() {
        return StaffMemberIterator.next();
    }
}
