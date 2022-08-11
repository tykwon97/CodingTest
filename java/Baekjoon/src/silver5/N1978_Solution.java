package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1978_Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int num = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int[] arr = new int[num];
		int maxValue = Integer.MIN_VALUE;
		for (int i = 0; i < num; i++) {
			int x = Integer.parseInt(st.nextToken());
			arr[i] = x;
			if(maxValue < x)
				maxValue = x;
		}
		
		boolean[] prime = new boolean[maxValue+1];
		prime[0] = true;
		prime[1] = true;
		for (int i = 2; i <= maxValue; i++) {
			if(prime[i] == false) {
				int index = i+i;
				while(index <= maxValue) {
					prime[index] = true;
					index += i;
				}
			}
		}
		
		int count = 0;
		for (int i = 0; i < num; i++) {
			if(prime[arr[i]] == false)
				count++;
		}
		
		
		System.out.println(count);
	}
}
