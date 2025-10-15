package com.pluralsight;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String fileName = "transactions.csv";
        mainMenu();
    }

    private static void mainMenu() {
        Scanner scanner = new Scanner(System.in);
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
            userInput = scanner.next().toUpperCase().charAt(0);

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
        char userInput;

        do {

        }while(true);

    }
}