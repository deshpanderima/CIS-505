import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TransactionIO {

    private static final String FILE_NAME = "expenses.txt";
    private static File file = new File(FILE_NAME);

    // Method to bulk insert transactions to the text file
    public static void bulkInsert(ArrayList<Transaction> transactions) throws IOException {
        PrintWriter output = null;
        try {
            if (file.exists()) {
                output = new PrintWriter(new FileOutputStream(file, true));
            } else {
                output = new PrintWriter(FILE_NAME);
            }
            for (Transaction tran : transactions) {
                output.print(tran.getDate() + " ");
                output.print(tran.getDescription() + " ");
                output.println(tran.getAmount());
            }
        } finally {
            if (output != null) {
                output.close();
            }
        }
    }

    // Method to find all transactions from the text file
    public static ArrayList<Transaction> findAll() throws IOException {
        ArrayList<Transaction> transactions = new ArrayList<>();
        Scanner input = null;
        try {
            input = new Scanner(file);
            while (input.hasNext()) {
                String date = input.next();
                String description = input.next();
                double amount = input.nextDouble();
                Transaction transaction = new Transaction(date, description, amount);
                transactions.add(transaction);
            }
        } finally {
            if (input != null) {
                input.close();
            }
        }
        return transactions;
    }
}
