package utils;

import java.util.Scanner;
import java.util.List;

public class ConsoleUtils {
    private static Scanner scanner = new Scanner(System.in);

    public static void displayMenu() {
        System.out.println("\n==== Library Management System ====");
        System.out.println("1. Add New Book");
        System.out.println("2. Add New Borrower");
        System.out.println("3. Borrow a Book");
        System.out.println("4. Return a Book");
        System.out.println("5. Search Books");
        System.out.println("6. Display All Books");
        System.out.println("7. Display All Borrowers");
        System.out.println("8. Display Borrow Records");
        System.out.println("0. Exit");
    }

    public static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    public static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static void displayList(String title, List<?> items) {
        System.out.println("\n=== " + title + " ===");
        if (items.isEmpty()) {
            System.out.println("No items found.");
        } else {
            items.forEach(System.out::println);
        }
    }

    public static void pressToContinue() {
        System.out.print("\nPress Enter to continue...");
        scanner.nextLine();
    }
}