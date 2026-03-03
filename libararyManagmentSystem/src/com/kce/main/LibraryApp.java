package com.kce.main;

import java.util.Scanner;
import com.kce.service.LibraryService;

public class LibraryApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LibraryService service = new LibraryService();

        while (true) {
            System.out.println("1. Add Book");
            System.out.println("2. Register Member");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Book ID: ");
                    String bid = sc.nextLine();
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    System.out.print("Copies: ");
                    int copies = sc.nextInt();
                    service.addBook(bid, title, author, copies);
                    break;

                case 2:
                    System.out.print("Member ID: ");
                    String mid = sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    service.registerMember(mid, name);
                    break;

                case 3:
                    System.out.print("Member ID: ");
                    mid = sc.nextLine();
                    System.out.print("Book ID: ");
                    bid = sc.nextLine();
                    service.borrowBook(mid, bid);
                    break;

                case 4:
                    System.out.print("Member ID: ");
                    mid = sc.nextLine();
                    System.out.print("Book ID: ");
                    bid = sc.nextLine();
                    service.returnBook(mid, bid);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
            }
        }
    }
}