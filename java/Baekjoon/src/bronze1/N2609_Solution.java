package bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;

public class N2609_Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		//유클리드 호제법....외우자...그냥..
		int a=n,b=m;
		while(b!=0) {
			int x = a%b;
			
			a = b;
			b = x;
		}
		
		sb.append(a+"\n");
		sb.append(n*m/a);
		System.out.println(sb);
	}
}
