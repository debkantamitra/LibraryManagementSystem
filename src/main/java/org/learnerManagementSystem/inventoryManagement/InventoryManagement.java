package org.learnerManagementSystem.inventoryManagement;

import org.learnerManagementSystem.bookManagement.Book;
import org.learnerManagementSystem.bookManagement.BookManagement;
import org.learnerManagementSystem.lendingProcess.LendingProcess;
import org.learnerManagementSystem.patronManagement.Patron;
import org.learnerManagementSystem.patronManagement.PatronManagement;

import java.util.ArrayList;
import java.util.List;

public class InventoryManagement implements LendingProcess {
    private BookManagement bookManagement;
    private PatronManagement patronManagement;

    public InventoryManagement(BookManagement bookManagement,
                               PatronManagement patronManagement) {
        this.bookManagement = bookManagement;
        this.patronManagement = patronManagement;
    }

    @Override
    public void checkoutItem(long bookId, long patronId) {
        Book book = bookManagement.searchByBookId(bookId);
        Patron patron = patronManagement.searchByPatronId(patronId);

        patron.getBorrowedBooks().add(book);
        book.decreaseAvailableQuantityByOne();
    }

    @Override
    public void returnItem(long bookId, long patronId) {
        Book book = bookManagement.searchByBookId(bookId);
        Patron patron = patronManagement.searchByPatronId(patronId);

        patron.getBorrowedBooks().remove(book);
        book.increaseAvailableQuantityByOne();
    }

    public List<Book> getBorrowedBooks() {
        List<Patron> patronList = patronManagement.getPatronList();

        List<Book> borrowedBooks = new ArrayList<>();

        for(Patron patron: patronList) {
            if(!patron.getBorrowedBooks().isEmpty()) {
                patron.getBorrowedBooks().forEach(book -> borrowedBooks.add(book));
            }
        }

        return borrowedBooks;
    }

    public List<Book> getAvailableBooks() {
        List<Book> bookList = bookManagement.getBooks();
        List<Book> availableBooks = new ArrayList<>();

        for(Book book: bookList) {
            if(book.getNumberOfTotalAvailableQuantity() > 0) {
               availableBooks.add(book);
            }
        }

        return availableBooks;
    }
}
