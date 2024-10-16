package org.learnerManagementSystem.bookManagement;

public class Book {

    static long bookCount = 0;
    final private long bookId;
    final private String title;
    final private String author;
    final private long isbn;
    final private long publishedYear;
    private int numberOfTotalBooksAvailable;

    public Book(String title, String author, long isbn, long publishedYear) {
        Book.bookCount += 1;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishedYear = publishedYear;
        this.numberOfTotalBooksAvailable += 1;
        this.bookId = Book.bookCount;
    }

    @Override
    public String toString() {
        return "Book{title='" + title + "', author='" + author + "'}";
    }

    public String getTitle() {
        return this.title;
    }

    public long getBookId() {
        return this.bookId;
    }

    public String getAuthor() {
        return this.author;
    }

    public long getIsbn() {
        return this.isbn;
    }

    public long getPublishedYear() {
        return this.publishedYear;
    }

    public long getNumberOfTotalAvailableQuantity() {
        return this.numberOfTotalBooksAvailable;
    }

    public void increaseAvailableQuantityByOne() {
        this.numberOfTotalBooksAvailable += 1;
    }

    public void decreaseAvailableQuantityByOne() {
        this.numberOfTotalBooksAvailable -= 1;
    }
}
