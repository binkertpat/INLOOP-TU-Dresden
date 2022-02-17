public class Division extends AbstractUnit{
    public Division(String name) {
        super(name);
    }

    public boolean add(AbstractEnterpriseUnit childNode) {
        if(childNode == null) throw new NullPointerException();
        if(childNode instanceof Division) throw new IllegalArgumentException();
        if(childNode instanceof Company) throw new IllegalArgumentException();
        if(childNode instanceof Holding) throw new IllegalArgumentException();

        if(super.getChildNodes().contains(childNode)) return false;
        return super.getChildNodes().add(childNode);
    }
}
