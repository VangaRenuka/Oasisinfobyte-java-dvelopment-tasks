import java.util.Scanner;

public class ATMInterface {
    private static Scanner scanner = new Scanner(System.in);
    private static ATM atm;

    public static void main(String[] args) {
        atm = new ATM();

        System.out.println("Welcome to the ATM");
        System.out.println("------------------");

        // Prompt for user ID and PIN
        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        System.out.print("Enter User PIN: ");
        int userPin = scanner.nextInt();

        // Validate user ID and PIN
        if (atm.authenticateUser(userId, userPin)) {
            System.out.println("Authentication successful!");

            // Display the menu
            showMenu();
        } else {
            System.out.println("Invalid user ID or PIN. Exiting...");
        }
    }

    private static void showMenu() {
        boolean quit = false;

        while (!quit) {
            System.out.println("\nATM Menu");
            System.out.println("------------------");
            System.out.println("1. Transactions History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showTransactionsHistory();
                    break;
                case 2:
                    performWithdrawal();
                    break;
                case 3:
                    performDeposit();
                    break;
                case 4:
                    performTransfer();
                    break;
                case 5:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Thank you for using the ATM. Goodbye!");
    }

    private static void showTransactionsHistory() {
        Transaction[] transactions = atm.getTransactions();
        System.out.println("\nTransactions History");
        System.out.println("------------------");

        if (transactions.length > 0) {
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        } else {
            System.out.println("No transactions found.");
        }
    }

    private static void performWithdrawal() {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (atm.withdraw(amount)) {
            System.out.println("Withdrawal successful. Please take your cash.");
        } else {
            System.out.println("Insufficient funds or invalid amount. Please try again.");
        }
    }

    private static void performDeposit() {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();

        atm.deposit(amount);
        System.out.println("Deposit successful. Thank you for banking with us!");
    }

    private static void performTransfer() {
        System.out.print("Enter the account number to transfer to: ");
        String accountNumber = scanner.next();

        System.out.print("Enter the amount to transfer: ");
        double amount = scanner.nextDouble();

        if (atm.transfer(accountNumber, amount)) {
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Invalid account number or insufficient funds. Please try again.");
        }
    }
}

class ATM {
    private int userId;
    private int userPin;
    private Transaction[] transactions;

    public ATM() {
        this.userId = 12345; // Sample user ID
        this.userPin = 6789; // Sample user PIN
        this.transactions = new Transaction[10]; // Sample transaction array
    }

    public boolean authenticateUser(int userId, int userPin) {
        return this.userId == userId && this.userPin == userPin;
    }

    public Transaction[] getTransactions() {
        return transactions;
    }

    public boolean withdraw(double amount) {
        // Perform withdrawal logic
        // Return true if successful, false otherwise
        return true;
    }

    public void deposit(double amount) {
        // Perform deposit logic
    }

    public boolean transfer(String accountNumber, double amount) {
        // Perform transfer logic
        // Return true if successful, false otherwise
        return true;
    }
}

class Transaction {
    private String type;
    private double amount;
    private String date;

    public Transaction(String type, double amount, String date) {
        this.type = type;
        this.amount = amount;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Type: " + type + ", Amount: " + amount + ", Date: " + date;
    }
}

   
        
        