package org.learnerManagementSystem.bookManagement;

import org.learnerManagementSystem.inventoryManagement.InventoryManagement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookManagement {
    Logger logger = LoggerFactory.getLogger(BookManagement.class);

    private List<Book> books;

    public BookManagement() {
        this.books = new ArrayList<>();
    }

    public BookManagement(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return this.books;
    }

    public void addBook(Book book) {
        books.add(book);

        logger.info("Added book successfully!");
    }

    public void removeBook(Book book) {
        books.remove(book);

        logger.info("Removed book successfully!");
    }

    public List<Book> searchByAuthorName(String author) {
        return this.books
                .stream()
                .filter(item -> item.getAuthor().contains(author))
                .collect(Collectors.toList());
    }

    public List<Book> searchByTitle(String title) {
        return this.books
                .stream()
                .filter(item -> item.getTitle().contains(title))
                .collect(Collectors.toList());
    }

    public List<Book> searchByIsbn(long isbn) {
        return this.books
                .stream()
                .filter(item -> Long.toString(item.getIsbn()).contains(Long.toString(isbn)))
                .collect(Collectors.toList());
    }

    public Book searchByBookId(long bookId) {
        return this.books
                .stream()
                .filter(item -> item.getBookId() == bookId)
                .collect(Collectors.toList()).get(0);
    }
}
