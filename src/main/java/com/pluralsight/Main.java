package com.pluralsight;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        do {
            System.out.println("""
                    D) Add Deposit
                    P) Make Payment (Debit)
                    L) Ledger
                    X) Exit
                    """);

            System.out.println("Select one of the options above: ");
            String option = myScanner.nextLine();

            if (Objects.equals(option, "D")) {
                System.out.println("Enter the amount you would like to deposit: ");
                break;
                //Need to prompt user for the deposit information and save it to the csv file
            } else if (Objects.equals(option, "P")) {
                System.out.println("Enter your debit card information: ");
                break;
                //Need to prompt user for the debit information and save it to the csv file
            } else if (Objects.equals(option, "L")) {
                System.out.println("Here is the Ledger: ");
                break;
                //Need to display the ledger screen
            } else {
                System.out.println("----Application Closed----");
                break;


            }
        } while (true);
    }

}
