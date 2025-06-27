public class CurrentAccount extends Account {
    public CurrentAccount(int id, String name, double balance) {
        super(id, name, balance);
    }

    public boolean withdraw(double amount) {
        if (amount <= getBalance()) {
            setBalance(getBalance() - amount);
            return true;
        }
        return false;
    }

    public void addInterest() {

    }
}
