package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    String name;

    public static void main(String[] args) {
        String fileName = "transactions.csv";
        // mainMenu();

//        Transaction amazon;
//        amazon = new Transaction("Amazon");

        LocalDate today = LocalDate.now();
        String vendor = "Amazon";
        LocalTime clock = LocalTime.now();
        String desc = "Keyboard";
        double price = 89.50;
        Transaction transactions = new Transaction(today, vendor, clock, desc, price);

        System.out.printf("%s|%s|%s|%s|%.2f%n",
                transactions.getDate(),
                transactions.getTime(),
                transactions.getDescription(),
                transactions.getVendor(),
                transactions.getAmount());

    }

    private static void mainMenu() {
        Scanner myScanner = new Scanner(System.in);
        char userInput;
        do {
            System.out.println("""
                    === Home Menu ===
                    D) Add Deposit
                    P) Make Payment (Debit)
                    L) Ledger
                    X) Exit
                    """);
            System.out.print("Choose an option: ");
            userInput = myScanner.next().toUpperCase().charAt(0);

            switch (userInput) {
                case 'D' -> System.out.println("Add Deposit selected...");
                case 'P' -> System.out.println("Make Payment selected...");
                case 'L' -> ledgerMenu();
                case 'X' -> System.out.println("Exiting application...");
                default -> System.out.println("Invalid option. Please try again.");
            }
        } while (userInput != 'X');
    }

    private static void ledgerMenu() {
        Scanner scanner = new Scanner(System.in);
        String userInput;
        do {
            System.out.println("""
                    === Home Menu ===
                    A) Print all transactions
                    H) Exit
                    """);
            System.out.print("Choose an option: ");
            userInput = scanner.next();

            switch (userInput) {
                case "A":
                    printAllTransactions();
                    break;
                case "H":
                    System.out.println("Exiting application...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (userInput.equals("H"));
    }

    static void printAllTransactions() {

    }

}