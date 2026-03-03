package com.kce.service;

import com.kce.dao.LibraryDAO;
import com.kce.bean.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class LibraryService {

    private LibraryDAO dao = new LibraryDAO();

    public void addBook(String id, String title, String author, int copies) {

        if (dao.getBook(id) != null) {
            System.out.println("Book ID already exists!");
            return;
        }

        Book book = new Book();
        book.setBookId(id);
        book.setTitle(title);
        book.setAuthor(author);
        book.setTotalCopies(copies);
        book.setAvailableCopies(copies);

        dao.addBook(book);
        System.out.println("Book added successfully!");
    }

    public void registerMember(String id, String name) {

        if (dao.getMember(id) != null) {
            System.out.println("Member ID already exists!");
            return;
        }

        Member member = new Member();
        member.setMemberId(id);
        member.setName(name);
        member.setBorrowedBooks(new ArrayList<>());
        member.setTotalBorrowed(0);

        dao.addMember(member);
        System.out.println("Member registered successfully!");
    }

    public void borrowBook(String memberId, String bookId) {

        Member member = dao.getMember(memberId);
        Book book = dao.getBook(bookId);

        if (member == null) {
            System.out.println("Member not found!");
            return;
        }

        if (book == null) {
            System.out.println("Book not found!");
            return;
        }

        if (member.getBorrowedBooks().size() >= 3) {
            System.out.println("Maximum 3 books allowed!");
            return;
        }

        if (book.getAvailableCopies() <= 0) {
            System.out.println("No copies available!");
            return;
        }

        for (BorrowRecord br : member.getBorrowedBooks()) {
            if (br.getBookId().equals(bookId)) {
                System.out.println("Cannot borrow same book twice!");
                return;
            }
        }

        BorrowRecord record = new BorrowRecord();
        record.setBookId(bookId);
        record.setBorrowDate(LocalDate.now());

        member.getBorrowedBooks().add(record);
        book.setAvailableCopies(book.getAvailableCopies() - 1);
        member.setTotalBorrowed(member.getTotalBorrowed() + 1);

        System.out.println("Book borrowed successfully!");
    }

    public void returnBook(String memberId, String bookId) {

        Member member = dao.getMember(memberId);
        Book book = dao.getBook(bookId);

        if (member == null || book == null) {
            System.out.println("Member or Book not found!");
            return;
        }

        Iterator<BorrowRecord> iterator = member.getBorrowedBooks().iterator();

        while (iterator.hasNext()) {
            BorrowRecord br = iterator.next();

            if (br.getBookId().equals(bookId)) {

                LocalDate dueDate = br.getBorrowDate().plusDays(14);
                long overdueDays = ChronoUnit.DAYS.between(dueDate, LocalDate.now());

                if (overdueDays > 0) {
                    System.out.println("Fine: Rs." + overdueDays * 2);
                } else {
                    System.out.println("Returned on time. No fine.");
                }

                book.setAvailableCopies(book.getAvailableCopies() + 1);
                iterator.remove();
                return;
            }
        }

        System.out.println("This member didn't borrow this book.");
    }
}