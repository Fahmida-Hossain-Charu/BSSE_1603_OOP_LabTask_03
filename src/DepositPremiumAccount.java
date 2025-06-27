public class DepositPremiumAccount extends Account {
    private int installments = 0;

    public DepositPremiumAccount(int id, String name, double initialBalance) {
        super(id, name, 0);
        if (initialBalance > 0) {
            deposit(initialBalance);  // counts as 1st installment
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            super.deposit(amount);
            if (installments < 5) {
                installments++;
                double interest = getBalance() * 0.07;
                setBalance(getBalance() + interest);
                System.out.println(" Installment " + installments + "/5 deposited.");
                System.out.println(" 7% interest added. New balance: " + getBalance());
            } else {
                System.out.println(" All 5 installments already deposited.");
            }
        }
    }

    public boolean withdraw(double amount) {
        if (installments == 5 && amount <= getBalance()) {
            setBalance(getBalance() - amount);
            return true;
        }
        return false;
    }

    public void addInterest() {
        // empty, interest added during deposit
    }

    public boolean transfer(Account to, double amount) {
        System.out.println(" Cannot transfer from Deposit Premium Account.");
        return false;
    }
}
