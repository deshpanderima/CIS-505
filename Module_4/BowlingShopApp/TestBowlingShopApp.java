import java.util.Scanner;

public class TestBowlingShopApp {
    public static void main(String[] args) {
        displayMenu();
    }

    public static void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        String choice = "";
        GenericQueue<Product> products = new GenericQueue<>();
        ProductDB productDB = new ProductDB();

        while (!choice.equalsIgnoreCase("x")) {
            System.out.println("Welcome to the Bowling Shop");
            System.out.println("MENU OPTIONS");
            System.out.println("1. <b> Bowling Balls");
            System.out.println("2. <a> Bowling Bags");
            System.out.println("3. <s> Bowling Shoes");
            System.out.println("4. <x> To exit");
            System.out.print("Please choose an option: ");
            choice = scanner.nextLine();

            switch (choice.toLowerCase()) {
                case "b":
                    products = productDB.getProducts("Bowling Balls");
                    break;
                case "a":
                    products = productDB.getProducts("Bowling Bags");
                    break;
                case "s":
                    products = productDB.getProducts("Bowling Shoes");
                    break;
                case "x":
                    System.out.println("End of line...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue;
            }

            System.out.println("-Product Listing-");
            while (products.size() > 0) {
                Product product = products.dequeue();
                System.out.println("Product code: " + product.getProductCode());
                System.out.println("Description: " + product.getDescription());
                System.out.printf("Price: $%,6.2f%n", product.getPrice());
                System.out.println(product.getAdditionalInfo());
                System.out.println();
            }
        }

        scanner.close();
    }
}
