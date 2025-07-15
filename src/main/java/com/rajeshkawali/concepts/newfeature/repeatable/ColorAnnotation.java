package com.rajeshkawali.concepts.newfeature.repeatable;

/**
 * @author Rajesh_Kawali
 *
 */
@Color(name = "Red")
@Color(name = "Blue")
@Color(name = "Green")
class Shirt {
}

public class ColorAnnotation {
	public static void main(String args[]) {
		// Get all Color annotations on Shirt (including repeated ones)
        Color[] colorArray = Shirt.class.getAnnotationsByType(Color.class);

        for (Color color : colorArray) {
            System.out.println("Shirt color: " + color.name());
        }
	}
}