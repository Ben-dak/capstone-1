package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        ConsoleInterface io = new ConsoleInterface();
        CsvRepo repo = new CsvRepo();
        TransactionService svc = new TransactionService();
        ReportService reports = new ReportService();
        LedgerView ledger = new LedgerView();


    }
}
