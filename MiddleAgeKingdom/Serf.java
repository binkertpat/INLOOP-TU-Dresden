public class Serf extends Peasant{
    @Override
    public int taxableIncome(){
        if (income > 12){
            return income - 12;
        } else {
            return income;
        }

    }
}