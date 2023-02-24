package com.rajeshkawali.designpattern.iteratordesignpattern;
// Aggregate interface defining the collection
public interface BookCollection {
	public void addBook(Book book);
    public BookIterator createIterator();
}