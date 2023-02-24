package com.rajeshkawali.designpattern.iteratordesignpattern;

/**
 * 
 * @author Rajesh_Kawali
 *
 */
// Aggregate interface defining the collection
public interface BookCollection {
	public void addBook(Book book);

	public BookIterator createIterator();
}