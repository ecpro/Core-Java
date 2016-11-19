package com.HACKEREARTH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromeCheck {

	public static void main(String[] args) throws IOException {

		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		String flag = "YES";
		int start = 0, end = input.length() - 1;
		while(start < end) {
			if(input.charAt(start) != input.charAt(end)) {
				flag = "NO";
				break;
			}
			start++ ; end--;
		}
		System.out.println(flag);
		
	}

}
