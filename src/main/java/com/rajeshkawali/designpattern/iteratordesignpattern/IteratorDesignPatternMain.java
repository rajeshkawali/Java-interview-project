package com.rajeshkawali.designpattern.iteratordesignpattern;

public class IteratorDesignPatternMain {

	/*
	The Iterator Pattern is a behavioral design pattern that provides a way to access 
	the elements of an aggregate object (such as a collection) sequentially without exposing 
	the underlying implementation. In this pattern, an iterator object is used to 
	traverse the collection and access its elements.
	*/
	public static void main(String[] args) {
		BookCollection bookshelf = new Bookshelf();

		bookshelf.addBook(new Book("The Karma", "Sadguru"));
		bookshelf.addBook(new Book("Java", "James Gosling"));
		bookshelf.addBook(new Book("Geeta", "Krishna"));

		BookIterator iterator = bookshelf.createIterator();
		while (iterator.hasNext()) {
			Book book = iterator.next();
			System.out.println(book.getTitle() + " by " + book.getAuthor());
		}
	}
}
/*
This example creates a Bookshelf class that implements the BookCollection interface. 
The Bookshelf class holds a list of Book objects and provides methods to add and remove books. 
It also implements the createIterator() method to return a BookIterator object.

The BookIterator interface defines the iteration protocol with hasNext() and next() methods. 
The BookshelfIterator class is a concrete implementation of BookIterator. 
It takes a list of books as a parameter and keeps track of the current position in the list.

The example usage creates a Bookshelf object and adds three Book objects to it. 
It then gets a BookIterator object from the Bookshelf and iterates over the list of books, 
printing out each book's title and author.
*/

/*
Here are the general steps to implement the Iterator design pattern in Java:-->

Create an interface to define the iteration protocol, typically with two methods: hasNext() to check if there are more items to iterate, and next() to get the next item.
Create a class that implements the iterator interface and provides the iteration logic for a specific collection. This class should keep track of the current position within the collection, and implement the two methods from the iterator interface.
Create a class to represent the collection you want to iterate over, and provide a method to create an instance of the iterator that knows how to iterate over the collection. This method should return an instance of the iterator interface.
Use the collection and iterator in your code, typically with a loop that checks if there are more items using hasNext() and retrieves the next item using next().

*/