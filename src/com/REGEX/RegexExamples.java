package com.REGEX;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExamples {
	
	private String text;

	public RegexExamples(String text) {
		this.text = text;
	}
	
	protected List<String> getTokens(String pattern)
	{
		ArrayList<String> tokens = new ArrayList<String>();
		Pattern tokSplitter = Pattern.compile(pattern);
		Matcher m = tokSplitter.matcher(text);
		
		while (m.find()) {
			tokens.add(m.group());
		}
		
		return tokens;
	}
	
	public int getWords() {
		return getTokens("[A-Z,a-z]+").size();
	}

	public int getSentences() {
		return getTokens("[^.!?]+").size();
	}
	
	public int countSyllables(String word) {
		String text = word.toLowerCase();
		if(text.endsWith("e")) text = text.substring(0, text.length()-1);
		HashSet<Character> vowelSet = new HashSet<>(6);
		vowelSet.add('a');
		vowelSet.add('e');
		vowelSet.add('i');
		vowelSet.add('o');
		vowelSet.add('u');
		vowelSet.add('y');
		int count = 0;
		for(int i = 0;i < text.length(); i++) {
			int flag = 0;
			while(i < text.length() && vowelSet.contains(text.charAt(i))) {
				i++;
				flag = 1;
			}
			if(flag == 1) count++;			
		}
		
		if(count == 0 & word.endsWith("e")) return 1;

		return count;
	}
	
	public static void main(String[] args) {
		
		//String text ="Splitting a string, it's as easy as 1 2 33! Right?";
		//String text = "toga";
		//System.out.println(text + " matches " + text.matches("[aeiouy]+"));
		//String text = " this is a test.1134 .34g2g,@asaha!!!.235.2322";
		//String text = " Wow!!this is a test. Yes this is a test? Ofcourse this is";
		//Pattern pattern = Pattern.compile("[A-Za-z0-9 ]+");
		//Pattern pattern = Pattern.compile("[^!.?@']+");
		//Pattern pattern = Pattern.compile("[A-Za-z ]+|[0-9 ]+");
		//Pattern pattern = Pattern.compile("[^.!?]+");
		Pattern pattern = Pattern.compile("[1-3]");

		Matcher matcher = pattern.matcher("123 333 112233");

		
		while(matcher.find()) {
			System.out.format("%s ", matcher.group());
		}
		
	
	}

}
