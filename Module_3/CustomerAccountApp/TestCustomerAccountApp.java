import java.util.Scanner;

public class TestCustomerAccountApp {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        // Prompt user to enter a customer ID between 1007 and 1009
        System.out.print("Enter a Customer ID (1007-1009): ");
        int id = input.nextInt();
        
        // Retrieve customer information from CustomerDB
        Customer customer = CustomerDB.getCustomer(id);
        
        // Display account menu
        Account account = customer.getAccount();
        account.displayMenu();
        
        char option;
        do {
            // Prompt user to select an option
            System.out.print("\nEnter option: ");
            option = input.next().charAt(0);
            
            switch (option) {
                case 'd':
                case 'D':
                    // Deposit
                    System.out.print("Enter deposit amount: ");
                    double depositAmt = input.nextDouble();
                    account.deposit(depositAmt);
                    break;
                case 'w':
                case 'W':
                    // Withdraw
                    System.out.print("Enter withdraw amount: ");
                    double withdrawAmt = input.nextDouble();
                    account.withdraw(withdrawAmt);
                    break;
                case 'b':
                case 'B':
                    // Balance
                    System.out.printf("Account balance: $%,6.2f\n", account.getBalance());
                    break;
                default:
                    // Invalid option
                    System.out.println("Error: Invalid option");
                    break;
            }
            
            // Prompt user to continue or exit the menu
            System.out.print("\nContinue? (y/n): ");
            option = input.next().charAt(0);
            
        } while (option == 'y' || option == 'Y');
        
        // Display customer details and account balance
        System.out.println("\n--Customer Details--");
        System.out.println(customer.toString());
        System.out.printf("\nBalance as of %s is $%,6.2f\n", account.getTransactionDate(), account.getBalance());
        
        // Close Scanner
        input.close();
        
    }

}
