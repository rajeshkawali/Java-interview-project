package com.rajeshkawali.concepts.newfeature.repeatable;




/**
 * @author Rajesh_Kawali
 *
 */
@Author(firstname = "Rajesh", lastname = "Kawali")
@Author(firstname = "Keshav", lastname = "Koli")
@Author(firstname = "Kiran", lastname = "Kamble")
/*
we have applied the Author annotation thrice to the Repeatable class, specifying the firstname and lastname element each time. 
The Author annotations are repeated, and they will be stored in the Authors container annotation. 
*/
class Repeatable {
	/*
	To use a repeating annotation, you can apply it multiple times to a 
	single element or to multiple elements using the same syntax as any other annotation.
	*/
}

public class RepeatableExample {
	public static void main(String[] args) {
		Author[] authors = Repeatable.class.getAnnotationsByType(Author.class);
		for (Author author : authors) {
			System.out.println("Name : " + author.firstname() + " " + author.lastname());
		}
	}
}
