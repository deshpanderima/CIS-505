import java.util.Scanner;

public class TestComposerApp {

    private static final MemComposerDao dao = new MemComposerDao();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to the Composer App");
            System.out.println("MENU OPTIONS");
            System.out.println("1. View Composers");
            System.out.println("2. Find Composer");
            System.out.println("3. Add Composer");
            System.out.println("4. Exit");
            System.out.print("Please choose an option: ");

            int choice = input.nextInt();
            input.nextLine(); // consume the remaining newline character

            switch (choice) {
                case 1:
                    displayComposers();
                    break;
                case 2:
                    findComposer(input);
                    break;
                case 3:
                    addComposer(input);
                    break;
                case 4:
                    System.out.println("Exiting the program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    private static void displayComposers() {
        System.out.println("\n-DISPLAYING COMPOSERS-");
        dao.findAll().forEach(System.out::println);
    }

    private static void findComposer(Scanner input) {
        System.out.print("Enter an id: ");
        int id = input.nextInt();
        input.nextLine(); // consume the remaining newline character

        Composer composer = dao.findBy(id);
        if (composer != null) {
            System.out.println("\n-DISPLAYING COMPOSER-");
            System.out.println(composer);
        } else {
            System.out.println("\nComposer not found.");
        }
    }

    private static void addComposer(Scanner input) {
        System.out.print("Enter an id: ");
        int id = input.nextInt();
        input.nextLine(); // consume the remaining newline character

        System.out.print("Enter a name: ");
        String name = input.nextLine();

        System.out.print("Enter a genre: ");
        String genre = input.nextLine();

        dao.insert(new Composer(id, name, genre));
        System.out.println("\nComposer added successfully.");
    }
}
