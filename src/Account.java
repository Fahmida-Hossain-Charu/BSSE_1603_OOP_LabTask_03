public abstract class Account {
    private int id;
    private String name;
    private double balance;

    public Account(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }


    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean transfer(Account to, double amount) {
        if (withdraw(amount)) {
            to.deposit(amount);
            return true;
        }
        return false;
    }

    public abstract boolean withdraw(double amount);
    public abstract void addInterest();

    public String toString() {
        return getClass().getSimpleName() + " [ID: " + id + ", Name: " + name + ", Balance: " + balance + "]";
    }
}
