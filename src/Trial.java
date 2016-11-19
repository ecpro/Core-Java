import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Trial {
	
	
	public static String [] repeatChar(String [] input) {
		String [] output = new String [input.length];
		int x = 0;
		for(String curr : input) {
			
			for(int i = 0; i < curr.length() - 1; i++) {
				if(curr.charAt(i) == curr.charAt(i+1)) {
					output[x++] = new String(curr);
					break;
				}
			}
		}
		return Arrays.copyOfRange(output, 0, x);
	}
	
	public static void main(String[] args) throws IOException {
		
		//System.out.println(Arrays.toString(repeatChar(new String [] {"hello", "summer", "elephant", "gannd", "bakchodi"})));
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			int x = Integer.parseInt(br.readLine());
			if(x == 42) break;
			System.out.println(x);
		}
			
		
	}
}
