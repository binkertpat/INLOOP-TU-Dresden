public class Volunteer extends Employee{
    // he basic difference is that the Volunteer does not receive any payment which is why he does not have a
    // payday or any deductions. Hence, calling calculatePay() on a Volunteer causes an UnpayableEmployeeException to be thrown.
    public Volunteer(String id){
        super(id);
    }

    @Override
    public boolean isPayday(int dayOfMonth) {
        if(dayOfMonth < 1 || dayOfMonth > 30){
            throw new IllegalArgumentException("Day of month should be greater than 0.");
        }
        return false;
    }

    @Override
    public double calculatePay() throws UnpayableEmployeeException {
        throw new UnpayableEmployeeException("Volunteer does not receive any payment.");
    }

    @Override
    public double calculateDeductions() {
        return 0;
    }
}
