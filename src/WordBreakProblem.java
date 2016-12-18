import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreakProblem {
	
	private static Set<String> DICT = new HashSet<>(Arrays.asList("I", "am", "Rock","so","no","one","can","on"));
	
	
	// wrong solution !!
	/* public static boolean hasValidWords(String a) {
		boolean flag = false;
		int start = 0;
		for(int i = 0; i < a.length(); i++) {
			String temp = a.substring(start, (i+1 - start)+start);
			if(DICT.contains(temp)) {
				flag = true;
				start = i + 1;
			}
			else flag = false;
		}
		
		return flag;
	}
	*/
	
	public static boolean hasValidWords(String a) {
		int n = a.length();
		boolean [] validWords = new boolean[n];
		for(int i = 0; i < n; i++) {
			if(DICT.contains(a.substring(0, i+1))) {
				validWords[i] = true;
			}
			if(i == n-1 && validWords[i] == true) return true;
			
			if(validWords[i]) {
				for(int j = i+1; j < n; j++) {
					if(DICT.contains(a.substring(i+1,j+1))) {
						validWords[j] = true;
					}
					
					if(j == n-1 && validWords[j]) return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(hasValidWords("nooneIRockam"));
	}

}
