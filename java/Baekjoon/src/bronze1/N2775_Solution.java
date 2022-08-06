package bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2775_Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(in.readLine());
		
		int[][] arr = new int[15][15];

		arr[0] = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		
		for (int i = 1; i < 15; i++) {
			for (int j = 0; j < 15; j++) { //굳이 삼중 for문을 사용할 필요가 없었다. 생각하자!!
					if(j==0)
						arr[i][j] = 1;
					else	
						arr[i][j] += arr[i-1][j] + arr[i][j-1];
			}
		}
		
		for (int i = 0; i < tc; i++) {
			int k = Integer.parseInt(in.readLine());
			int n = Integer.parseInt(in.readLine());
			
			sb.append(arr[k][n-1]).append("\n");
		}

		System.out.println(sb);
	}
}