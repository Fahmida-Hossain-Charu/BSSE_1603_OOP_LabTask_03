public class SavingsAccount extends Account {
    public SavingsAccount(int id, String name, double balance) {
        super(id, name, balance);
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && getBalance() - amount >= 1000) {
            setBalance(getBalance() - amount);
            return true;
        }
        return false;
    }

    public void addInterest() {
        double interest = getBalance() * 0.025;
        setBalance(getBalance() + interest);
    }
}


