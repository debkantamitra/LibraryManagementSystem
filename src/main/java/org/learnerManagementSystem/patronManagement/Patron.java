package org.learnerManagementSystem.patronManagement;

import org.learnerManagementSystem.bookManagement.Book;

import java.util.ArrayList;
import java.util.List;

public class Patron {
    private static long patronCount = 0;
    private String patronName;
    final private long patronId;
    private List<Book> borrowedBooks;

    public Patron(String patronName) {
        Patron.patronCount += 1;
        this.patronId = Patron.patronCount;
        this.patronName = patronName;
        this.borrowedBooks = new ArrayList<Book>();
    }

    public long getPatronId() {
        return this.patronId;
    }

    public String getPatronName() {
        return this.patronName;
    }

    public void setPatronName(String patronName) {
        this.patronName = patronName;
    }

    public List<Book> getBorrowedBooks() {
        return this.borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> listOfBooks) {
        this.borrowedBooks = listOfBooks;
    }
}
