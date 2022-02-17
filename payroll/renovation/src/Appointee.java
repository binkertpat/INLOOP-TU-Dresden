public class Appointee extends Employee{
    private int payday;
    private int hoursperMonth;
    private double payPerHour;
    private double employeesSocialInsurance = 0.4;

    public Appointee(String id, int payday, int hoursPerMonth, double payPerHour){
        super(id);
        if(payday < 1 || payday > 30){throw new IllegalArgumentException("Payday should be greater than 0.");}
        if(hoursPerMonth <= 0){throw new IllegalArgumentException("Payday should be greater than 0.");}
        if(payPerHour <= 0){throw new IllegalArgumentException("Payday should be greater than 0.");}

        this.hoursperMonth = hoursPerMonth;
        this.payPerHour = payPerHour;
        this.payday = payday;
    }

    @Override
    public boolean isPayday(int dayOfMonth) {
        if(dayOfMonth < 1 || dayOfMonth > 30){
            throw new IllegalArgumentException("Day of month should be greater than 0.");
        }
        return this.payday == dayOfMonth;
    }

    @Override
    public double calculatePay(){
        return this.hoursperMonth * this.payPerHour;
    }

    // Finally, calculateDeductions() determines the employee’s deductions, i.e. the difference between gross and net salary
    // However, 40 percent of the money the Appointee would theoretically receive are used for things like the employee’s social insurance
    @Override
    public double calculateDeductions() {
        return this.calculatePay() * this.employeesSocialInsurance;
    }
}
