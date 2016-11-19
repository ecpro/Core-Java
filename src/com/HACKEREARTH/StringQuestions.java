package com.HACKEREARTH;

import java.util.Arrays;

public class StringQuestions {
	
	public static char [] URLlify(String str, String input){
		char [] charArray = new char[str.length() + 20];
		for(int i = 0; i < str.length(); i++){
			charArray[i] = str.charAt(i);
		}
		
		for(int i = 0; i < str.length(); ) {
			if(charArray[i] == ' ') {
				shift(charArray, i+1, str.length() - 1, input.length()-1);
				push(charArray, i, str);
				i = i + str.length() + 1;
			}
			else {
				i++;
			}
		}
		
		return charArray;
	}

	private static void push(char[] charArray, int start, String str) {
		for(int i = start,j=0; i < str.length(); i++,j++) {
			charArray[i] = str.charAt(j);
		}
	}

	private static void shift(char[] charArray, int sIndex, int eIndex, int shiftVal) {
		for(int i = eIndex; i >= sIndex; i--) {
			charArray[i + shiftVal] = charArray[i];	
		}
	}

	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(StringQuestions.URLlify("Mr John Smith", "%20")));
	}

}
