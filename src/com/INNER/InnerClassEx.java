package com.INNER;

public class InnerClassEx {
	
	private int x = 4;
	
	private void privatePrint() {
		System.out.println("its in private print method of class InnerClassEx");
	}
	
	public void publicPrint() {
		System.out.println("1st a public print method of class InnerClassEx");
	}
	
	
	
	public class Inner {
		
		public void outer() {
			System.out.println(x);
			privatePrint();
			InnerClassEx.this.privatePrint();
		}
	}
	
	
	public Inner getInner() {
		return new Inner();
	}
	
	public static void main(String[] args) {
		
		// 1. Tt's not possible to create the instance of non-static inner class if 
		// we don't have the instance of outer class 
		// 2. To get access to to outer class field in the non-static inner class 
		// we need to use OuterClassName.this
		// 3. We can also create inner class object using .new operation on outerclass
		// 4. non-static inner class have access to all the fields of outer class even the private ones
		
		InnerClassEx x = new InnerClassEx();
		InnerClassEx.Inner in = x.new Inner();
		in.outer();

	}

}
