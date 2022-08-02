package bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2231_Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		int index = 0;
		
		for(int i=1; i<n; i++) {
			int size = ((i+"").length());
			int total = i;
			int x = i;
			while(size-- > 0) {
				total += x%10;
				x /= 10;
			}
			if(total == n) {
				index = i;
				break;
			}
		}
		
		System.out.println(index);
		
	}
}
