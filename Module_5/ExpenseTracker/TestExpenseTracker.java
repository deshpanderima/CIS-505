import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestExpenseTracker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            System.out.println("Welcome to the Expense Tracker");
            System.out.println("MENU OPTIONS");
            System.out.println("1. View Transactions");
            System.out.println("2. Add Transactions");
            System.out.println("3. View Expense");
            System.out.print("Please choose an option: ");
            int input = ValidatorIO.getInt(sc, "Invalid input. Please enter a number: ");

            if (input == 1) {
                System.out.println("MONTHLY EXPENSES");
                ArrayList<Transaction> transactions;
                try {
                    transactions = TransactionIO.findAll();
                    for (Transaction transaction : transactions) {
                        System.out.println("Date: " + transaction.getDate());
                        System.out.println("Description: " + transaction.getDescription());
                        System.out.printf("Amount: $%,6.2f%n", transaction.getAmount());
                    }
                } catch (IOException e) {
                    System.out.println("\nException: " + e.getMessage());
                }
            } else if (input == 2) {
                String c = "y";
                ArrayList<Transaction> transactions = new ArrayList<>();
                while (c.equalsIgnoreCase("y")) {
                    String description = ValidatorIO.getString(sc, "Enter the description: ");
                    double amount = ValidatorIO.getDouble(sc, "Enter the amount: ");
                    Transaction transaction = new Transaction(description, amount);
                    transactions.add(transaction);
                    c = ValidatorIO.getString(sc, "Add another transaction? (y/n): ");
                }
                try {
                    TransactionIO.bulkInsert(transactions);
                } catch (IOException e) {
                    System.out.println("\nException: " + e.getMessage());
                }
            } else if (input == 3) {
                ArrayList<Transaction> transactions;
                try {
                    transactions = TransactionIO.findAll();
                    double monthlyExpense = 0.0;
                    for (Transaction transaction : transactions) {
                        monthlyExpense += transaction.getAmount();
                    }
                    System.out.printf("Your total monthly expense is $%,6.2f%n", monthlyExpense);
                } catch (IOException e) {
                    System.out.println("\nException: " + e.getMessage());
                }
            } else {
                System.out.println("Invalid input. Please choose a valid option.");
            }

            System.out.print("Continue? (y/n): ");
            choice = ValidatorIO.getString(sc, "Invalid input. Please enter 'y' or 'n': ");
        }

        System.out.println("Program terminated by the user...");
        sc.close();
    }
}
