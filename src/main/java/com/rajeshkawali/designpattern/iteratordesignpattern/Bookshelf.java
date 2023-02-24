package com.rajeshkawali.designpattern.iteratordesignpattern;

import java.util.ArrayList;
import java.util.List;

// Concrete aggregate implementation
public class Bookshelf implements BookCollection {
    private List<Book> books;

    public Bookshelf() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void removeBook(Book book) {
        this.books.remove(book);
    }

    @Override
    public BookIterator createIterator() {
        return new BookshelfIterator(books);
    }
}