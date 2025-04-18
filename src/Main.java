import java.util.*;

public class Main {
    static Book[] inventory = new Book[20];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeInventory();

        //infinite loop
        while (true) {
            System.out.println("\n--- Store Home Screen ---");
            System.out.println("1. Show Available Books");
            System.out.println("2. Show Checked Out Books");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    showAvailableBooks(scanner);
                    break;
                case "2":
                    showCheckedOutBooks(scanner);
                    break;
                case "3":
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
        //Book titles
        static String[] bookTitles = {"The Curious Incident of the Dog in the Night-Time", "Do Androids Dream of Electric Sheep?", "A Thousand Splendid Suns", "Brave New World", "Wide Sargasso Sea", "East of Eden", "How to Solve Your Own Murder", "Number the Stars",
                      "Pale Fire", "Romeo and Juliet", "The Night Before Christmas", "The Stars Have Eyes", "A Few Things I Love", "A Guide To Courteous Thievery", "A Many-splendoured Thing", "The Alchemist", "The Da Vinci Code", "The Twilight Saga",
                      "Gone With the Wind", };

    //Populate our objects
    private static void initializeInventory() {
        for (int i = 0; i < bookTitles.length; i++) {
            if (bookTitles[i] == null){
                continue;
            }
            inventory[i] = new Book(i + 1, "ISBN" + (1000 + i), bookTitles[i]);
        }
    }

    private static void showAvailableBooks(Scanner scanner) {
        System.out.println("\nAvailable Books:");
        for (Book book : inventory) {
            if (book != null && !book.getIsCheckedOut()) {
                System.out.println(book.toString());
            }
        }

        System.out.print("\nEnter book ID to check out or 0 to return: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (id == 0) return;

        Book selected = findBookById(id);
        if (selected != null && !selected.getIsCheckedOut()) {
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            selected.checkOut(name);
            System.out.println("Book checked out successfully.");
        } else {
            System.out.println("Invalid selection or book is already checked out.");
        }
    }

    private static void showCheckedOutBooks(Scanner scanner) {
        System.out.println("\nChecked Out Books:");
        for (Book book : inventory) {
            if (book.getIsCheckedOut()) {
                System.out.println(book.checkedOutInfo());
            }
        }

        System.out.print("\nEnter C to check in a book, X to return: ");
        String option = scanner.nextLine();

        if (option.equalsIgnoreCase("C")) {
            System.out.print("Enter book ID to check in: ");
            int id = Integer.parseInt(scanner.nextLine());
            Book selected = findBookById(id);
            if (selected != null && selected.getIsCheckedOut()) {
                selected.checkIn();
                System.out.println("Book checked in successfully.");
            } else {
                System.out.println("Invalid selection or book is not checked out.");
            }
        }
    }

    private static Book findBookById(int id) {
        for (Book book : inventory) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
}
