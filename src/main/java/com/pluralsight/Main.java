package com.pluralsight;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    String name;
    ArrayList<Transaction> transList = new ArrayList<>();
    private void bWriter(String string) {
    }

    public static void main(String[] args) {
        String fileName = "transactions.csv";
        // mainMenu();

        LocalDate today = LocalDate.now();
        String vendor = "Amazon";
        LocalTime clock = LocalTime.now();
        String desc = "Keyboard";
        double price = 89.50;
        Transaction transactions = new Transaction(today, clock, desc, vendor, price);

    }

    public void writer() {
        try (BufferedWriter bWriter = new BufferedWriter(new FileWriter("src/main/resources/transactions.csv"))) {

            bWriter.write("date|time|description|vendor|amount");//writing header
            bWriter.newLine();

            for (Transaction transactions : transList) {
                bWriter.write(transactions.toString());
                bWriter.newLine();
            }

        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }

    public void readTransaction() {
        try (BufferedReader bReader = new BufferedReader(new FileReader("src/main/resources/transactions.csv"))) {

            String header = bReader.readLine();

            String info;

            while ((info = bReader.readLine()) != null) {
                String[] parts = info.split("\\|");
                LocalDate date = LocalDate.parse(parts[0]);
                LocalTime time = LocalTime.parse(parts[1]);
                String description = parts[2];
                String vendor = parts[3];
                double amount = Double.parseDouble(parts[4]);

                Transaction transactions = new Transaction(date, time, description, vendor, amount);
                transList.add(transactions);
            }

        } catch (FileNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error" + e.getMessage());
        }

    }




    private static void mainMenu() {
        Scanner myScanner = new Scanner(System.in);
        String userInput;
        do {
            System.out.println("""
                    === Home Menu ===
                    D) Add Deposit
                    P) Make Payment (Debit)
                    L) Ledger
                    X) Exit
                    """);
            System.out.print("Choose an option: ");
            userInput = myScanner.next();

            switch (userInput) {
                case "D" -> System.out.println("Add Deposit selected...");
                case "P" -> System.out.println("Make Payment selected...");
                case "L" -> ledgerMenu();
                case "X" -> System.out.println("Exiting application...");
                default -> System.out.println("Invalid option. Please try again.");
            }
        } while (userInput.equals("X"));
    }

    private static void ledgerMenu() {
        Scanner myScanner = new Scanner(System.in);
        String userInput;
        do {
            System.out.println("""
                    === Home Menu ===
                    A) Print all transactions
                    H) Exit
                    """);
            System.out.print("Choose an option: ");
            userInput = myScanner.next();

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