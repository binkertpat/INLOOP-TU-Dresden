import java.util.HashMap;
import java.util.Map;

public class PayrollDispositionImpl implements PayrollDisposition{
    private Map<Employee, Double> payments;
    double sum;

    public PayrollDispositionImpl(){
        payments = new HashMap<Employee, Double>();
    }

    public double getTotal(){
        sum = 0;
        payments.forEach((k,v) -> {
            sum = sum + v;
        });
        return sum;
    }

    public double getAverage(){
        // PayrollDispositionImpl.getAverage() should return the correct value
        if(payments.isEmpty()){
            return 0;
        }
        return this.getTotal() / this.payments.size();
    }
    public Map<Employee, Double> getPayments(){
        return this.payments;
    }

    @Override
    public void sendPayment(Employee empl, double payment) {
        if(empl == null){
            throw new NullPointerException("Employee should not be null.");
        }
        if(payment <= 0){
            throw new IllegalArgumentException("Payment should not be null.");
        }
        this.payments.put(empl, payment);
    }
}
