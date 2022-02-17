class BankAccount{
    private double balance = 0.0;
    private double lineOfCredit;
    private String accountNumber;
    private AccountState state;

    public BankAccount(String accountNumber, double lineOfCredit){
        if(accountNumber.isEmpty()) throw new IllegalArgumentException();
        if(lineOfCredit < 0) throw new IllegalArgumentException();
        this.accountNumber = accountNumber;
        this.lineOfCredit = lineOfCredit;
        this.state = new Positive();
    }

    public boolean payIn(double amount){
        if(amount <= 0) throw new IllegalArgumentException();
        return this.state.payIn(amount);
    }

    public boolean payOff(double amount){
        if(amount <= 0) throw new IllegalArgumentException();
        return this.state.payOff(amount);
    }

    public boolean close(){
        if(this.getBalance() == 0.0){
            this.state = new Closed();
            return true;
        }
        return false;
    }

    public double getBalance(){
        return this.balance;
    }

    public String getState(){
        return this.state.toString();
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void printBalance(){
        this.state.printBalance();
    }

    public void payInterest(){
        this.state.payInterest();
    }

    abstract class AccountState {
        public boolean payIn(double amount) {
            if(amount <= 0) throw new IllegalArgumentException();
            balance = balance + amount;
            return true;
        }

        public boolean payOff(double amount) {
            if(amount <= 0) throw new IllegalArgumentException();
            double tempbalance = balance - amount;
            double negativCredit = lineOfCredit * (-1);
            if(tempbalance < negativCredit) return false;
            else balance = tempbalance;
            return true;
        }

        @Override
        public String toString() {
            return "AccountState";
        }

        public void payInterest() {
            throw new IllegalStateException();
        }

        public abstract void printBalance();
    }

    class Positive extends AccountState{
        @Override
        public boolean payIn(double amount) {
            return super.payIn(amount);
        }

        @Override
        public boolean payOff(double amount) {
            if(!super.payOff(amount)) return false;
            double negativCredit = lineOfCredit * (-1);
            if(balance <= negativCredit){
                balance = negativCredit;
                state = new Frozen();
            } else if (balance < 0){
                state = new Negative();
            }
            return true;
        }

        @Override
        public void payInterest() {
            balance = getBalance() * 1.01;
        }

        @Override
        public void printBalance(){
            // Balance is POSITIVE: +0.0.
            System.out.println("Balance is POSITIVE: +" + getBalance() + ".");
        }

        @Override
        public String toString() {
            return "Positive";
        }
    }

    class Negative extends AccountState{
        @Override
        public boolean payIn(double amount) {
            super.payIn(amount);
            if(balance >= 0) state = new Positive();
            return true;
        }

        @Override
        public boolean payOff(double amount) {
            if(!super.payOff(amount)) return false;
            double negativCredit = lineOfCredit * (-1);
            if(balance <= negativCredit){
                balance = negativCredit;
                state = new Frozen();
            }
            return true;
        }

        @Override
        public void payInterest() {
            double negativCredit = lineOfCredit * (-1);
            balance = balance * 1.03;
            if(balance <= negativCredit){
                balance = negativCredit;
                state = new Frozen();
            }
        }

        @Override
        public void printBalance(){
            // Balance is NEGATIVE: -10.0.
            System.out.println("Balance is NEGATIVE: " + getBalance() + ".");
        }

        @Override
        public String toString() {
            return "Negative";
        }
    }

    class Frozen extends AccountState{
        @Override
        public boolean payIn(double amount) {
            double negativCredit = lineOfCredit * (-1);
            super.payIn(amount);
            if(balance > negativCredit) state = new Negative();
            if(balance >= 0) state = new Positive();
            return true;
        }

        @Override
        public void payInterest() {
            balance = balance * 1.05;
        }

        @Override
        public void printBalance(){
            // Balance is NEGATIVE: -20.0. You need to pay in money.
            System.out.println("Balance is NEGATIVE: " + getBalance() + ". You need to pay in money.");
        }

        @Override
        public String toString() {
            return "Frozen";
        }
    }

    class Closed extends AccountState{
        @Override
        public boolean payIn(double amount) {
            return false;
        }

        @Override
        public boolean payOff(double amount) {
            return false;
        }

        @Override
        public void payInterest() {
            throw new IllegalStateException();
        }

        @Override
        public void printBalance(){
            System.out.println("This account is CLOSED. The balance is 0.");
        }

        @Override
        public String toString() {
            return "Closed";
        }
    }
}