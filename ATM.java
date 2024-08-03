import java.util.Scanner;

// Class to represent the user's bank account
class task3 {
    private double balance;

    public task3(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String withdraw(double amt) {
        if (amt <= 0) {
            return "The amount should be more than 0";
        }
        if (amt > balance) {
            return "No sufficient balance";
        }
        balance = balance - amt;
        return "Money withdrawn\nNew balance: " + balance;
    }

    public String deposit(double amt) {
        if (amt <= 0) {
            return "The amount should be more than 0";
        }
        balance = balance + amt;
        return "Money deposited\nNew balance: " + balance;
    }
}

// Class to represent the ATM machine
public class ATM {
    private task3 Task3;

    public ATM(task3 Task3) {
        this.Task3 = Task3;
    }

    public String checkBalance() {
        return "Current balance: " + Task3.getBalance();
    }

    public static void main(String[] args) {
        task3 acc = new task3(100); // Initial balance of 100
        ATM atm = new ATM(acc);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nATM Options:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the amount: ");
                    double withdrawAmt = sc.nextDouble();
                    System.out.println(acc.withdraw(withdrawAmt));
                    break;
                case 2:
                    System.out.print("Enter the amount: ");
                    double depositAmt = sc.nextDouble();
                    System.out.println(acc.deposit(depositAmt));
                    break;
                case 3:
                    System.out.println(atm.checkBalance());
                    break;
                case 4:
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
