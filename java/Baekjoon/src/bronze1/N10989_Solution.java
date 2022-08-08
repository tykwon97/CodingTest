package bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N10989_Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[10001];
		
		for (int i = 0; i < n; i++) {
			arr[Integer.parseInt(in.readLine())]++;
		}
		
		for(int i = 1; i < 10001; i++) {
			int num = arr[i];
			for (int j = 0; j < num; j++) {
				sb.append(i).append("\n");
			}
		}
		
		System.out.println(sb);
	}

}
