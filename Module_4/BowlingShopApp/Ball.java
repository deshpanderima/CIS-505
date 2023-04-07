public class Ball extends Product {
    private String color;

    // No-argument constructor
    public Ball() {
        super(); // Call the superclass's no-argument constructor
        this.color = "";
    }

    // Constructor with parameters
    public Ball(String code, String description, double price, String color) {
        super(code, description, price); // Call the superclass's constructor with parameters
        this.color = color;
    }

    // Accessor method for color
    public String getColor() {
        return color;
    }

    // Mutator method for color
    public void setColor(String color) {
        this.color = color;
    }

    // Override toString() method
    @Override
    public String toString() {
        return super.toString() + "\n" +
               "Color: " + color;
    }
}
