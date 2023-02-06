package com.rajeshkawali.concepts.general;
public class StringClass {

	public static void main(String[] args) {

		String s1 = "java";
		String s2 = "java";
		String s3 = new String("java");
		StringBuilder s4 = new StringBuilder("java");
		StringBuffer s5 = new StringBuffer("java");
		
		System.out.println("------------------------------------------1");
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
		System.out.println("------------------------------------------2");
		System.out.println(s1==s3);
		System.out.println(s1.equals(s3));
		System.out.println("------------------------------------------3");
		//System.out.println(s3==s4); //Incompatible operand types String and StringBuilder
		System.out.println(s1.equals(s4));
		System.out.println(s3.equals(s4));
		System.out.println("------------------------------------------4");
		//System.out.println(s4==s5); //Incompatible operand types StringBuilder and StringBuffer
		System.out.println(s1.equals(s4));
		System.out.println(s3.equals(s4));
		System.out.println(s4.equals(s5));
		System.out.println(s1.equals(s5));
		System.out.println(s3.equals(s5));
		System.out.println("------------------------------------------5");
		String s6 = "javajava";
		String s7 = s1+s2;
		String s8 = s1+"java";
		System.out.println(s6==s7);
		System.out.println(s6.equals(s7));
		System.out.println(s6==s8);
		System.out.println(s6.equals(s8));
		System.out.println("------------------------------------------6");
		s1.concat("java");
		s4.append("java");
		s5.append("java");
		System.out.println(s1);
		System.out.println(s4);
		System.out.println(s5);
		System.out.println("------------------------------------------7");
		
		
		System.out.println("------------------------------------------");
		
		
		System.out.println("------------------------------------------");
	}

}