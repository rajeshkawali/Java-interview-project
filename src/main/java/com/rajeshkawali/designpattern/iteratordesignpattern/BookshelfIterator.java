package com.rajeshkawali.designpattern.iteratordesignpattern;

import java.util.List;

// Concrete iterator implementation
public class BookshelfIterator implements BookIterator {
    private List<Book> books;
    private int currentPosition;

    public BookshelfIterator(List<Book> books) {
        this.books = books;
        this.currentPosition = 0;
    }

    @Override
    public boolean hasNext() {
        return currentPosition < books.size();
    }

    @Override
    public Book next() {
        if (!hasNext()) {
            return null;
        }

        Book book = books.get(currentPosition);
        currentPosition++;
        return book;
    }
}