package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N2579_Main2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int[] stairs = new int[N+2];
		for (int i = 1; i <= N; i++) {
			stairs[i] = Integer.parseInt(in.readLine());
		}
		if(N == 1) {
			System.out.println(stairs[1]);
			return;
		}
		int[][] result = new int[N+2][2];
		result[N+1][0] = 0;
		result[N+1][1] = 0;
		result[N][0] = stairs[N];
		result[N][1] = result[N][0];
		result[N-1][0] = stairs[N-1]+stairs[N];
		result[N-1][1] = result[N-1][0];
		result[N-2][0] = Math.max(stairs[N]+stairs[N-1],stairs[N]+stairs[N-2]);
		result[N-2][1] = result[N-2][0];

		for (int i = N-3; i >= 1; i--) {
			
			int a = stairs[i]+stairs[i+1]+result[i+3][0];
			int b = stairs[i]+result[i+2][0];
			int c = result[i+1][0];
			result[i][0] = Math.max(a, b);	
			result[i][1] = c;	
		}
		
//		for (int i = 0; i < N+2; i++) {
//			System.out.print(result[i][0]+" ");
//		}System.out.println();
//		for (int i = 0; i < N+2; i++) {
//			System.out.print(result[i][1]+" ");
//		}System.out.println();
		
		System.out.println(Math.max(result[1][0], result[1][1]));
	}
}
