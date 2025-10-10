package com.pluralsight;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        while (true) {
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
                //Need to prompt user for the deposit information and save it to the csv file
            } else if (option == "P") {
                System.out.println("Enter your debit card information: ");
                //Need to prompt user for the debit information and save it to the csv file
            } else if (option == "L") {
                System.out.println("Here is the Ledger: ");
                //Need to display the ledger screen
            }else{
                System.out.println("----Application Closed----");
                break;


            }
        }
    }

}
