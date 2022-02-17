import java.util.*;

public class Payroll {
    private int payday;
    private PayrollDisposition disposition;

    public Payroll(PayrollDisposition disposition, int payday){
        if(disposition == null){
            throw new NullPointerException("Disposition should not be null.");
        }
        this.disposition = disposition;
        if(payday < 1 || payday > 30){
            throw new IllegalArgumentException("Payday should be between 1 and 30.");
        }
        this.payday = payday;
    }

    public void doPayroll(PayrollDB db){
        if(db == null){
            throw new NullPointerException("Disposition should not be null.");
        }
        // The method doPayroll() retrieves the list of employees from a PayrollDB and calls sendPayment()
        // for each Employee to submit the respective salary.
        List<Employee> employeeList = db.getEmployeeList();
        for(Employee empl : employeeList){
            if(empl instanceof Appointee && empl.isPayday(this.payday)){
                try {
                    disposition.sendPayment(empl, empl.calculatePay() - empl.calculateDeductions());
                } catch(UnpayableEmployeeException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
