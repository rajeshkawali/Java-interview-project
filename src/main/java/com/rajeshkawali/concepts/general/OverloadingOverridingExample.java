package com.rajeshkawali.concepts.general;
/**
 * @author Rajesh_Kawali
 *
 */
class Parent {
	
	public void methodInt(int a) {
        System.out.println("Parent class methodInt with one int argument: "+a);
    }
    /*
    //Duplicate method methodOne(int) in type Parent
    public int methodInt(int a) {
        System.out.println("Parent class methodInt with int argument: "+a);
        return a;
    }
    */
    void methodDouble(double a) {
        System.out.println("Parent class methodDouble with double argument: "+a);
    }
    
    int methodInt(int a, int b) {
        System.out.println("Parent class methodInt with two int argument: "+(a+b));
		return a+b;
    }

    final void methodFinal() {
        System.out.println("Parent class final methodFinal");
    }

    private void methodPrivate() {
        System.out.println("Parent class private methodPrivate");
    }

    static void methodStatic() {
        System.out.println("Parent class static methodStatic");
    }
}

class Child extends Parent {
	
    @Override // If we change public modifier to any other then --> Cannot reduce the visibility of the inherited method from Parent
    public void methodInt(int a) {
        System.out.println("Child class methodInt with int argument");
    }
    
    @Override
    int methodInt(int a, int b) {
        System.out.println("Parent class methodInt with two int argument: "+(a+b));
		return a+b;
    }

    // Cannot override the final method from Parent
    // @Override 
    // void methodFinal() {
    //     System.out.println("Child class methodFinal");
    // }

    /*
	// We can't have child final also because already parent final method inherited into child
	// Cannot override the final method from Parent
	void methodFinal() {
		System.out.println("Child class methodFinal");
	}
    */
    
    // Can't override private method
    // @Override // The method methodPrivate() of type Child must override or implement a supertype method
    // void methodPrivate() {
    //     System.out.println("Child class methodPrivate");
    // }

    // Child can have its own private method but it can't override parent private method
     private void methodPrivate() {
         System.out.println("Child class methodPrivate");
     }

    // Can't override static method --> The method methodStatic() of type Child must override or implement a supertype method
    // @Override 
    // static void methodStatic() {
    //     System.out.println("Child class methodStatic");
    // }

     // Child can have its own Static method but it can't override parent static method
    static void methodStatic() {
        System.out.println("Child class static methodStatic");
    }
}


public class OverloadingOverridingExample {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Parent p = new Parent();
        p.methodInt(5);
        p.methodInt(5,4);
        p.methodDouble(5.0);
        p.methodFinal();
        // Can't call private method from outside the class
        // p.methodPrivate();
        Parent.methodStatic(); //or p.methodStatic();
        System.out.println("-----------------------------------");
        Child c = new Child();
        c.methodInt(3);
        c.methodInt(3,6);
        c.methodDouble(7.0);
        c.methodFinal();
         // Can't call private method from outside the class
         // c.methodPrivate(); // The method methodPrivate() from the type Child is not visible
        Parent.methodStatic(); //or c.methodStatic();
		System.out.println("-----------------------------------");
		Parent pc = new Child();
		pc.methodInt(6);
        pc.methodInt(3,2);
        pc.methodDouble(8.0);
        pc.methodFinal();
        // Can't call private method from outside the class
        // pc.methodPrivate();
        pc.methodStatic();
        Child.methodStatic(); //or pc.methodStatic();
        Parent.methodStatic(); //or pc.methodStatic();
		System.out.println("-----------------------------------");
	}
}
