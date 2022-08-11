package bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N3040_Solution {
	public static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		arr = new int[9];
		int total = 0;
		for(int i=0; i<9; i++) {
			arr[i] = Integer.parseInt(in.readLine());
			total += arr[i];
		}
		
		total -= 100;
		comb(0,total,0);

		
	}

	private static void comb(int cnt, int total, int flag) {
		if(total<0)
			return;
		if(cnt == 2) {
			if(total == 0) {
				for (int i = 0; i < arr.length; i++) {
					if((flag & (1<<i)) == 0) {
						System.out.println(arr[i]);
						
					}
				}
				System.exit(0);
			}
			return;
		}
		
		
		for (int i = 0; i < arr.length; i++) {
			if((flag & (1<<i)) != 0)
				continue;
			comb(cnt+1,total-arr[i], flag|(1<<i));
		}
	}
}
