public class Bag extends Product {
    private String type;

    // No-argument constructor
    public Bag() {
        super(); // Call the superclass's no-argument constructor
        this.type = "";
    }

    // Constructor with parameters
    public Bag(String code, String description, double price, String type) {
        super(code, description, price); // Call the superclass's constructor with parameters
        this.type = type;
    }

    // Accessor method for type
    public String getType() {
        return type;
    }

    // Mutator method for type
    public void setType(String type) {
        this.type = type;
    }

    // Override toString() method
    @Override
    public String toString() {
        return super.toString() + "\n" +
               "Type: " + type;
    }
}
