package bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N2309_Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int total = 0;
		int[] nanjaenge = new int [9];
		
		for(int i=0; i<9; i++) {
			int x = Integer.parseInt(in.readLine());
			total += x;
			nanjaenge[i] = x;
		}
		
		Arrays.sort(nanjaenge);
		
		total -= 100;
		
		for(int i=0; i<8; i++) {
			for(int j=i+1; j<9; j++) {
				if(total == (nanjaenge[i] + nanjaenge[j])) {
					for(int k=0; k<9; k++) {
						if(k==i || k==j)
							continue;
						System.out.println(nanjaenge[k]);
					}
					return;
				}
			}
		}
		
		
	}
}
