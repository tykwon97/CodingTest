package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N11659_Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[n];
		
		st = new StringTokenizer(in.readLine()," ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(i == 0)
				arr[i] = arr[0];
			else
				arr[i] = arr[i-1]+arr[i];
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine()," ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int total=0;
			if(s == 1) {
				total = arr[e-1];
			}else { 
				total = arr[e-1]- arr[s-2];
			}
			sb.append(total+"\n");
		}
		System.out.println(sb);
	}
}
