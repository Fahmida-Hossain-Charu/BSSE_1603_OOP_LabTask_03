public class DepositPremiumAccount extends Account {
    private int installments = 0;

    public DepositPremiumAccount(int id, String name) {
        super(id, name, 0);
    }


    public void deposit(double amount) {
        if (amount > 0) {
            super.deposit(amount);
            if (installments < 5) {
                installments++;
                System.out.println(" Premium Account Installment " + installments + "/5 deposited.");
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
        double interest = getBalance() * 0.07;
        setBalance(getBalance() + interest);
    }


    public boolean transfer(Account to, double amount) {
        System.out.println(" Cannot transfer from Deposit Premium Account.");
        return false;
    }
}
