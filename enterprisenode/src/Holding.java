public class Holding extends AbstractUnit{
    public Holding(String name) {
        super(name);
    }

    public boolean add(AbstractEnterpriseUnit childNode) {
        if(childNode == null) throw new NullPointerException();
        if(childNode instanceof Holding) throw new IllegalArgumentException();
        if(childNode instanceof Division) throw new IllegalArgumentException();
        if(childNode instanceof Team) throw new IllegalArgumentException();

        if(super.getChildNodes().contains(childNode)) return false;
        return super.getChildNodes().add(childNode);
    }
}
