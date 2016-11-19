package com.SORTING;

import java.util.Arrays;

public class Sort {
	
	public static boolean less(Comparable a, Comparable b)  {
		
		return a.compareTo(b) < 0;
	}
	
	public static void exchange(Comparable [] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
		
	}
	
	public static void InsertionSort(Comparable [] a) {
		
		for(int i = 1; i < a.length; i++) {
			for(int k = i; k >0; k--) {
				if(!less(a[k], a[k-1])) break;
				exchange(a, k, k-1);
			}
		}
	}
	
	public static void MergeSort(Comparable [] a) {
		Comparable [] aux = new Comparable [a.length];
		MergeSort(a, aux, 0, a.length-1);
		
	}
	
	public static void MergeSort(Comparable [] a, Comparable [] aux, int lo, int hi) {
		
		if(lo >= hi) return;
		int mid = lo + (hi - lo) / 2;
		MergeSort(a, aux, lo, mid);
		MergeSort(a, aux, mid+1, hi);
		merge(a,aux,lo,mid,hi);
	}
	
	public static void merge(Comparable []a, Comparable [] aux, int lo, int mid, int hi) {
		
		for(int k = 0; k < a.length; k++) {
			aux[k] = a[k];
		}
		
		
		int i = lo, j = mid+1;
		for(int k = lo; k<= hi; k++) {
			
			if(i > mid) a[k] = aux[j++];
			else if(j > hi) a[k] = aux[i++];
			else if(less(aux[i],aux[j])) a[k] = aux[i++];
			else a[k] = aux[j++];
		}
	}
	
	public static void main(String[] args) {
		Integer [] input = {10, 7, 6, 4, 0, 1};
		//InsertionSort(input);
		MergeSort(input);
		System.out.println(Arrays.toString(input));
	}
	
	
}
