package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1676_Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(in.readLine());
		
		int count = 0;
		
		for(int i=1; i<=num; i++) {
			int x = i;
			while(x%5 == 0 && x != 0) {
				count ++;
				x=x/5;
				
			}
		}
		
		System.out.println(count);
	}
}
