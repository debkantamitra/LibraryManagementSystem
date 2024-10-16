package org;

import org.learnerManagementSystem.bookManagement.Book;
import org.learnerManagementSystem.bookManagement.BookManagement;
import org.learnerManagementSystem.inventoryManagement.InventoryManagement;
import org.learnerManagementSystem.patronManagement.Patron;
import org.learnerManagementSystem.patronManagement.PatronManagement;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        BookManagement bookManagement = new BookManagement();
        PatronManagement patronManagement = new PatronManagement();
        InventoryManagement inventoryManagement = new InventoryManagement(bookManagement,
                patronManagement);

        Book book1 = new Book("Treasure Island", "Robert Louis Stevenson",
                123, 2020);

        bookManagement.addBook(book1);

        for(Book book: bookManagement.getBooks()) {
            System.out.println(book.toString());
        }

        Patron patron1 = new Patron("Debkanta");
        patronManagement.addPatron(patron1);

        inventoryManagement.checkoutItem(patron1.getPatronId(), book1.getBookId());
        inventoryManagement.returnItem(patron1.getPatronId(), book1.getBookId());

        for(Book book: inventoryManagement.getBorrowedBooks()) {
            System.out.println(book.toString());
        }
    }
}