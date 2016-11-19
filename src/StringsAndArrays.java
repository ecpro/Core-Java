import java.util.Arrays;

public class StringsAndArrays {
	
	
	public static boolean isUnique(String a) {
		boolean [] flags = new boolean[256];
		
		for(int i = 0; i < a.length(); i++) {
			if(flags[a.charAt(i)]) return false;
			flags[a.charAt(i)] = true;
		}
		
		return true;
	}

	public static void main(String[] args) {
		//System.out.println(isUnique("qwertyasdfghj"));
		//System.out.println(isPermutation1("system", "sysmex"));
		System.out.println(isPermutation2("system", "sysmet"));
	}
	
	public static boolean isPermutation1(String a, String b) {
		
		if(a.length() != b.length()) return false;
		
		char [] x = a.toCharArray();
		char [] y = b.toCharArray();
		Arrays.sort(x);
		Arrays.sort(y);
		
		for(int i = 0; i < a.length(); i++) {
			if(x[i] != y[i]) return false;
		}
		
		return true;
	}
	
	public static boolean isPermutation2(String x , String y) {
		if(x.length() != y .length()) return false;
		boolean [] flag = new boolean[128];
		
		for(int i = 0; i < x.length(); i++) {
			flag[x.charAt(i)] = true;
		}
		
		for(int i = 0; i < y.length(); i++) {
			flag[y.charAt(i)] = false;
		}
		
		for(int i = 0; i < x.length(); i++) {
			if(flag[x.charAt(i)] == true) return false;
		}
		
		return true;
		
	}

}
