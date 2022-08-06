package bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2775_Solution2 {
	public static int chairman(int k, int n){
		if(n==1) {
			return 1;
		}
		if(k==0) {
			return n;
		}
		
		return chairman(k-1,n) + chairman(k,n-1);
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(in.readLine());
		
		for (int i = 0; i < tc; i++) {
			int k = Integer.parseInt(in.readLine());
			int n = Integer.parseInt(in.readLine());
			
			System.out.println(chairman(k,n));
		}

		System.out.println(sb);
	}
}