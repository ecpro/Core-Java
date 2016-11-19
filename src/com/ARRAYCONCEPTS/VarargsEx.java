package com.ARRAYCONCEPTS;

import java.util.Arrays;

public class VarargsEx {

	public static void print(Object [] input) {
		System.out.println("directly printing object");
		System.out.println(input.toString());
		
		System.out.println("using Arrays.toString");
		System.out.println(Arrays.toString(input));
		
		for(Object obj : input) {
			System.out.println(obj);
		}
	}
	
	public static void main(String[] args) {
		
		print(new Object [] {"one", "two", "three"});
		print(new Object [] { "one", new Integer(3), "two"});
		
		
	}

}
