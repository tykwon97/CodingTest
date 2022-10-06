package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N2579_Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int[] stairs = new int[N+1];
		for (int i = 1; i <= N; i++) {
			stairs[i] = Integer.parseInt(in.readLine());
		}
		stairs[0] = 0;
		
		int[] result = new int[N+1];
		result[N] = stairs[N];
		result[N-1] = stairs[N-1]+stairs[N];
		result[N-2] = Math.max(stairs[N-1]+stairs[N],stairs[N-1]+stairs[N-2]);
		result[N-2] = Math.max(result[N-2],stairs[N]+stairs[N-2]);
		
		for (int i = N-3; i >= 1; i--) {
			result[i] = Math.max(stairs[i+1]+result[i+2], stairs[i]+stairs[i+1]-result[i+3]);				
		}
		System.out.println(Arrays.toString(result));
		Arrays.sort(result);
		System.out.println(result[N]);
	}
}
