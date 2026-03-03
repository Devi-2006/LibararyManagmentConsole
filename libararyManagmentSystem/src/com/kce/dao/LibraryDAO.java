package com.kce.dao;

import java.util.*;

import com.kce.bean.Book;
import com.kce.bean.Member;

public class LibraryDAO {

    private Map<String, Book> books = new HashMap<>();
    private Map<String, Member> members = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getBookId(), book);
    }

    public Book getBook(String bookId) {
        return books.get(bookId);
    }

    public Collection<Book> getAllBooks() {
        return books.values();
    }


    public void addMember(Member member) {
        members.put(member.getMemberId(), member);
    }

    public Member getMember(String memberId) {
        return members.get(memberId);
    }

    public Collection<Member> getAllMembers() {
        return members.values();
    }
}