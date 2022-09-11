package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N9095_Solution {
	public static int n;
	public static int c;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int i = 0; i < T; i++) {
			n = Integer.parseInt(in.readLine());
			c=0;
			comb(n,0);
			sb.append(c).append("\n");
		}
		System.out.println(sb);
	}

	private static void comb(int count, int result) {
		if(result>n)
			return;
		if(result == n) {
			c++;
			return;
		}
		if(count == 0) {
			return;
		}
		// TODO Auto-generated method stub
		for (int i = 1; i <= 3; i++) {
			comb(count-1, result + i);
		}
	}
}
