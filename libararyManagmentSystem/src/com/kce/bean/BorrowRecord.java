package com.kce.bean;

import java.time.LocalDate;

public class BorrowRecord {

    private String bookId;
    private LocalDate borrowDate;

    public BorrowRecord() {}

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }
}