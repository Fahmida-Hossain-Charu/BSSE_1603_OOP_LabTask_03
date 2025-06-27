import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CurrentAccount current = null;
        SavingsAccount savings = null;
        DepositPremiumAccount premium = null;

        int choice;
        do {
            System.out.println("\n===Bank Account ===");
            System.out.println("1. Create Accounts");
            System.out.println("2. Show Account Details");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Transfer Money");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            double amt;
            switch (choice) {
                case 1:
                    sc.nextLine(); // consume newline

                    System.out.print("Enter Current Account Name: ");
                    String cname = sc.nextLine();
                    System.out.print("Enter opening balance: ");
                    double cbalance = sc.nextDouble();
                    current = new CurrentAccount(101, cname, cbalance);

                    sc.nextLine(); // flush newline
                    System.out.print("Enter Savings Account Name: ");
                    String sname = sc.nextLine();

                    double sbalance;
                    while (true) {
                        System.out.print("Enter opening balance (Minimum 1000): ");
                        sbalance = sc.nextDouble();
                        if (sbalance >= 1000) {
                            savings = new SavingsAccount(102, sname, sbalance);
                            break;
                        } else {
                            System.out.println(" Savings Account must have at least 1000 as starting balance.");
                        }
                    }

                    sc.nextLine(); // flush newline
                    System.out.print("Enter Deposit Premium Account Name: ");
                    String pname = sc.nextLine();
                    System.out.print("Enter opening deposit (counts as first installment): ");
                    double pBalance = sc.nextDouble();
                    premium = new DepositPremiumAccount(103, pname, pBalance);

                    System.out.println(" All accounts created successfully.");
                    break;

                case 2:
                    System.out.println("\n--- Account Details ---");
                    if (current != null) System.out.println(current);
                    if (savings != null) System.out.println(savings);
                    if (premium != null) System.out.println(premium);
                    break;

                case 3:
                    System.out.println("\n--- Deposit To ---");
                    System.out.println("1. Current");
                    System.out.println("2. Savings");
                    System.out.println("3. Deposit Premium");
                    System.out.print("Choice: ");
                    int dOpt = sc.nextInt();
                    System.out.print("Enter amount: ");
                    amt = sc.nextDouble();

                    if (dOpt == 1 && current != null) {
                        current.deposit(amt);
                        System.out.println(" Deposited to Current Account.");
                    } else if (dOpt == 2 && savings != null) {
                        savings.deposit(amt);
                        System.out.println(" Deposited to Savings Account.");
                    } else if (dOpt == 3 && premium != null) {
                        premium.deposit(amt);
                    } else {
                        System.out.println(" Invalid or missing account.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- Withdraw From ---");
                    System.out.println("1. Current");
                    System.out.println("2. Savings");
                    System.out.println("3. Deposit Premium");
                    System.out.print("Choice: ");
                    int wOpt = sc.nextInt();
                    System.out.print("Enter amount: ");
                    amt = sc.nextDouble();

                    if (wOpt == 1 && current != null) {
                        if (!current.withdraw(amt)) System.out.println(" Insufficient balance.");
                    } else if (wOpt == 2 && savings != null) {
                        if (!savings.withdraw(amt)) System.out.println(" Insufficient balance or below minimum balance.");
                    } else if (wOpt == 3 && premium != null) {
                        if (!premium.withdraw(amt)) System.out.println(" Cannot withdraw before completing 5 installments or insufficient balance.");
                    } else {
                        System.out.println(" Invalid or missing account.");
                    }
                    break;

                case 5:
                    System.out.println("\n--- Transfer Options ---");
                    System.out.println("1. Current → Savings");
                    System.out.println("2. Savings → Current");
                    System.out.println("3. Current → Deposit Premium");
                    System.out.println("4. Savings → Deposit Premium");
                    System.out.print("Choice: ");
                    int tOpt = sc.nextInt();
                    System.out.print("Enter amount: ");
                    amt = sc.nextDouble();

                    boolean success = false;
                    switch (tOpt) {
                        case 1:
                            if (current != null && savings != null) success = current.transfer(savings, amt);
                            break;
                        case 2:
                            if (savings != null && current != null) success = savings.transfer(current, amt);
                            break;
                        case 3:
                            if (current != null && premium != null) success = current.transfer(premium, amt);
                            break;
                        case 4:
                            if (savings != null && premium != null) success = savings.transfer(premium, amt);
                            break;
                        default:
                            System.out.println(" Invalid option.");
                    }
                    if (!success) System.out.println(" Transfer failed.");
                    break;

                case 0:
                    System.out.println(" Exiting. Thank you!");
                    break;

                default:
                    System.out.println(" Invalid menu option.");
            }
        } while (choice != 0);

        sc.close();
    }
}
