import java.util.Scanner;

// Class to represent the user's bank account
class BankAcc {
    private double balance;

    public BankAcc(double initialBalance) {
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
            return "the amount should be more than 0";
        }
        if (amt > balance) {
            return "no balance";
        }
        balance = balance - amt;
        return "money withdrawn\nnew balance: " + balance;
    }

    public String deposit(double amt) {
        if (amt <= 0) {
            return "the amount should be more than 0";
        }
        balance = balance + amt;
        return "money deposited\nnew balance: " + balance;
    }
}

// Class to represent the ATM machine
public class task3 {
    private BankAcc bankAcc;

    public task3(BankAcc bankAcc) {
        this.bankAcc = bankAcc;
    }

    public String checkBalance() {
        return "current balance: " + bankAcc.getBalance();
    }

    public static void main(String[] args) {
        BankAcc acc = new BankAcc(100); 
        task3 atm = new task3(acc);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nATM Options:");
            System.out.println("1. withdraw");
            System.out.println("2. deposit");
            System.out.println("3. check balance");
            System.out.println("4. exit");

            System.out.print("enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("enter the amount: ");
                    double withdrawAmt = sc.nextDouble();
                    System.out.println(acc.withdraw(withdrawAmt));
                    break;
                case 2:
                    System.out.print("enter the amount: ");
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
