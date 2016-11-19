import java.util.*;
public class FreqInt {

	public static void main(String[] args) {
	
		int [] x = {2,1,4,1,5};
		int [] y = {2,1,3,5};
		
		Set<Integer> xH = new HashSet<>();
		Set<Integer> yH = new HashSet<>();
		
		for(int i = 0; i < x.length; i++) {
			xH.add(x[i]);
		}
		for(int i = 0; i < y.length; i++) {
			yH.add(y[i]);
		}
		
		for(Integer i : xH) {
			if(yH.contains(i)) System.out.println(i);
		}
	}
}
