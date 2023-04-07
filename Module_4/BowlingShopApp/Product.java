public class Product {
    private String code;
    private String description;
    private double price;

    // No-argument constructor
    public Product() {
        this.code = "";
        this.description = "";
        this.price = 0.0;
    }

    // Constructor with parameters
    public Product(String code, String description, double price) {
        this.code = code;
        this.description = description;
        this.price = price;
    }

    // Accessor methods
    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    // Mutator methods
    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Override toString() method
    @Override
    public String toString() {
        return "Code: " + code + "\n" +
               "Description: " + description + "\n" +
               "Price: $" + price;
    }
}
