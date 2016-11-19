package com.INNER;

public class StaticInnerClassEx {
	
	private int x = 4;
	
	private static class Innerx {

		public void print() {
			System.out.println("inside static inner");
		}
	}

	public static void main(String[] args) {
		StaticInnerClassEx.Innerx x = new Innerx();
		x.print();
	}

}
