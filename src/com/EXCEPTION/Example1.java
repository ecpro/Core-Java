package com.EXCEPTION;

public class Example1 {
	
	public void throwException(String message) throws MyException {

		if(message != null) throw new MyException(message);
		else throw new MyException();
	}

	public static void main(String[] args) {

		new LoggingException();
		
		Example1 ex = new Example1();
		
		try {
			ex.throwException(null);
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}

	}

}
