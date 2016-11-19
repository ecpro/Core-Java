package com.ENUM_USES;

public class Burrito {
	private Spiciness degree;
	
	public Burrito(Spiciness degree) {
		this.degree = degree;
	}
	
	public void describe() {
		
		switch(degree) {
			case NOT : System.out.println("NOT");
				break;
			case HOT : System.out.println("HOT");
			break;
			default : System.out.println("may MEDIUM");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Burrito(Spiciness.NOT).describe();
	}

}
