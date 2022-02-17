public class Inhabitant {
    protected int income;
    int taxesInPercent = 10;
    int minTaxes = 1;

    public int taxableIncome(){
        return income;
    }

    public int tax(){
        double taxes = ((double)taxableIncome() / 100) * taxesInPercent;
        if (taxes < minTaxes){taxes = minTaxes;}
        return (int)Math.floor(taxes);
    }

    public void setIncome(int in){
        if(in <0){
            throw new IllegalArgumentException();
        } else{
            income = in;
        }
    }
}





