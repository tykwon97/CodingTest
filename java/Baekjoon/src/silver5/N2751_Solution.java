package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2751_Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int num = Integer.parseInt(in.readLine());
		

		int[] negativeArr = new int[1_000_001];
		int[] arr = new int[1_000_001];
		for (int i = 0; i < num; i++) {
			int x = Integer.parseInt(in.readLine());
			if(x>=0)
				arr[x]++;
			else {
				int absValue = x*-1;
				negativeArr[absValue]++;
			}
		}
		
		for(int i = 1_000_000; i>=0; i--) {
			if(negativeArr[i] != 0) {
				sb.append(-1*i).append("\n");
			}
		}
		
		for(int i = 0; i<1_000_001; i++) {
			if(arr[i] != 0) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb);
	}
}
