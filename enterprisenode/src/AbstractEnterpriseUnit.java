public abstract class AbstractEnterpriseUnit implements EnterpriseNode{
    private final String name;

    public AbstractEnterpriseUnit(String name) {
        if(name.isEmpty()) throw new IllegalArgumentException();
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
