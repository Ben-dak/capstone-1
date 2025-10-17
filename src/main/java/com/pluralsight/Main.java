package com.pluralsight;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Transaction> tList = new ArrayList<>(); // Array List used for transactions
    static Scanner myScanner = new Scanner(System.in);
    static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-M-d|HH:mm:ss"); // Defines how date is rendered

    public static void main(String[] args) {
        mainMenu(); // Kick off the main menu loop
    }

    public static void writer() {                                                  // Writes the current list to CSV
        try (BufferedWriter bWriter = new BufferedWriter(                          // try‑with resources ensures the writer closes
                new FileWriter("src/main/resources/transactions.csv"))) { // Creates a BufferedWriter that wraps a FileWriter to write text to a file

            bWriter.write("date|time|description|vendor|amount"); //writes header to file
            bWriter.newLine();                                        // Moves to a new line after writing the header

            for (Transaction transactions : tList) {    // Loops through each Transaction
                bWriter.write(transactions.toString()); // Converts the Transaction to text
                bWriter.newLine();                      // Starts a new line for the next transaction
            }

        } catch (IOException e) {                                        // If something goes wrong while writing - prints error message to the console
            System.err.println("Error writing file: " + e.getMessage());
        }
    }

    public static void readTransaction() {
        try (BufferedReader bReader = new BufferedReader(
                new FileReader("src/main/resources/transactions.csv"))) { // Reads the transactions.csv
            String header = bReader.readLine();                                   // Header is just read and ignored
            String info;                                                          //info holds each line of text

            while ((info = bReader.readLine()) != null) {   // When readLine() returns null it means there are no more lines
                String[] parts = info.split("\\|");   // Splits the line into separate pieces using "|" (pipe)
                LocalDate date = LocalDate.parse(parts[0]); // converts date string into LocalDate object
                LocalTime time = LocalTime.parse(parts[1]); // converts time string into LocalTime object
                String description = parts[2];
                String vendor = parts[3];
                double amount = Double.parseDouble(parts[4]); // Converts "amount" string into a double

                Transaction transactions = new Transaction(date, time, description, vendor, amount); // Creates a new Transaction object using the data we just read and converted
                tList.add(transactions);                                                             // Adds this new Transaction object to the Array list (tList)
            }

        } catch (FileNotFoundException e) {                 // runs if the file can’t be found
            System.err.println("Error: " + e.getMessage());
        } catch (IOException e) {                           // This catch handles general input/output problems
            System.err.println("Error" + e.getMessage());
        }
    }

    public static void addDeposit() {
        boolean runAgain = true;
        while (runAgain) {
            try (FileWriter fileWriter = new FileWriter("src/main/resources/transactions.csv")) {
                System.out.println("Enter an amount: ");                            //Prompts the user to enter an amount
                String amountString = myScanner.nextLine().trim();
                System.out.println("Enter a description: ");
                String description = myScanner.nextLine().trim();
                System.out.println("Enter the vendor: ");
                String vendor = myScanner.nextLine().trim();
                double amount = Double.parseDouble(amountString);
                Transaction deposit = new Transaction(description, vendor, amount);
                tList.add(deposit);                                                 //Stores deposit info into the tList array
                String formattedDate = LocalDateTime.now().format(dateTimeFormatter);
                fileWriter.write(String.format("%s|%s|%s|%.2f", formattedDate, description, vendor, amount));
                runAgain = false;
            } catch (NumberFormatException e) {
                System.out.println("Error: " + e);
            } catch (IOException e) {
                System.err.println("Error: " + e);
            }
        }
    }

    public static void addPayment() {
        boolean runAgain = true;
        while (runAgain) {
            try (FileWriter fileWriter = new FileWriter("src/main/resources/transactions.csv")) {
                System.out.println("Enter an amount: ");                              //Prompts the user to enter an amount
                String amountString = myScanner.nextLine().trim();
                System.out.println("Enter a description: ");
                String description = myScanner.nextLine().trim();
                System.out.println("Enter the vendor: ");
                String vendor = myScanner.nextLine().trim();
                double amount = Double.parseDouble(amountString);
                amount = -Math.abs(amount);                                           //Ensures the amount is negative
                Transaction payment  = new Transaction(description, vendor, amount);
                tList.add(payment);                                                  //Stores deposit info into the tList array
                String formattedDate = LocalDateTime.now().format(dateTimeFormatter);
                fileWriter.write(String.format("%s|%s|%s|%.2f", formattedDate, description, vendor, amount));
                runAgain = false;
            } catch (NumberFormatException e) {
                System.out.println("Error: " + e);
            } catch (IOException e) {
                System.err.println("Error: " + e);
            }
        }
    }

    public static void mainMenu() {
        readTransaction();
        //Creates a scanner object to read input
        String userInput;// Variable to store options
        do { //do-while loop
            System.out.println("""
                    === Home Menu ===
                    D) Add Deposit
                    P) Make Payment (Debit)
                    L) Ledger
                    X) Exit
                    """);//Displays main menu text
            System.out.print("Choose an option: ");//prompts user
            userInput = myScanner.next().trim();//reads input then moves to next input

            switch (userInput) { //checks what user enters then performs action
                case "D" -> {
                    System.out.println("Add Deposit selected...");
                    myScanner.nextLine();
                    addDeposit();
                }
                case "P" -> {
                    System.out.println("Make Payment selected...");
                    myScanner.nextLine();
                    addPayment();
                }
                case "L" -> ledgerMenu();
                case "X" -> System.out.println("Exiting application...");
                default -> System.out.println("Invalid option. Please try again.");
            }
        } while (!userInput.equals("X"));
    }

    public static void ledgerMenu() {
        Scanner myScanner = new Scanner(System.in);
        String userInput;
        do {
            System.out.println("""
                    === Ledger Menu ===
                    A) Print all transactions
                    H) Exit
                    """);
            System.out.print("Choose an option: ");
            userInput = myScanner.next();

            switch (userInput) {
                case "A":
                    printAllTransactions(tList);
                    break;
                case "H":
                    System.out.println("Exiting application...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (!userInput.equals("H"));
    }

    public static void printAllTransactions(ArrayList<Transaction> transactions) {
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }
        System.out.println("=== All Transactions ===");
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }
}