package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N2579_Main {
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
		int[] result = new int[N+2];
		result[N+1] = 0;
		result[N] = stairs[N];
		result[N-1] = stairs[N-1]+stairs[N];
		result[N-2] = Math.max(stairs[N]+stairs[N-1],stairs[N]+stairs[N-2]);

		for (int i = N-3; i >= 1; i--) {
			int a = 0, b = 0, c = 0;
			if(result[i+3] != result[i+4] || (result[i+3] == result[i+4] && stairs[i+3] > stairs[i+4]))
				a = stairs[i]+stairs[i+1]+result[i+3];
			if(result[i+2] != result[i+3] || (result[i+2] == result[i+3] && stairs[i+2] > stairs[i+3]))
				b = stairs[i]+result[i+2];
			c = result[i+1];
			result[i] = Math.max(a, b);	
			result[i] = Math.max(result[i], c);	
		}
//		System.out.println(Arrays.toString(result));
		Arrays.sort(result);
		System.out.println(result[N+1]);
	}
}
