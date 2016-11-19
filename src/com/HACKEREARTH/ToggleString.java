package com.HACKEREARTH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ToggleString {

	public static void main(String[] args) throws IOException {
		
	BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		
		char [] input = br.readLine().toCharArray();
		for(int i = 0; i < input.length; i++) {
			char c = input[i];
			if(c >= 65 && c <= 90) {
				int diff = 25 - (('Z' - c) % 26);
				c = (char) (97 + diff);
			}
			else if(c >= 97 && c <= 122) {
				int diff = 25 - (('z' -c) %26);
				c = (char) (65 + diff);
			}
			input[i] = c;
		}
		System.out.println(new String(input));
	}

}
