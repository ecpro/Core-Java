package com.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionUses {
	
	private int x;
	private int y;
	public int result;
	
	public ReflectionUses(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	private int sum() {
		return x + y;
	}
	
	public int sum1() {
		return sum();
	}
	
	public void add(int x, int y) {
		System.out.println("Sum = " + x + y);
	}
	
	
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		
		Class<ReflectionUses> c = ReflectionUses.class;
		
		Method[] methods = c.getMethods();
		
		System.out.println("...Printing Methods...");
		for(Method m : methods) {
			System.out.println(m);
		}
		
		
		@SuppressWarnings("unchecked")
		Constructor<ReflectionUses>[] constructors = (Constructor<ReflectionUses>[]) c.getConstructors();
		
		System.out.println("...Printing Constructors...");
		for(Constructor<ReflectionUses> cons : constructors) {
			System.out.println(cons);
		}
		
		Method declaredMethod = c.getDeclaredMethod("add", Integer.class, Integer.class);
		declaredMethod.invoke(c.newInstance(), 2,3);
		
	}

}
