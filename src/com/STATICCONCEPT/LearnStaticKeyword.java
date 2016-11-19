package com.STATICCONCEPT;


/**
 * @author eccspro
 *
 * first static variables are instantiated then non static in order
 */

public class LearnStaticKeyword {
	private A a1 = new A(5);
	private static A a2 = new A(1);
	
	public static B b3;
	
	public LearnStaticKeyword() {
		System.out.println("LearnStaticKeyword instantiated");
		b3 = new B(10);
	}
	
	static {
		new B(2);
	}
	
	static {
		new B(3);
	}
	
	
	public static void main(String[] args) {
		new LearnStaticKeyword();
	}
	
	private static B b = new B(4);
	
	private B b2 = new B(6);
	
	public static void prnt() {
		System.out.println("inside prnt");
	}
}

class A {
	public A (int x) {
		System.out.println("initialized A(" + x + ")")	;
	}
}

class B {
	public B (int x) {
		System.out.println("initialized B(" + x + ")")	;
	}
}
