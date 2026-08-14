package com.rajeshkawali.concepts.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsWildcard {

	//List<? super BullDog> list :--> Here we are restricting any value passed to ? (wildcard should be a super class of BullDog class)
	//List<? extends BullDog> list :--> Here we are restricting any value passed to ? (wildcard should be a child class of BullDog class)
	
	public static void addUpperBound(List<? extends BullDog> dogList) {
		// We can add same class or subclass of ? (Wildcard) because is-a relationship
		System.out.println("Dog Added - addUpperBound");
	}
	
	public static void addLowerBound(List<? super BullDog> dogList) {
		// We can add same class or subclass of ? (Wildcard) because is-a relationship
		System.out.println("Dog Added - addLowerBound");
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<Animal> animalList = new ArrayList<Animal>();
		List<Cat> catList = new ArrayList<Cat>();
		List<BullDog> bullDogList = new ArrayList<BullDog>();
		List<Dog> dogList = new ArrayList<Dog>();
		List<GermanShepherd> germanShepherdList = new ArrayList<GermanShepherd>();
		List<BullDogChild> bullDogChildList = new ArrayList<BullDogChild>();

		/* Animal class is super class of Dog class and Dog class is super class of
		 BullDog class so it's allowed */
		addLowerBound(animalList);
		/* Animal class is super class of Dog class and Dog class is super class of
		 BullDog class so it's not allowed */
		//addUpperBound(animalList);// compile time error

		/* It's allowed to add Dog list because Dog class is super class of BullDog class */
		addLowerBound(dogList);
		/* It's not allowed to add Dog list because Dog class is super class of BullDog class */
		//addUpperBound(dogList);// compile time error
		

		// It's allowed to add BullDog list to BullDog class
		addUpperBound(bullDogList);
		addLowerBound(bullDogList);

		/* We can add BullDogChild class list to BullDog class because BullDogChild is child class of BullDog.
		Only classes which are sub class to BullDog class is allowed */
		addUpperBound(bullDogChildList);
		/* We can not add BullDogChild class list to BullDog class because BullDogChild is not super class of BullDog.
		Only classes which are super class to BullDog class is allowed */
		//addLowerBound(bullDogChildList);// compile time error

		// not allowed
		//addUpperBound(germanShepherdList);// compile time error
		//addLowerBound(germanShepherdList);// compile time error

		// not allowed
		//addUpperBound(catList);// compile time error
		//addLowerBound(catList);// compile time error
	}
}

class Animal {
}

class Cat extends Animal {
}

class Dog extends Animal {
}

class GermanShepherd extends Dog {
}

class BullDog extends Dog {
}

class BullDogChild extends BullDog {
}

/*
Question mark (?) is the wildcard in generics and represent an unknown type.
The wildcard can be used as the type of a parameter, field, or local variable
and sometimes as a return type. We can’t use wildcards while invoking a
generic method or instantiating a generic class.

*/


/*
Generics Wildcards in Java
--------------------------

1. <?>  (Unbounded Wildcard)
- Accepts any type.
- Used when the type is unknown.
- Can read elements.
- Cannot add elements (except null).

Example:
List<?> list;

----------------------------------------------------

2. <? extends T>  (Upper Bound)
- Accepts T and its subclasses.
- Used when you only want to READ data.
- Cannot add elements.

Example:
List<? extends Number>

Accepts:
List<Integer>
List<Double>
List<Float>

Rule:
Read ✅
Add ❌

----------------------------------------------------

3. <? super T>  (Lower Bound)
- Accepts T and its superclasses.
- Used when you want to ADD data.
- Safe to add objects of type T.

Example:
List<? super Integer>

Accepts:
List<Integer>
List<Number>
List<Object>

Rule:
Add ✅
Read as Object only

----------------------------------------------------

PECS Rule (Most Asked Interview Question)

P -> Producer -> Extends
E
C -> Consumer -> Super
S

Producer (Read)  -> <? extends T>
Consumer (Write) -> <? super T>

----------------------------------------------------

Easy Trick

<?>                 -> Any Type
<? extends Number>  -> Number and Child Classes
<? super Integer>   -> Integer and Parent Classes
*/