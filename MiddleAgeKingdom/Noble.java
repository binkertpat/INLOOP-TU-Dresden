public class Noble extends Inhabitant{
    @Override
    public int tax(){
        double taxes = ((double)taxableIncome() / 100) * taxesInPercent;
        if (taxes < 20){taxes = 20;}
        return (int)Math.floor(taxes);
    }
}