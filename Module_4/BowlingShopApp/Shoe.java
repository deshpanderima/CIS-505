public class Shoe extends Product {
    private double size;

    // No-argument constructor
    public Shoe() {
        super(); // Call the superclass's no-argument constructor
        this.size = 0;
    }

    // Constructor with parameters
    public Shoe(String code, String description, double price, double size) {
        super(code, description, price); // Call the superclass's constructor with parameters
        this.size = size;
    }

    // Accessor method for size
    public double getSize() {
        return size;
    }

    // Mutator method for size
    public void setSize(double size) {
        this.size = size;
    }

    // Override toString() method
    @Override
    public String toString() {
        return super.toString() + "\n" +
               "Size: " + size;
    }
}
