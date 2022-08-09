package d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N9229_Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int arr[] = new int[n];
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			int maxValue = -1;
			for (int i = n-1; i >=0; i--) {
				for (int j=i-1; j>=0; j--) {
					int value = arr[i]+arr[j];
					if(maxValue>=value)
						break;
					if(value>maxValue && value <= m) {
						maxValue = value;
						break;
					}
				}
			}
			sb.append("#").append(test_case).append(" ").append(maxValue).append("\n");
		}
		System.out.println(sb);
	}
}
