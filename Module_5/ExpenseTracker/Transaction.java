import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    private String date; // Date of the transaction
    private String description; // Description of the transaction
    private double amount; // Amount of the transaction

    // Default constructor - sets default values
    public Transaction() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        this.date = dateFormat.format(new Date());
        this.description = "";
        this.amount = 0;
    }

    // Argument constructor - sets values based on input
    public Transaction(String date, String description, double amount) {
        this.date = date;
        this.description = description;
        this.amount = amount;
    }

    // Accessor methods
    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }
	
    public double getAmount() {
        return amount;
    }

    // Mutator methods
    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Override toString method to return a string description of the transaction
    @Override
    public String toString() {
        return "Date: " + date + "\n" +
                "Description: " + description + "\n" +
                "Amount: " + amount;
    }
}
