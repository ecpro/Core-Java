package com.ARRAYCONCEPTS;

import java.util.Arrays;

public class OptionalTrailingArg {
	
	public  static void f(int required, Object...trailing) {
		System.out.println("required : " + required);
		System.out.println(Arrays.toString(trailing));
	}
	
	public static void g(String [] s) {
		System.out.println(Arrays.toString(s));
	}

	
	public static void main(String[] args) {
		
		f(4, "one", "two", new Integer(34));
		
		f(4, new Object[] {"thre", "four", 3});
		
		Integer [] x = new Integer[3];
		
		x[0] = 4;
		x[1] = 9;
		x[2] = 1;
		
		f(4, x);
		
		g(new String [] {"sda", "aab"});
		
	}
	
	
	


}
