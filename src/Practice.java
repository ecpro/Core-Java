import java.util.Arrays;
import java.util.HashSet;

public class Practice {
	
	public static String canBeSortedByReverse(int [] a) {
		int [] b= Arrays.copyOf(a, a.length);
		Arrays.sort(b);
		int swapCount = 0, n = a.length;
		for(int i = 0; i < n; i++){
			if(a[i] == b[i]) continue;
			else if(a[i] == b[n-1-i]) {
				swapCount++;
				continue;
			}
			else {
				return "Not possible";
			}
		}
		
		System.out.println("# of reverses required " + swapCount);
		
		return "Possible";
		
	}
	
	
	public static int nonReducibleFractions(int N) {
		int count = 0;
		
		for(int num = 1; num < N; num++) {
			for(int den = 2; den <=N; den++) {
				if(num < den && gcd(den,num) == 1) 
					count++;
			}
		}
		
		return count;
	}
	
	public static int gcd(int i, int j) {
		if(i < j) {
			int x = i;
			i = j;
			j = x;
		}
		
		if(j == 0) return i;
		else {
			return gcd(j, i % j);
		}
	}
	
	public static int findMaxSubArraySum(int [] input) {
		int curr = 0, max = Integer.MIN_VALUE;
		boolean hasAllNeg = true;
		for(int i = 0; i < input.length; i++) {
			if(input[i] >= 0) hasAllNeg = false;
			
			if(hasAllNeg) {
				if(input[i] > max) max = input[i];
			}
			else {
				curr += input[i];
				if(curr < 0) curr = 0;
				if(max < curr) max = curr;
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		//int [] array = {1,6,3,4,5,2,7};
		//int [] array = {2,86,5,13,10,7,24,4,90};
		//System.out.println(Practice.canBeSortedByReverse(array));
		//System.out.println(nonReducibleFractions(4));
		
		int [] input = {-2,-3,-9};
		System.out.println(findMaxSubArraySum(input));
		
		
	}
}
