package com.SORTING;

public class Insertion {
	
	public static void sort(int [] a) {
		
		for(int i = 0; i < a.length; i++) {
			int min = i;
			for(int j = i + 1; j < a.length; j++) {
				if(a[j] < a[min]) {
					min = j;
				}
			}
			swap(a, min, i);
		}
	}

	private static void swap(int[] a, int min, int i) {
		int temp = a[min];
		a[min] = a[i];
		a[i] = temp;
	}

	public static void main(String[] args) {
		
		int [] a  = {2,1,3,3,6,8};
		Insertion.sort(a);
		
		for(int i : a) {
			System.out.println(i);
		}
	}

}
